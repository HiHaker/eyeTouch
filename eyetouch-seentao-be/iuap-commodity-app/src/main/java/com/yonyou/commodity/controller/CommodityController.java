package com.yonyou.commodity.controller;
import com.yonyou.commodity.po.Commodity;
import com.yonyou.commodity.dto.CommodityDTO;
import com.yonyou.commodity.service.CommodityService;
import com.yonyou.commodity.dto.SimpleSearchDTO;
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
* 说明：商品基础Controller——提供数据增(CREATE)、删(DELETE、改(UPDATE)、查(READ)等rest接口
* @author  
* @date 2019-9-20 9:52:28
*/
@CrossOrigin
@RestController("com.yonyou.commodity.controller.CommodityController")
@RequestMapping(value = "/commodity/commodity")
public class CommodityController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(CommodityController.class);
    private final static  int PAGE_FLAG_LOAD_ALL = 1;
    private CommodityService service;

    @Autowired
    public void setCommodityService(CommodityService service) {
        this.service = service;
    }
    /**
    * 分页查询
    * @return 分页集合
    */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(@RequestParam( defaultValue = "0")Integer pageIndex,@RequestParam( defaultValue = "10")Integer pageSize
            ,@RequestParam(required = false) String search_content
            ,@RequestParam(required = false) String search_effacicy
            ,@RequestParam(required = false) String search_name
            ,@RequestParam(required = false) String search_brand
            ,@RequestParam(required = false) String search_type
            ,@RequestParam(required = false) String search_link
    ) {
        SimpleSearchDTO searchDTO = new SimpleSearchDTO();
            searchDTO.setSearch_content(search_content);
            searchDTO.setSearch_effacicy(search_effacicy);
            searchDTO.setSearch_name(search_name);
            searchDTO.setSearch_brand(search_brand);
            searchDTO.setSearch_type(search_type);
            searchDTO.setSearch_link(search_link);
        PageRequest pageRequest;
        Sort sort= SearchUtil.getSortFromSortMap(searchDTO.getSorts(),Commodity.class);
        try {
            if (pageSize== PAGE_FLAG_LOAD_ALL) {
                pageRequest =
                        PageRequest.of(pageIndex,Integer.MAX_VALUE-1,sort);
            }else{
                pageRequest=PageRequest.of(pageIndex,pageSize,sort);
            }
            Page<Commodity> page = this.service.selectAllByPage(pageRequest, searchDTO.toSearchParams(Commodity.class) );
            List<CommodityDTO> dtoList = new ArrayList<>();
            for (Commodity po:page.getContent()){
                CommodityDTO dto = new CommodityDTO();
                BeanUtils.copyProperties(po,dto);
                dtoList.add(dto);
            }
            Page<CommodityDTO> dtoPage = new UcfPage<>(dtoList,page.getPageable(),page.getTotalElements());
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
        GenericAssoVo<Commodity> vo = service.getAssoVo( id);
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
    public Object  saveAssoVo(@RequestBody GenericAssoVo<Commodity> vo){
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
    public Object  deleAssoVo(@RequestBody Commodity... entities){
        if (entities.length==0){
            return this.buildGlobalError("deleting entity must not be empty");
        }
        Associative annotation = entities[0].getClass().getAnnotation(Associative.class);
        if (annotation != null && !StringUtils.isEmpty(annotation.fkName())) {
            int result =0;
            for (Commodity entity:entities){
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
     * 根据商品的id删除商品
     * @param commodity_ID
     */
    @RequestMapping(value = "/deleteCommodityById", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCommodityById(
            @RequestParam(required = false) String commodity_ID
    ){
        service.deleteCommodityById(commodity_ID);
    }

    /**
     * 获取全部商品列表
     * @return
     */
    @RequestMapping(value = "/getAllCommodity", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodity(){
        return this.buildSuccess(service.getAllCommodity());
    }

    /**
     * 根据商品类型获得全部商品
     * @return
     */
    @RequestMapping(value = "/getAllCommodityByType", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodity(
            @RequestParam(required = false) String type
    ){
        return this.buildSuccess(service.getAllCommodityByType(type));
    }

    /**
     * 根据商品品牌获得全部商品
     * @return
     */
    @RequestMapping(value = "/getAllCommodityByBrand", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityByBrand(
            @RequestParam(required = false) String brand
    ){
        return this.buildSuccess(service.getAllCommodityByBrand(brand));
    }

    /**
     * 根据商品功效获得全部商品
     * @return
     */
    @RequestMapping(value = "/getAllCommodityByEffacicy", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityByEffacicy(
            @RequestParam(required = false) String effacicy
    ){
        return this.buildSuccess(service.getAllCommodityByEffacicy(effacicy));
    }

    /**
     * 根据商品类型和商品功效获得全部商品
     * @return
     */
    @RequestMapping(value = "/getAllCommodityByTypeAndEffacicy", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityByTypeAndEffacicy(
            @RequestParam(required = false) String type, String effacicy
    ){
        return this.buildSuccess(service.getAllCommodityByTypeAndEffacicy(type, effacicy));
    }

    /**
     * 根据商品类型和商品品牌获得全部商品
     * @return
     */
    @RequestMapping(value = "/getAllCommodityByTypeAndBrand", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityByTypeAndBrand(
            @RequestParam(required = false) String type, String brand
    ){
        return this.buildSuccess(service.getAllCommodityByTypeAndBrand(type, brand));
    }

    /**
     * 根据商品功效和商品品牌获得全部商品
     * @return
     */
    @RequestMapping(value = "/getAllCommodityByEffacicyAndBrand", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityByEffacicyAndBrand(
            @RequestParam(required = false) String effacicy, String brand
    ){
        return this.buildSuccess(service.getAllCommodityByEffacicyAndBrand(effacicy, brand));
    }

    /**
     * 根据商品类别和商品功效和商品品牌获得全部商品
     * @return
     */
    @RequestMapping(value = "/getAllCommodityByTypeAndEffacicyAndBrand", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityByTypeAndEffacicyAndBrand(
            @RequestParam(required = false) String type, String effacicy, String brand
    ){
        return this.buildSuccess(service.getAllCommodityByTypeAndEffacicyAndBrand(type, effacicy, brand));
    }

    /**
    * 单条添加
    * @param entity 业务实体
    * @return 标准JsonResponse结构
    */
    @RequestMapping(value = "/insertSelective", method = {RequestMethod.POST,RequestMethod.PATCH})
    @ResponseBody
    public Object insertSelective(@RequestBody Commodity entity) {
            entity = this.service.save(entity,true,true);
            CommodityDTO dto = new CommodityDTO();
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
    public Object updateSelective(@RequestBody Commodity entity) {
                        entity = this.service.save(entity,false,true);
            CommodityDTO dto = new CommodityDTO();
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
    public Object deleteBatch(@RequestBody List<Commodity> listData) throws Exception {
        this.service.deleteBatch(listData);
        return super.buildSuccess();
    }
}

