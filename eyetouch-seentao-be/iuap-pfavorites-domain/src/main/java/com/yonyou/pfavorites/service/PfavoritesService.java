package com.yonyou.pfavorites.service;
import java.util.ArrayList;
import java.util.List;

import com.yonyou.pfavorites.api.PfavoritesQueryService;
import com.yonyou.pfavorites.dto.PfavoritesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.pfavorites.dao.PfavoritesMapper;
import com.yonyou.pfavorites.po.Pfavorites;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.pfavorites.service.PfavoritesService")
public class PfavoritesService extends GenericAssoService<Pfavorites,String>{

    private PfavoritesMapper pfavoritesMapper;

    @Autowired
    PfavoritesQueryService pfavoritesQueryService;

    @Autowired
    public void setPfavoritesMapper(PfavoritesMapper pfavoritesMapper) {
        this.pfavoritesMapper = pfavoritesMapper;
        super.setGenericMapper(pfavoritesMapper);
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
        com.yonyou.pfavorites.dto.SimpleSearchDTO pfavoritesSimpleDto = new
                com.yonyou.pfavorites.dto.SimpleSearchDTO();
        pfavoritesSimpleDto.setSearch_uid(user_ID);
        pfavoritesMapper.delete(pfavoritesSimpleDto.toSearchParams(Pfavorites.class));
    }

    /**
     * 根据帖子id删除其全部收藏记录
     * @param post_ID
     */
    public void deleteByPostId(String post_ID){
        com.yonyou.pfavorites.dto.SimpleSearchDTO pfavoritesSimpleDto = new
                com.yonyou.pfavorites.dto.SimpleSearchDTO();
        pfavoritesSimpleDto.setSearch_pid(post_ID);
        pfavoritesMapper.delete(pfavoritesSimpleDto.toSearchParams(Pfavorites.class));
    }

    /**
     * 根据用户id和帖子的id删除记录
     * @param user_ID
     * @param post_ID
     */
    public void deleteByUserIdAndPostId(String user_ID, String post_ID){
        com.yonyou.pfavorites.dto.SimpleSearchDTO pfavoritesSimpleDto = new
                com.yonyou.pfavorites.dto.SimpleSearchDTO();
        pfavoritesSimpleDto.setSearch_uid(user_ID);
        pfavoritesSimpleDto.setSearch_pid(post_ID);
        pfavoritesMapper.delete(pfavoritesSimpleDto.toSearchParams(Pfavorites.class));
    }

    /**
     * 根据帖子的id，得到收藏这条贴子的全部用户
     * @param post_ID
     * @return
     */
    public List<Object> getAllUsersByPostId(String post_ID){
        com.yonyou.pfavorites.dto.SimpleSearchDTO pfavoritesSimpleDto = new
                com.yonyou.pfavorites.dto.SimpleSearchDTO();
        pfavoritesSimpleDto.setSearch_pid(post_ID);
        List usersList = pfavoritesQueryService.listPfavorites(pfavoritesSimpleDto.toSearchParams(Pfavorites.class));
        return usersList;
    }

    /**
     * 根据用户的id，得到其收藏的全部帖子
     * @param user_ID
     * @return
     */
    public List<Object> getAllPostsByUserId(String user_ID){
        com.yonyou.pfavorites.dto.SimpleSearchDTO pfavoritesSimpleDto = new
                com.yonyou.pfavorites.dto.SimpleSearchDTO();
        pfavoritesSimpleDto.setSearch_uid(user_ID);
        List postsList = pfavoritesQueryService.listPfavorites(pfavoritesSimpleDto.toSearchParams(Pfavorites.class));
        return postsList;
    }

    /**
     * 查询某条收藏记录
     * @param user_ID
     * @param post_ID
     * @return
     */
    public List<Object> getByUserIdAndPostId(String user_ID, String post_ID){
        com.yonyou.pfavorites.dto.SimpleSearchDTO pfavoritesSimpleDto = new
                com.yonyou.pfavorites.dto.SimpleSearchDTO();
        pfavoritesSimpleDto.setSearch_uid(user_ID);
        pfavoritesSimpleDto.setSearch_pid(post_ID);
        List recordList = pfavoritesQueryService.listPfavorites(pfavoritesSimpleDto.toSearchParams(Pfavorites.class));
        return recordList;
    }

    /**
     * 得到某条帖子的收藏数
     * @param post_ID
     * @return
     */
    public Integer eGetFavoritesNum(String post_ID){
        List<Object> favoritesList = this.getAllUsersByPostId(post_ID);
        if (favoritesList == null){
            return 0;
        } else{
            return favoritesList.size();
        }
    }
}