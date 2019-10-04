package com.yonyou.commodity.service;
import java.util.ArrayList;
import java.util.List;

import com.yonyou.commodity.api.CommodityQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.commodity.dao.CommodityMapper;
import com.yonyou.commodity.po.Commodity;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.commodity.service.CommodityService")
public class CommodityService extends GenericAssoService<Commodity,String>{

    private CommodityMapper commodityMapper;

    @Autowired
    CommodityQueryService commodityQueryService;

    @Autowired
    public void setCommodityMapper(CommodityMapper commodityMapper) {
        this.commodityMapper = commodityMapper;
        super.setGenericMapper(commodityMapper);
    }

    /**
     * 可插拔设计
     * @return 向父类 提供可插拔的特性声明
     */
    @Override
    protected ServiceFeature[] getFeats() {
        return new ServiceFeature[]{ AUDIT,I18N_ENUM };
    }

    /**
     * 根据商品的id删除商品
     * @param commodity_ID
     */
    public void deleteCommodityById(String commodity_ID){
        List<String> commodityIds = new ArrayList<>();
        commodityIds.add(commodity_ID);
        commodityMapper.deleteByIds(commodityIds);
    }

    /**
     * 得到全部的商品列表
     * @return
     */
    public List<Object> getAllCommodity(){
        com.yonyou.commodity.dto.SimpleSearchDTO commoditySimpleDto = new
                com.yonyou.commodity.dto.SimpleSearchDTO();
        List commodityList = commodityQueryService.listCommodity(commoditySimpleDto.toSearchParams(Commodity.class));
        return commodityList;
    }

    /**
     * 根据商品类型获得全部商品
     * @return
     */
    public List<Object> getAllCommodityByType(String type){
        com.yonyou.commodity.dto.SimpleSearchDTO commoditySimpleDto = new
                com.yonyou.commodity.dto.SimpleSearchDTO();
        commoditySimpleDto.setSearch_type(type);
        List commodityList = commodityQueryService.listCommodity(commoditySimpleDto.toSearchParams(Commodity.class));
        return commodityList;
    }

    /**
     * 根据商品品牌获得全部商品
     * @return
     */
    public List<Object> getAllCommodityByBrand(String brand){
        com.yonyou.commodity.dto.SimpleSearchDTO commoditySimpleDto = new
                com.yonyou.commodity.dto.SimpleSearchDTO();
        commoditySimpleDto.setSearch_brand(brand);
        List commodityList = commodityQueryService.listCommodity(commoditySimpleDto.toSearchParams(Commodity.class));
        return commodityList;
    }

    /**
     * 根据商品功效获得全部商品
     * @return
     */
    public List<Object> getAllCommodityByEffacicy(String effacicy){
        com.yonyou.commodity.dto.SimpleSearchDTO commoditySimpleDto = new
                com.yonyou.commodity.dto.SimpleSearchDTO();
        commoditySimpleDto.setSearch_effacicy(effacicy);
        List commodityList = commodityQueryService.listCommodity(commoditySimpleDto.toSearchParams(Commodity.class));
        return commodityList;
    }

    /**
     * 根据商品类型和商品功效获得全部商品
     * @return
     */
    public List<Object> getAllCommodityByTypeAndEffacicy(String type, String effacicy){
        com.yonyou.commodity.dto.SimpleSearchDTO commoditySimpleDto = new
                com.yonyou.commodity.dto.SimpleSearchDTO();
        commoditySimpleDto.setSearch_type(type);
        commoditySimpleDto.setSearch_effacicy(effacicy);
        List commodityList = commodityQueryService.listCommodity(commoditySimpleDto.toSearchParams(Commodity.class));
        return commodityList;
    }

    /**
     * 根据商品类型和商品品牌获得全部商品
     * @return
     */
    public List<Object> getAllCommodityByTypeAndBrand(String type, String brand){
        com.yonyou.commodity.dto.SimpleSearchDTO commoditySimpleDto = new
                com.yonyou.commodity.dto.SimpleSearchDTO();
        commoditySimpleDto.setSearch_type(type);
        commoditySimpleDto.setSearch_brand(brand);
        List commodityList = commodityQueryService.listCommodity(commoditySimpleDto.toSearchParams(Commodity.class));
        return commodityList;
    }

    /**
     * 根据商品功效和商品品牌获得全部商品
     * @return
     */
    public List<Object> getAllCommodityByEffacicyAndBrand(String effacicy, String brand){
        com.yonyou.commodity.dto.SimpleSearchDTO commoditySimpleDto = new
                com.yonyou.commodity.dto.SimpleSearchDTO();
        commoditySimpleDto.setSearch_effacicy(effacicy);
        commoditySimpleDto.setSearch_brand(brand);
        List commodityList = commodityQueryService.listCommodity(commoditySimpleDto.toSearchParams(Commodity.class));
        return commodityList;
    }

    /**
     * 根据商品类别和商品功效和商品品牌获得全部商品
     * @return
     */
    public List<Object> getAllCommodityByTypeAndEffacicyAndBrand(String type, String effacicy, String brand){
        com.yonyou.commodity.dto.SimpleSearchDTO commoditySimpleDto = new
                com.yonyou.commodity.dto.SimpleSearchDTO();
        commoditySimpleDto.setSearch_type(brand);
        commoditySimpleDto.setSearch_effacicy(effacicy);
        commoditySimpleDto.setSearch_brand(brand);
        List commodityList = commodityQueryService.listCommodity(commoditySimpleDto.toSearchParams(Commodity.class));
        return commodityList;
    }
}