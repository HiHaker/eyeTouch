package com.yonyou.relation.service;
import java.util.ArrayList;
import java.util.List;

import com.yonyou.relation.api.RelationQueryService;
import com.yonyou.relation.dto.RelationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.relation.dao.RelationMapper;
import com.yonyou.relation.po.Relation;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.relation.service.RelationService")
public class RelationService extends GenericAssoService<Relation,String>{

    private RelationMapper relationMapper;

    @Autowired
    RelationQueryService relationQueryService;

    @Autowired
    public void setRelationMapper(RelationMapper relationMapper) {
        this.relationMapper = relationMapper;
        super.setGenericMapper(relationMapper);
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
     * 根据关注人和被关注人的id删除记录
     * @param fans_ID
     * @param follows_ID
     */
    public void deleteByFansIdAndFollowsId(String fans_ID, String follows_ID){
        com.yonyou.relation.dto.SimpleSearchDTO relationSimpleDto = new
                com.yonyou.relation.dto.SimpleSearchDTO();
        relationSimpleDto.setSearch_follows(follows_ID);
        relationSimpleDto.setSearch_fans(fans_ID);
        relationMapper.delete(relationSimpleDto.toSearchParams(Relation.class));
    }

    /**
     * 根据被关注的用户的id，得到他所有的粉丝的id
     * @param follows_ID
     * @return
     */
    public List<Object> getAllFansByFollowsId(String follows_ID){
        com.yonyou.relation.dto.SimpleSearchDTO relationSimpleDto = new
                com.yonyou.relation.dto.SimpleSearchDTO();
        relationSimpleDto.setSearch_follows(follows_ID);
        List fansList = relationQueryService.listRelation(relationSimpleDto.toSearchParams(Relation.class));
        return fansList;
    }

    /**
     * 根据某粉丝用户的id，得到他所有的关注用户
     * @param fans_ID
     * @return
     */
    public List<Object> getAllFollowsByFansId(String fans_ID){
        com.yonyou.relation.dto.SimpleSearchDTO relationSimpleDto = new
                com.yonyou.relation.dto.SimpleSearchDTO();
        relationSimpleDto.setSearch_fans(fans_ID);
        List followsList = relationQueryService.listRelation(relationSimpleDto.toSearchParams(Relation.class));
        return followsList;
    }

    /**
     * 查询某条关注记录
     * @param fans_ID
     * @param follows_ID
     * @return
     */
    public List<Object> getByFansIdAndFollowsId(String fans_ID, String follows_ID){
        com.yonyou.relation.dto.SimpleSearchDTO relationSimpleDto = new
                com.yonyou.relation.dto.SimpleSearchDTO();
        relationSimpleDto.setSearch_fans(fans_ID);
        relationSimpleDto.setSearch_follows(follows_ID);
        List recordList = relationQueryService.listRelation(relationSimpleDto.toSearchParams(Relation.class));
        return recordList;
    }

    /**
     * 得到关注用户列表
     * @param fans_ID
     * @return
     */
    public List<String> eGetAllFollows(String fans_ID){
        List<Object> usersList = this.getAllFollowsByFansId(fans_ID);
        List<String> follows = new ArrayList<>();
        for (Object o:usersList){
            RelationDTO r = (RelationDTO)o;
            follows.add(r.getFollows());
        }
        return follows;
    }
}