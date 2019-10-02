package com.yonyou.ccomments.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.ccomments.po.Ccomments;

@MyBatisRepository("com.yonyou.ccomments.dao.CcommentsMapper")
public interface CcommentsMapper extends BaseDAO<Ccomments,String> {

}
