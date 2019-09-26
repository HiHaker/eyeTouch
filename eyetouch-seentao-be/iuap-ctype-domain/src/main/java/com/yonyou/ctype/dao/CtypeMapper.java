package com.yonyou.ctype.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.ctype.po.Ctype;

@MyBatisRepository("com.yonyou.ctype.dao.CtypeMapper")
public interface CtypeMapper extends BaseDAO<Ctype,String> {

}
