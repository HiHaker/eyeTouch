package com.yonyou.cfavorites.service;
import java.util.List;

import com.yonyou.cfavorites.api.CfavoritesQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.cfavorites.dao.CfavoritesMapper;
import com.yonyou.cfavorites.po.Cfavorites;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.cfavorites.service.CfavoritesService")
public class CfavoritesService extends GenericAssoService<Cfavorites,String>{

    private CfavoritesMapper cfavoritesMapper;

    @Autowired
    CfavoritesQueryService cfavoritesQueryService;

    @Autowired
    public void setCfavoritesMapper(CfavoritesMapper cfavoritesMapper) {
        this.cfavoritesMapper = cfavoritesMapper;
        super.setGenericMapper(cfavoritesMapper);
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
     * 根据用户id删除其全部收藏记录
     * @param user_ID
     */
    public void deleteByUserId(String user_ID){
        com.yonyou.cfavorites.dto.SimpleSearchDTO cfavoritesSimpleDto = new
                com.yonyou.cfavorites.dto.SimpleSearchDTO();
        cfavoritesSimpleDto.setSearch_uid(user_ID);
        cfavoritesMapper.delete(cfavoritesSimpleDto.toSearchParams(Cfavorites.class));
    }

    /**
     * 根据商品id删除其全部收藏记录
     * @param commodity_ID
     */
    public void deleteByCommodityId(String commodity_ID){
        com.yonyou.cfavorites.dto.SimpleSearchDTO cfavoritesSimpleDto = new
                com.yonyou.cfavorites.dto.SimpleSearchDTO();
        cfavoritesSimpleDto.setSearch_cid(commodity_ID);
        cfavoritesMapper.delete(cfavoritesSimpleDto.toSearchParams(Cfavorites.class));
    }

    /**
     * 根据用户的id和商品的id删除其收藏记录
     * @param commodity_ID
     */
    public void deleteByUserIdAndCommodityId(String user_ID, String commodity_ID){
        com.yonyou.cfavorites.dto.SimpleSearchDTO cfavoritesSimpleDto = new
                com.yonyou.cfavorites.dto.SimpleSearchDTO();
        cfavoritesSimpleDto.setSearch_uid(user_ID);
        cfavoritesSimpleDto.setSearch_cid(commodity_ID);
        cfavoritesMapper.delete(cfavoritesSimpleDto.toSearchParams(Cfavorites.class));
    }

    /**
     * 根据商品的id，得到收藏其的全部用户
     * @param commodity_ID
     * @return
     */
    public List<Object> getAllUsersByCommodityId(String commodity_ID){
        com.yonyou.cfavorites.dto.SimpleSearchDTO cfavoritesSimpleDto = new
                com.yonyou.cfavorites.dto.SimpleSearchDTO();
        cfavoritesSimpleDto.setSearch_cid(commodity_ID);
        List userList = cfavoritesQueryService.listCfavorites(cfavoritesSimpleDto.toSearchParams(Cfavorites.class));
        return userList;
    }

    /**
     * 根据用户的id，得到其收藏的全部商品
     * @param user_ID
     * @return
     */
    public List<Object> getAllCommodityByUserId(String user_ID){
        com.yonyou.cfavorites.dto.SimpleSearchDTO cfavoritesSimpleDto = new
                com.yonyou.cfavorites.dto.SimpleSearchDTO();
        cfavoritesSimpleDto.setSearch_uid(user_ID);
        List commodityList = cfavoritesQueryService.listCfavorites(cfavoritesSimpleDto.toSearchParams(Cfavorites.class));
        return commodityList;
    }

    /**
     * 查询某条收藏记录
     * @param user_ID
     * @return
     */
    public List<Object> getByUserIdAndCommodityId(String user_ID, String commodity_ID){
        com.yonyou.cfavorites.dto.SimpleSearchDTO cfavoritesSimpleDto = new
                com.yonyou.cfavorites.dto.SimpleSearchDTO();
        cfavoritesSimpleDto.setSearch_uid(user_ID);
        cfavoritesSimpleDto.setSearch_cid(commodity_ID);
        List recordList = cfavoritesQueryService.listCfavorites(cfavoritesSimpleDto.toSearchParams(Cfavorites.class));
        return recordList;
    }

    /**
     * 得到某条帖子的收藏数
     * @param commodity_ID
     * @return
     */
    public Integer eGetFavoritesNum(String commodity_ID){
        List<Object> favoritesList = this.getAllUsersByCommodityId(commodity_ID);
        if (favoritesList == null){
            return 0;
        } else{
            return favoritesList.size();
        }
    }
}