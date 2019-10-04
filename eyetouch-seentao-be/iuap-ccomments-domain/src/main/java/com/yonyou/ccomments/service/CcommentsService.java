package com.yonyou.ccomments.service;
import java.util.List;

import com.yonyou.ccomments.api.CcommentsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.ccomments.dao.CcommentsMapper;
import com.yonyou.ccomments.po.Ccomments;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.ccomments.service.CcommentsService")
public class CcommentsService extends GenericAssoService<Ccomments,String>{

    private CcommentsMapper ccommentsMapper;

    @Autowired
    CcommentsQueryService ccommentsQueryService;

    @Autowired
    public void setCcommentsMapper(CcommentsMapper ccommentsMapper) {
        this.ccommentsMapper = ccommentsMapper;
        super.setGenericMapper(ccommentsMapper);
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
     * 根据用户id删除其全部评论记录
     * @param user_ID
     */
    public void deleteByUserId(String user_ID){
        com.yonyou.ccomments.dto.SimpleSearchDTO ccommentsSimpleDto = new
                com.yonyou.ccomments.dto.SimpleSearchDTO();
        ccommentsSimpleDto.setSearch_uid(user_ID);
        ccommentsMapper.delete(ccommentsSimpleDto.toSearchParams(Ccomments.class));
    }

    /**
     * 根据商品id删除其全部评论记录
     * @param commodity_ID
     */
    public void deleteByCommodityId(String commodity_ID){
        com.yonyou.ccomments.dto.SimpleSearchDTO ccommentsSimpleDto = new
                com.yonyou.ccomments.dto.SimpleSearchDTO();
        ccommentsSimpleDto.setSearch_cid(commodity_ID);
        ccommentsMapper.delete(ccommentsSimpleDto.toSearchParams(Ccomments.class));
    }

    /**
     * 根据商品id和用户id删除其评论记录
     * @param commodity_ID
     * @param user_ID
     */
    public void deleteByCommodityIdAndUserId(String commodity_ID, String user_ID){
        com.yonyou.ccomments.dto.SimpleSearchDTO ccommentsSimpleDto = new
                com.yonyou.ccomments.dto.SimpleSearchDTO();
        ccommentsSimpleDto.setSearch_cid(commodity_ID);
        ccommentsSimpleDto.setSearch_uid(user_ID);
        ccommentsMapper.delete(ccommentsSimpleDto.toSearchParams(Ccomments.class));
    }

    /**
     * 根据商品id查询全部评论记录
     * @param commodity_ID
     */
    public List<Object> getAllCommentsByCommodityId(String commodity_ID){
        com.yonyou.ccomments.dto.SimpleSearchDTO ccommentsSimpleDto = new
                com.yonyou.ccomments.dto.SimpleSearchDTO();
        ccommentsSimpleDto.setSearch_cid(commodity_ID);
        List commentsList = ccommentsQueryService.listCcomments(ccommentsSimpleDto.toSearchParams(Ccomments.class));
        return commentsList;
    }

    /**
     * 根据用户id查询其全部评论记录
     * @param user_ID
     */
    public List<Object> getAllCommentsByUserId(String user_ID){
        com.yonyou.ccomments.dto.SimpleSearchDTO ccommentsSimpleDto = new
                com.yonyou.ccomments.dto.SimpleSearchDTO();
        ccommentsSimpleDto.setSearch_uid(user_ID);
        List commentsList = ccommentsQueryService.listCcomments(ccommentsSimpleDto.toSearchParams(Ccomments.class));
        return commentsList;
    }


}