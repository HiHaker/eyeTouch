package com.yonyou.post.controller;

import com.yonyou.commodity.dto.CommodityDTO;
import com.yonyou.commodity.po.Commodity;
import com.yonyou.commodity.service.CommodityService;
import com.yonyou.post.service.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/10/16 0016
 * BY Jianlong
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/mall/mall")
public class MallController extends BaseController{

    @Autowired
    MallService mallService;
    @Autowired
    CommodityService commodityService;

    /**
     * 根据商品的id删除商品
     * @param commodity_ID
     */
    @RequestMapping(value = "/deleteCommodityById", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteCommodityById(
            @RequestParam String commodity_ID
    ){
        mallService.deleteCommodityById(commodity_ID);
        return "success";
    }

    /**
     * 根据商品id获得商品对象
     * @param commodity_ID
     * @return
     */
    @RequestMapping(value = "/getCommodityById", method = RequestMethod.GET)
    @ResponseBody
    public Object getCommodityById(
            @RequestParam String commodity_ID
    ){
        // 转换为DTO
        Commodity commodity = commodityService.getAssoVo(commodity_ID).getEntity();
        CommodityDTO cd = new CommodityDTO();
        cd.setId(commodity.getId());
        cd.setName(commodity.getName());
        cd.setPrice(commodity.getPrice());
        cd.setLink(commodity.getLink());
        cd.setType(commodity.getType());
        cd.setBrand(commodity.getBrand());
        cd.setEffacicy(commodity.getEffacicy());
        cd.setCreateUser(commodity.getCreateUser());
        cd.setCreateTime(commodity.getCreateTime());
        cd.setDr(commodity.getDr());
        cd.setTs(commodity.getTs());
        cd.setTenantId(commodity.getTenantId());
        cd.setLastModifyUser(commodity.getLastModifyUser());
        cd.setLastModified(commodity.getLastModified());
        // 封装成帖子列表
        List<Object> commodityList = new ArrayList<>();
        commodityList.add(cd);
        return this.buildSuccess(mallService.encapsulateCommodity(commodityList));
    }

    /**
     * 根据商品id获得商品对象(登录)
     * @param commodity_ID
     * @param user_ID
     * @return
     */
    @RequestMapping(value = "/getCommodityByIdLogin", method = RequestMethod.GET)
    @ResponseBody
    public Object getCommodityByIdLogin(
            @RequestParam String commodity_ID, String user_ID
    ){
        // 转换为DTO
        Commodity commodity = commodityService.getAssoVo(commodity_ID).getEntity();
        CommodityDTO cd = new CommodityDTO();
        cd.setId(commodity.getId());
        cd.setName(commodity.getName());
        cd.setPrice(commodity.getPrice());
        cd.setLink(commodity.getLink());
        cd.setType(commodity.getType());
        cd.setBrand(commodity.getBrand());
        cd.setEffacicy(commodity.getEffacicy());
        cd.setCreateUser(commodity.getCreateUser());
        cd.setCreateTime(commodity.getCreateTime());
        cd.setDr(commodity.getDr());
        cd.setTs(commodity.getTs());
        cd.setTenantId(commodity.getTenantId());
        cd.setLastModifyUser(commodity.getLastModifyUser());
        cd.setLastModified(commodity.getLastModified());
        // 封装成帖子列表
        List<Object> commodityList = new ArrayList<>();
        commodityList.add(cd);
        return this.buildSuccess(mallService.encapsulateCommodityLogin(commodityList,user_ID));
    }

    /**
     * 获取全部的商品列表
     * @return
     */
    @RequestMapping(value = "/getAllCommodity", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodity(){
        return this.buildSuccess(mallService.encapsulateCommodity(commodityService.getAllCommodity()));
    }

    /**
     * 获取全部的商品列表(登录)
     * @param user_ID
     * @return
     */
    @RequestMapping(value = "/getAllCommodityLogin", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityLogin(
            @RequestParam String user_ID
    ){
        return this.buildSuccess(mallService.encapsulateCommodityLogin(commodityService.getAllCommodity(), user_ID));
    }

    /**
     * 根据类别获取全部的商品列表
     * @param type
     * @return
     */
    @RequestMapping(value = "/getAllCommodityByType", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityByType(
            @RequestParam String type
    ){
        return this.buildSuccess(mallService.encapsulateCommodity(commodityService.getAllCommodityByType(type)));
    }

    /**
     * 根据类别获取全部的商品列表(登录)
     * @param user_ID
     * @param type
     * @return
     */
    @RequestMapping(value = "/getAllCommodityByTypeLogin", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityByTypeLogin(
            @RequestParam String user_ID, String type
    ){
        return this.buildSuccess(mallService.encapsulateCommodityLogin(commodityService.getAllCommodityByType(type),user_ID));
    }

    /**
     * 根据品牌获取全部的商品列表
     * @param brand
     * @return
     */
    @RequestMapping(value = "/getAllCommodityByBrand", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityByBrand(
            @RequestParam String brand
    ){
        return this.buildSuccess(mallService.encapsulateCommodity(commodityService.getAllCommodityByBrand(brand)));
    }

    /**
     * 根据品牌获取全部的商品列表(登录)
     * @param user_ID
     * @param brand
     * @return
     */
    @RequestMapping(value = "/getAllCommodityByBrandLogin", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityByBrandLogin(
            @RequestParam String user_ID, String brand
    ){
        return this.buildSuccess(mallService.encapsulateCommodityLogin(commodityService.getAllCommodityByBrand(brand),user_ID));
    }

    /**
     * 根据功效获取全部的商品列表
     * @param effacicy
     * @return
     */
    @RequestMapping(value = "/getAllCommodityByEffacicy", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityByEffacicy(
            @RequestParam String effacicy
    ){
        return this.buildSuccess(mallService.encapsulateCommodity(commodityService.getAllCommodityByEffacicy(effacicy)));
    }

    /**
     * 根据功效获取全部的商品列表(登录)
     * @param user_ID
     * @param effacicy
     * @return
     */
    @RequestMapping(value = "/getAllCommodityByEffacicyLogin", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityByEffacicyLogin(
            @RequestParam String user_ID, String effacicy
    ){
        return this.buildSuccess(mallService.encapsulateCommodityLogin(commodityService.getAllCommodityByEffacicy(effacicy),user_ID));
    }

}
