package com.yonyou.user.controller;
import com.yonyou.user.po.User;
import com.yonyou.user.dto.UserDTO;
import com.yonyou.user.service.UserService;
import com.yonyou.user.dto.SimpleSearchDTO;
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
* 说明：用户基础Controller——提供数据增(CREATE)、删(DELETE、改(UPDATE)、查(READ)等rest接口
* @author  
* @date 2019-9-29 11:51:37
*/
@RestController("com.yonyou.user.controller.UserController")
@RequestMapping(value = "/user/user")
public class UserController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private final static  int PAGE_FLAG_LOAD_ALL = 1;
    private UserService service;

    @Autowired
    public void setUserService(UserService service) {
        this.service = service;
    }
    /**
    * 分页查询
    * @return 分页集合
    */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(@RequestParam( defaultValue = "0")Integer pageIndex,@RequestParam( defaultValue = "10")Integer pageSize
            ,@RequestParam(required = false) String search_avatar
            ,@RequestParam(required = false) String search_password
            ,@RequestParam(required = false) String search_sex
            ,@RequestParam(required = false) String search_register_date
            ,@RequestParam(required = false) String search_birthday
            ,@RequestParam(required = false) String search_nickname
            ,@RequestParam(required = false) String search_phone_number
            ,@RequestParam(required = false) String search_login_name
            ,@RequestParam(required = false) String search_profile
            ,@RequestParam(required = false) String search_mailbox
    ) {
        SimpleSearchDTO searchDTO = new SimpleSearchDTO();
            searchDTO.setSearch_avatar(search_avatar);
            searchDTO.setSearch_password(search_password);
            searchDTO.setSearch_sex(search_sex);
            searchDTO.setSearch_register_date(search_register_date);
            searchDTO.setSearch_birthday(search_birthday);
            searchDTO.setSearch_nickname(search_nickname);
            searchDTO.setSearch_phone_number(search_phone_number);
            searchDTO.setSearch_login_name(search_login_name);
            searchDTO.setSearch_profile(search_profile);
            searchDTO.setSearch_mailbox(search_mailbox);
        PageRequest pageRequest;
        Sort sort= SearchUtil.getSortFromSortMap(searchDTO.getSorts(),User.class);
        try {
            if (pageSize== PAGE_FLAG_LOAD_ALL) {
                pageRequest =
                        PageRequest.of(pageIndex,Integer.MAX_VALUE-1,sort);
            }else{
                pageRequest=PageRequest.of(pageIndex,pageSize,sort);
            }
            Page<User> page = this.service.selectAllByPage(pageRequest, searchDTO.toSearchParams(User.class) );
            List<UserDTO> dtoList = new ArrayList<>();
            for (User po:page.getContent()){
                UserDTO dto = new UserDTO();
                BeanUtils.copyProperties(po,dto);
                dtoList.add(dto);
            }
            Page<UserDTO> dtoPage = new UcfPage<>(dtoList,page.getPageable(),page.getTotalElements());
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
        GenericAssoVo<User> vo = service.getAssoVo( id);
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
    public Object  saveAssoVo(@RequestBody GenericAssoVo<User> vo){
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
    public Object  deleAssoVo(@RequestBody User... entities){
        if (entities.length==0){
            return this.buildGlobalError("deleting entity must not be empty");
        }
        Associative annotation = entities[0].getClass().getAnnotation(Associative.class);
        if (annotation != null && !StringUtils.isEmpty(annotation.fkName())) {
            int result =0;
            for (User entity:entities){
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
    * 单条添加
    * @param entity 业务实体
    * @return 标准JsonResponse结构
    */
    @RequestMapping(value = "/insertSelective", method = {RequestMethod.POST,RequestMethod.PATCH})
    @ResponseBody
    public Object insertSelective(@RequestBody User entity) {
            entity = this.service.save(entity,true,true);
            UserDTO dto = new UserDTO();
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
    public Object updateSelective(@RequestBody User entity) {
                        entity = this.service.save(entity,false,true);
            UserDTO dto = new UserDTO();
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
    public Object deleteBatch(@RequestBody List<User> listData) throws Exception {
        this.service.deleteBatch(listData);
        return super.buildSuccess();
    }
}

