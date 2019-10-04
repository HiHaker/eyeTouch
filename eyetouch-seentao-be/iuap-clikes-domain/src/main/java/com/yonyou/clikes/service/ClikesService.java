package com.yonyou.clikes.service;
import java.util.List;

import com.yonyou.clikes.api.ClikesQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.clikes.dao.ClikesMapper;
import com.yonyou.clikes.po.Clikes;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.clikes.service.ClikesService")
public class ClikesService extends GenericAssoService<Clikes,String>{

    private ClikesMapper clikesMapper;

    @Autowired
    ClikesQueryService clikesQueryService;

    @Autowired
    public void setClikesMapper(ClikesMapper clikesMapper) {
        this.clikesMapper = clikesMapper;
        super.setGenericMapper(clikesMapper);
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
     * 根据用户的id删除其全部点赞记录
     * @param user_ID
     */
    public void deleteByUserId(String user_ID){
        com.yonyou.clikes.dto.SimpleSearchDTO clikesSimpleDto = new
                com.yonyou.clikes.dto.SimpleSearchDTO();
        clikesSimpleDto.setSearch_uid(user_ID);
        clikesMapper.delete(clikesSimpleDto.toSearchParams(Clikes.class));
    }

    /**
     * 根据商品的id删除其全部点赞记录
     * @param commodity_ID
     */
    public void deleteByCommodityId(String commodity_ID){
        com.yonyou.clikes.dto.SimpleSearchDTO clikesSimpleDto = new
                com.yonyou.clikes.dto.SimpleSearchDTO();
        clikesSimpleDto.setSearch_cid(commodity_ID);
        clikesMapper.delete(clikesSimpleDto.toSearchParams(Clikes.class));
    }

    /**
     * 根据用户的id和商品的id删除其点赞记录
     * @param commodity_ID
     */
    public void deleteByUserIdAndCommodityId(String user_ID, String commodity_ID){
        com.yonyou.clikes.dto.SimpleSearchDTO clikesSimpleDto = new
                com.yonyou.clikes.dto.SimpleSearchDTO();
        clikesSimpleDto.setSearch_uid(user_ID);
        clikesSimpleDto.setSearch_cid(commodity_ID);
        clikesMapper.delete(clikesSimpleDto.toSearchParams(Clikes.class));
    }

    /**
     * 得到某商品的全部点赞用户
     * @param commodity_ID
     * @return
     */
    public List<Object> getAllUsersByCommodityId(String commodity_ID){
        com.yonyou.clikes.dto.SimpleSearchDTO clikesSimpleDto = new
                com.yonyou.clikes.dto.SimpleSearchDTO();
        clikesSimpleDto.setSearch_cid(commodity_ID);
        List userList = clikesQueryService.listClikes(clikesSimpleDto.toSearchParams(Clikes.class));
        return userList;
    }

    /**
     * 得到某用户点赞的全部商品
     * @param user_ID
     * @return
     */
    public List<Object> getAllCommodityByUserId(String user_ID){
        com.yonyou.clikes.dto.SimpleSearchDTO clikesSimpleDto = new
                com.yonyou.clikes.dto.SimpleSearchDTO();
        clikesSimpleDto.setSearch_uid(user_ID);
        List commodityList = clikesQueryService.listClikes(clikesSimpleDto.toSearchParams(Clikes.class));
        return commodityList;
    }

    /**
     * 查询某条点赞记录
     * @param user_ID
     * @return
     */
    public List<Object> getByUserIdAndCommodityId(String user_ID, String commodity_ID){
        com.yonyou.clikes.dto.SimpleSearchDTO clikesSimpleDto = new
                com.yonyou.clikes.dto.SimpleSearchDTO();
        clikesSimpleDto.setSearch_uid(user_ID);
        clikesSimpleDto.setSearch_cid(commodity_ID);
        List recordList = clikesQueryService.listClikes(clikesSimpleDto.toSearchParams(Clikes.class));
        return recordList;
    }

    /**
     * 得到某商品的点赞数
     * @param commodity_ID
     * @return
     */
    public Integer eGetLikesNum(String commodity_ID){
        List<Object> likesList = this.getAllUsersByCommodityId(commodity_ID);
        if (likesList == null){
            return 0;
        } else{
            return likesList.size();
        }
    }
}