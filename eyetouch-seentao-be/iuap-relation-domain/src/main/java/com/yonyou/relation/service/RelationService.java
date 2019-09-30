package com.yonyou.relation.service;
import java.util.List;
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
}