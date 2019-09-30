package com.yonyou.relation.impl;

import com.yonyou.relation.api.RelationQueryService;
import com.yonyou.relation.dto.RelationDTO;
import com.yonyou.relation.po.Relation;
import com.yonyou.relation.service.RelationService;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.iuap.ucf.dao.support.SqlParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RPC provider端
 * @author  
 * @date 2019-9-30 9:09:38
 */
@Service("com.yonyou.relation.impl.RelationQueryServiceImpl")
public class RelationQueryServiceImpl implements RelationQueryService {

    private RelationService relationService;

    @Autowired
    public void setRelationService(RelationService relationService) {
        this.relationService = relationService;
    }


    @Override
    public List<RelationDTO> listRelation(SearchParams searchParams) {
        List<Relation>  list = relationService.queryList(searchParams);
        List<RelationDTO> result = new ArrayList<>();
        if (list!=null){
            for (Relation model:list){
                RelationDTO dto = new RelationDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
