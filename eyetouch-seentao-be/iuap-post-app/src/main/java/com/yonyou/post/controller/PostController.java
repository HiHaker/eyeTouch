package com.yonyou.post.controller;
import com.yonyou.post.po.Post;
import com.yonyou.post.dto.PostDTO;
import com.yonyou.post.service.PostService;
import com.yonyou.post.dto.SimpleSearchDTO;
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
* 说明：帖子基础Controller——提供数据增(CREATE)、删(DELETE、改(UPDATE)、查(READ)等rest接口
* @author  
* @date 2019-9-10 20:00:26
*/
@RestController("com.yonyou.post.controller.PostController")
@RequestMapping(value = "/post/post")
public class PostController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(PostController.class);
    private final static  int PAGE_FLAG_LOAD_ALL = 1;
    private PostService service;

    @Autowired
    public void setPostService(PostService service) {
        this.service = service;
    }
    /**
    * 分页查询
    * @return 分页集合
    */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(@RequestParam( defaultValue = "0")Integer pageIndex,@RequestParam( defaultValue = "10")Integer pageSize
            ,@RequestParam(required = false) String search_time
            ,@RequestParam(required = false) String search_content
            ,@RequestParam(required = false) String search_title
            ,@RequestParam(required = false) String search_type
            ,@RequestParam(required = false) String search_style
            ,@RequestParam(required = false) String search_uid
            ,@RequestParam(required = false) String search_fpid
    ) {
        SimpleSearchDTO searchDTO = new SimpleSearchDTO();
            searchDTO.setSearch_time(search_time);
            searchDTO.setSearch_content(search_content);
            searchDTO.setSearch_title(search_title);
            searchDTO.setSearch_type(search_type);
            searchDTO.setSearch_style(search_style);
            searchDTO.setSearch_uid(search_uid);
            searchDTO.setSearch_fpid(search_fpid);
        PageRequest pageRequest;
        Sort sort= SearchUtil.getSortFromSortMap(searchDTO.getSorts(),Post.class);
        try {
            if (pageSize== PAGE_FLAG_LOAD_ALL) {
                pageRequest =
                        PageRequest.of(pageIndex,Integer.MAX_VALUE-1,sort);
            }else{
                pageRequest=PageRequest.of(pageIndex,pageSize,sort);
            }
            Page<Post> page = this.service.selectAllByPage(pageRequest, searchDTO.toSearchParams(Post.class) );
            List<PostDTO> dtoList = new ArrayList<>();
            for (Post po:page.getContent()){
                PostDTO dto = new PostDTO();
                BeanUtils.copyProperties(po,dto);
                dtoList.add(dto);
            }
            Page<PostDTO> dtoPage = new UcfPage<>(dtoList,page.getPageable(),page.getTotalElements());
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
        GenericAssoVo<Post> vo = service.getAssoVo( id);
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
    public Object  saveAssoVo(@RequestBody GenericAssoVo<Post> vo){
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
    public Object  deleAssoVo(@RequestBody Post... entities){
        if (entities.length==0){
            return this.buildGlobalError("deleting entity must not be empty");
        }
        Associative annotation = entities[0].getClass().getAnnotation(Associative.class);
        if (annotation != null && !StringUtils.isEmpty(annotation.fkName())) {
            int result =0;
            for (Post entity:entities){
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
     * 根据帖子的Id删除帖子
     * @param post_ID
     */
    @RequestMapping(value = "/deletePostById", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePostById(
            @RequestParam(required = false) String post_ID
    ){
        service.deletePostById(post_ID);
    }

    /**
     * 根据用户的id删除其全部帖子
     * @param user_ID
     */
    @RequestMapping(value = "/deletePostByUserId", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePostByUserId(
            @RequestParam(required = false) String user_ID
    ){
        service.deletePostByUserId(user_ID);
    }

    /**
     * 根据id查询帖子
     * @param post_ID
     * @return
     */
    @RequestMapping(value = "/getPostById", method = RequestMethod.GET)
    @ResponseBody
    public Object getPostById(
            @RequestParam(required = false) String post_ID
    ){
        GenericAssoVo<Post> postVo = service.getAssoVo(post_ID);
        return postVo.getEntity();
    }

    /**
     * 根据用户id查询帖子
     * @param user_ID
     * @return
     */
    public Object getPostByUserId(
            @RequestParam(required = false) String user_ID
    ){
        List postList = service.getPostByUserId(user_ID);
        return this.buildSuccess(postList);
    }

    /**
     * 根据type值查询帖子（1：图文，2：视频）
     * @param type
     * @return
     */
    public Object getPostByType(
            @RequestParam(required = false) String type
    ){
        List postList = service.getPostByType(type);
        return this.buildSuccess(postList);
    }

    /**
     * 根据style值查询帖子（0：心情随笔，1：妆容分享，2：眼妆教程，3：妆品推荐）
     * @param style
     * @return
     */
    public Object getPostByStyle(
            @RequestParam(required = false) String style
    ){
        List postList = service.getPostByStyle(style);
        return this.buildSuccess(postList);
    }

    /**
    * 单条添加
    * @param entity 业务实体
    * @return 标准JsonResponse结构
    */
    @RequestMapping(value = "/insertSelective", method = {RequestMethod.POST,RequestMethod.PATCH})
    @ResponseBody
    public Object insertSelective(@RequestBody Post entity) {
            entity = this.service.save(entity,true,true);
            PostDTO dto = new PostDTO();
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
    public Object updateSelective(@RequestBody Post entity) {
                        entity = this.service.save(entity,false,true);
            PostDTO dto = new PostDTO();
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
    public Object deleteBatch(@RequestBody List<Post> listData) throws Exception {
        this.service.deleteBatch(listData);
        return super.buildSuccess();
    }
}