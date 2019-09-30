package com.yonyou.relation.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.relation.po.Relation;

@MyBatisRepository("com.yonyou.relation.dao.RelationMapper")
public interface RelationMapper extends BaseDAO<Relation,String> {

}
