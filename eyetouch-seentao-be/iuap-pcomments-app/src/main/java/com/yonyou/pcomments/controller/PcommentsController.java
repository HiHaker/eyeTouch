package com.yonyou.pcomments.controller;
import com.yonyou.pcomments.po.Pcomments;
import com.yonyou.pcomments.dto.PcommentsDTO;
import com.yonyou.pcomments.service.PcommentsService;
import com.yonyou.pcomments.dto.SimpleSearchDTO;
import com.yonyou.iuap.baseservice.service.util.SearchUtil;
import com.yonyou.iuap.baseservice.entity.annotation.Associative;
import com.yonyou.iuap.baseservice.vo.GenericAssoVo;
import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.mvc.type.JsonResponse;
import com.yonyou.iuap.ucf.dao.support.UcfPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
/**
* 说明：帖子评论基础Controller——提供数据增(CREATE)、删(DELETE、改(UPDATE)、查(READ)等rest接口
* @author  
* @date 2019-10-2 20:07:08
*/
@CrossOrigin
@RestController("com.yonyou.pcomments.controller.PcommentsController")
@RequestMapping(value = "/pcomments/pcomments")
public class PcommentsController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(PcommentsController.class);
    private final static  int PAGE_FLAG_LOAD_ALL = 1;
    private PcommentsService service;

    @Autowired
    public void setPcommentsService(PcommentsService service) {
        this.service = service;
    }
    /**
    * 分页查询
    * @return 分页集合
    */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(@RequestParam( defaultValue = "0")Integer pageIndex,@RequestParam( defaultValue = "1000")Integer pageSize
            ,@RequestParam(required = false) String search_auid
            ,@RequestParam(required = false) String search_buid
            ,@RequestParam(required = false) String search_time
            ,@RequestParam(required = false) String search_pid
            ,@RequestParam(required = false) String search_content
    ) {
        SimpleSearchDTO searchDTO = new SimpleSearchDTO();
            searchDTO.setSearch_auid(search_auid);
            searchDTO.setSearch_buid(search_buid);
            searchDTO.setSearch_time(search_time);
            searchDTO.setSearch_pid(search_pid);
            searchDTO.setSearch_content(search_content);
        PageRequest pageRequest;
        Sort sort= SearchUtil.getSortFromSortMap(searchDTO.getSorts(),Pcomments.class);
        try {
            if (pageSize== PAGE_FLAG_LOAD_ALL) {
                pageRequest =
                        PageRequest.of(pageIndex,Integer.MAX_VALUE-1,sort);
            }else{
                pageRequest=PageRequest.of(pageIndex,pageSize,sort);
            }
            Page<Pcomments> page = this.service.selectAllByPage(pageRequest, searchDTO.toSearchParams(Pcomments.class) );
            List<PcommentsDTO> dtoList = new ArrayList<>();
            for (Pcomments po:page.getContent()){
                PcommentsDTO dto = new PcommentsDTO();
                BeanUtils.copyProperties(po,dto);
                dtoList.add(dto);
            }
            Page<PcommentsDTO> dtoPage = new UcfPage<>(dtoList,page.getPageable(),page.getTotalElements());
            return this.buildSuccess(dtoPage);
        } catch (Exception exp) {
            logger.error("exp", exp);
            return this.buildError("msg", "Error query database", RequestStatusEnum.FAIL_FIELD);
        }
    }


     /**
     * 主子表合并处理--主表单条查询
     * @return GenericAssoVo ,entity中保存的是单条主表数据,sublist中保存的是字表数据,一次性全部加载
     */
    @RequestMapping(value = "/getAssoVo" , method = RequestMethod.GET)
    @ResponseBody
    public Object  getAssoVo(@RequestParam(value = "id")   Serializable  id){
        if (null==id){ return buildSuccess();}
        GenericAssoVo<Pcomments> vo = service.getAssoVo( id);
        JsonResponse result = this.buildSuccess("entity",vo.getEntity());//保证入参出参结构一致
        result.getDetailMsg().putAll(vo.getSublist());
        return  result;
    }
    /**
     * 主子表合并处理--主表单条保存
     * @param vo GenericAssoVo ,entity中保存的是单条主表数据,sublist中保存的是子表数据
     * @return 主表的业务实体
     */
    @RequestMapping(value = "/saveAssoVo", method = RequestMethod.POST)
    @ResponseBody
    public Object  saveAssoVo(@RequestBody GenericAssoVo<Pcomments> vo){
        Associative annotation= vo.getEntity().getClass().getAnnotation(Associative.class);
        if (annotation == null || StringUtils.isEmpty(annotation.fkName())) {
            return buildError("", "No entity got @Associative nor fkName", RequestStatusEnum.FAIL_FIELD);
        }
        Object result =service.saveAssoVo(vo);
        return this.buildSuccess(result) ;
    }

    /**
     * 主子表合并处理--主表单条删除,若取消级联删除请在主实体上注解改为@Associative(fkName = "NA",deleteCascade = false)
     * @param entities 待删除业务实体
     * @return 删除成功的实体
     */
    @RequestMapping(value = "/deleAssoVo", method = RequestMethod.POST)
    @ResponseBody
    public Object  deleAssoVo(@RequestBody Pcomments... entities){
        if (entities.length==0){
            return this.buildGlobalError("deleting entity must not be empty");
        }
        Associative annotation = entities[0].getClass().getAnnotation(Associative.class);
        if (annotation != null && !StringUtils.isEmpty(annotation.fkName())) {
            int result =0;
            for (Pcomments entity:entities){
                if (StringUtils.isEmpty(entity.getId())) {
                    return this.buildError("ID", "ID field is empty:"+entity.toString(), RequestStatusEnum.FAIL_FIELD);
                } else {
                    result += this.service.deleAssoVo(entity);
                }
            }
            return this.buildSuccess(result + " rows(entity and its subEntities) has been deleted!");
        } else {
            return this.buildError("", "Nothing got @Associative nor fkName", RequestStatusEnum.FAIL_FIELD);
        }
    }

    /**
     * 根据a用户（主用户，如果用户是对帖子评论，则默认使用a用户表示）id删除其全部评论记录
     * @param auser_ID
     */
    @RequestMapping(value = "/deleteByAUserId", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteByAUserId(
            @RequestParam(required = false) String auser_ID
    ){
        service.deleteByAUserId(auser_ID);
    }

    /**
     * 根据b用户（次用户，如果用户是对用户的评论，则评论的人为a用户，被评论的人为b用户）id删除其全部评论记录
     * @param buser_ID
     */
    @RequestMapping(value = "/deleteByBUserId", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteByBUserId(
            @RequestParam(required = false) String buser_ID
    ){
        service.deleteByBUserId(buser_ID);
    }

    /**
     * 根据帖子id删除其全部评论记录
     * @param post_ID
     */
    @RequestMapping(value = "/deleteByPostId", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteByPostId(
            @RequestParam(required = false) String post_ID
    ){
        service.deleteByPostId(post_ID);
    }

    /**
     * 根据a用户id和b用户id删除其全部评论记录
     * @param auser_ID
     * @param buser_ID
     */
    @RequestMapping(value = "/deleteByAUserIdAndBUserId", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteByAUserIdAndBUserId(
            @RequestParam(required = false) String auser_ID, String buser_ID
    ){
        service.deleteByAUserIdAndBUserId(auser_ID, buser_ID);
    }

    /**
     * 根据a用户id和帖子id删除其全部评论记录
     * @param auser_ID
     * @param post_ID
     */
    @RequestMapping(value = "/deleteByAUserIdAndPostId", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteByAUserIdAndPostId(
            @RequestParam(required = false) String auser_ID, String post_ID
    ){
        service.deleteByAUserIdAndPostId(auser_ID, post_ID);
    }

    /**
     * 根据b用户id和帖子id删除其全部评论记录
     * @param buser_ID
     * @param post_ID
     */
    @RequestMapping(value = "/deleteByBUserIdAndPostId", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteByBUserIdAndPostId(
            @RequestParam(required = false) String buser_ID, String post_ID
    ){
        service.deleteByBUserIdAndPostId(buser_ID, post_ID);
    }

    /**
     * 根据a用户的id得到其所有评论记录
     * @param auser_ID
     * @return
     */
    @RequestMapping(value = "/getAllAUsersByAUid", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllAUsersByAUid(
            @RequestParam(required = false) String auser_ID
    ){
        return this.buildSuccess(service.getAllAUsersByAUid(auser_ID));
    }

    /**
     * 根据b用户的id得到其所有被评论记录
     * @param buser_ID
     * @return
     */
    @RequestMapping(value = "/getAllBUsersByBUid", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllBUsersByBUid(
            @RequestParam(required = false) String buser_ID
    ){
        return this.buildSuccess(service.getAllBUsersByBUid(buser_ID));
    }

    /**
     * 根据a用户的id和b用户的id得到其所有互动评论记录
     * @param auser_ID
     * @param buser_ID
     * @return
     */
    @RequestMapping(value = "/getAllABUsersByAUidAndBUid", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllABUsersByAUidAndBUid(
            @RequestParam(required = false) String auser_ID, String buser_ID
    ){
        return this.buildSuccess(service.getAllABUsersByAUidAndBUid(auser_ID, buser_ID));
    }

    /**
     * 根据帖子的id得到其所有互动评论记录
     * @param post_ID
     * @return
     */
    @RequestMapping(value = "/getAllByPostId", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllByPostId(
            @RequestParam(required = false) String post_ID
    ){
        return this.buildSuccess(service.getAllByPostId(post_ID));
    }

    /**
    * 单条添加
    * @param entity 业务实体
    * @return 标准JsonResponse结构
    */
    @RequestMapping(value = "/insertSelective", method = {RequestMethod.POST,RequestMethod.PATCH})
    @ResponseBody
    public Object insertSelective(@RequestBody Pcomments entity) {
            entity = this.service.save(entity,true,true);
            PcommentsDTO dto = new PcommentsDTO();
        try {
            BeanUtils.copyProperties(entity,dto);
            return this.buildSuccess(dto);
        }catch(Exception exp) {
            return this.buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
        }
    }


    /**
    * 单条修改
    * @param entity 业务实体
    * @return 标准JsonResponse结构
    */
    @RequestMapping(value = "/updateSelective", method = {RequestMethod.POST,RequestMethod.PATCH})
    @ResponseBody
    public Object updateSelective(@RequestBody Pcomments entity) {
                        entity = this.service.save(entity,false,true);
            PcommentsDTO dto = new PcommentsDTO();
        try {
            BeanUtils.copyProperties(entity,dto);
            return this.buildSuccess(dto);
        }catch(Exception exp) {
            return this.buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
        }
    }


    /**
    * 批量删除
    * @param listData 业务实体列表
    * @return 标准JsonResponse结构
    * @throws Exception
    */
    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteBatch(@RequestBody List<Pcomments> listData) throws Exception {
        this.service.deleteBatch(listData);
        return super.buildSuccess();
    }
}

