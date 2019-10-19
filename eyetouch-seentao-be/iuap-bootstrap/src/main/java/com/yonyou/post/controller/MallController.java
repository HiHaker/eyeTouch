package com.yonyou.post.controller;

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
     * 根据Id删除类型
     * @param type
     */
    @RequestMapping(value = "/deleteCtypeById", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteCtypeById(
            @RequestParam String type
    ){
        mallService.deleteCtypeById(type);
        return "success";
    }

    /**
     * 根据Id删除品牌
     * @param brand
     */
    @RequestMapping(value = "/deleteCbrandById", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteCbrandById(
            @RequestParam String brand
    ){
        mallService.deleteCbrandById(brand);
        return "success";
    }

    /**
     * 根据Id删除功效
     * @param effacicy
     */
    @RequestMapping(value = "/deleteEffacicyById", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteEffacicyById(
            @RequestParam String effacicy
    ){
        mallService.deleteEffacicyById(effacicy);
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
        Commodity commodity = commodityService.getAssoVo(commodity_ID).getEntity();
        // 封装成帖子列表
        List<Object> commodityList = new ArrayList<>();
        // 转换为DTO
        commodityList.add(commodityService.switchDTO(commodity));
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
        // 封装成帖子列表
        List<Object> commodityList = new ArrayList<>();
        commodityList.add(commodityService.switchDTO(commodity));
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

    /**
     * 得到用户收藏的所有商品
     * @param user_ID
     * @return
     */
    @RequestMapping(value = "/getAllCommodityFavorites", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityFavorites(
            @RequestParam String user_ID
    ){
        return this.buildSuccess(mallService.encapsulateCommodityLogin(mallService.getAllCommodityFavorites(user_ID), user_ID));
    }

    /**
     * 商品的模糊查询
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/getAllCommodityLikeSearch", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityLikeSearch(
            @RequestParam String keyword
    ){
        return this.buildSuccess(mallService.encapsulateCommodity(mallService.getAllCommodityLikeSearch(keyword)));
    }

    /**
     * 商品的模糊查询(登录)
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/getAllCommodityLikeSearchLogin", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityLikeSearch(
            @RequestParam String keyword, String user_ID
    ){
        return this.buildSuccess(mallService.encapsulateCommodityLogin(mallService.getAllCommodityLikeSearch(keyword),user_ID));
    }

}
