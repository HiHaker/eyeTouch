package com.yonyou.pcomments.service;
import java.util.ArrayList;
import java.util.List;

import com.yonyou.pcomments.api.PcommentsQueryService;
import com.yonyou.pcomments.dto.PcommentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.pcomments.dao.PcommentsMapper;
import com.yonyou.pcomments.po.Pcomments;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.pcomments.service.PcommentsService")
public class PcommentsService extends GenericAssoService<Pcomments,String>{

    private PcommentsMapper pcommentsMapper;

    @Autowired
    PcommentsQueryService pcommentsQueryService;

    @Autowired
    public void setPcommentsMapper(PcommentsMapper pcommentsMapper) {
        this.pcommentsMapper = pcommentsMapper;
        super.setGenericMapper(pcommentsMapper);
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
     * 根据a用户（主用户，如果用户是对帖子评论，则默认使用a用户表示）id删除其全部评论记录
     * @param auser_ID
     */
    public void deleteByAUserId(String auser_ID){
        com.yonyou.pcomments.dto.SimpleSearchDTO pcommentsSimpleDto = new
                com.yonyou.pcomments.dto.SimpleSearchDTO();
        pcommentsSimpleDto.setSearch_auid(auser_ID);
        pcommentsMapper.delete(pcommentsSimpleDto.toSearchParams(Pcomments.class));
    }

    /**
     * 根据b用户（次用户，如果用户是对用户的评论，则评论的人为a用户，被评论的人为b用户）id删除其全部评论记录
     * @param buser_ID
     */
    public void deleteByBUserId(String buser_ID){
        com.yonyou.pcomments.dto.SimpleSearchDTO pcommentsSimpleDto = new
                com.yonyou.pcomments.dto.SimpleSearchDTO();
        pcommentsSimpleDto.setSearch_buid(buser_ID);
        pcommentsMapper.delete(pcommentsSimpleDto.toSearchParams(Pcomments.class));
    }

    /**
     * 根据帖子id删除其全部评论记录
     * @param post_ID
     */
    public void deleteByPostId(String post_ID){
        com.yonyou.pcomments.dto.SimpleSearchDTO pcommentsSimpleDto = new
                com.yonyou.pcomments.dto.SimpleSearchDTO();
        pcommentsSimpleDto.setSearch_pid(post_ID);
        pcommentsMapper.delete(pcommentsSimpleDto.toSearchParams(Pcomments.class));
    }

    /**
     * 根据a用户id和b用户id删除其全部评论记录
     * @param auser_ID
     * @param buser_ID
     */
    public void deleteByAUserIdAndBUserId(String auser_ID, String buser_ID){
        com.yonyou.pcomments.dto.SimpleSearchDTO pcommentsSimpleDto = new
                com.yonyou.pcomments.dto.SimpleSearchDTO();
        pcommentsSimpleDto.setSearch_auid(auser_ID);
        pcommentsSimpleDto.setSearch_buid(buser_ID);
        pcommentsMapper.delete(pcommentsSimpleDto.toSearchParams(Pcomments.class));
    }

    /**
     * 根据a用户id和帖子id删除其全部评论记录
     * @param auser_ID
     * @param post_ID
     */
    public void deleteByAUserIdAndPostId(String auser_ID, String post_ID){
        com.yonyou.pcomments.dto.SimpleSearchDTO pcommentsSimpleDto = new
                com.yonyou.pcomments.dto.SimpleSearchDTO();
        pcommentsSimpleDto.setSearch_auid(auser_ID);
        pcommentsSimpleDto.setSearch_pid(post_ID);
        pcommentsMapper.delete(pcommentsSimpleDto.toSearchParams(Pcomments.class));
    }

    /**
     * 根据b用户id和帖子id删除其全部评论记录
     * @param buser_ID
     * @param post_ID
     */
    public void deleteByBUserIdAndPostId(String buser_ID, String post_ID){
        com.yonyou.pcomments.dto.SimpleSearchDTO pcommentsSimpleDto = new
                com.yonyou.pcomments.dto.SimpleSearchDTO();
        pcommentsSimpleDto.setSearch_buid(buser_ID);
        pcommentsSimpleDto.setSearch_pid(post_ID);
        pcommentsMapper.delete(pcommentsSimpleDto.toSearchParams(Pcomments.class));
    }

    /**
     * 根据a用户的id得到其所有评论记录
     * @param auser_ID
     * @return
     */
    public List<Object> getAllAUsersByAUid(String auser_ID){
        com.yonyou.pcomments.dto.SimpleSearchDTO pcommentsSimpleDto = new
                com.yonyou.pcomments.dto.SimpleSearchDTO();
        pcommentsSimpleDto.setSearch_auid(auser_ID);
        List auserList = pcommentsQueryService.listPcomments(pcommentsSimpleDto.toSearchParams(Pcomments.class));
        return auserList;
    }

    /**
     * 根据b用户的id得到其所有被评论记录
     * @param buser_ID
     * @return
     */
    public List<Object> getAllBUsersByBUid(String buser_ID){
        com.yonyou.pcomments.dto.SimpleSearchDTO pcommentsSimpleDto = new
                com.yonyou.pcomments.dto.SimpleSearchDTO();
        pcommentsSimpleDto.setSearch_buid(buser_ID);
        List buserList = pcommentsQueryService.listPcomments(pcommentsSimpleDto.toSearchParams(Pcomments.class));
        return buserList;
    }

    /**
     * 根据a用户的id和b用户的id得到其所有互动评论记录
     * @param auser_ID
     * @param buser_ID
     * @return
     */
    public List<Object> getAllABUsersByAUidAndBUid(String auser_ID, String buser_ID){
        com.yonyou.pcomments.dto.SimpleSearchDTO pcommentsSimpleDto = new
                com.yonyou.pcomments.dto.SimpleSearchDTO();
        pcommentsSimpleDto.setSearch_auid(auser_ID);
        pcommentsSimpleDto.setSearch_buid(buser_ID);
        List abuserList = pcommentsQueryService.listPcomments(pcommentsSimpleDto.toSearchParams(Pcomments.class));
        return abuserList;
    }

    /**
     * 根据帖子的id得到其所有互动评论记录
     * @param post_ID
     * @return
     */
    public List<Object> getAllByPostId(String post_ID){
        com.yonyou.pcomments.dto.SimpleSearchDTO pcommentsSimpleDto = new
                com.yonyou.pcomments.dto.SimpleSearchDTO();
        pcommentsSimpleDto.setSearch_pid(post_ID);
        List postList = pcommentsQueryService.listPcomments(pcommentsSimpleDto.toSearchParams(Pcomments.class));
        return postList;
    }
}