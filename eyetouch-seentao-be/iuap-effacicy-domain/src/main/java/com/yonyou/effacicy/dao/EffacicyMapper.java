package com.yonyou.effacicy.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.effacicy.po.Effacicy;

@MyBatisRepository("com.yonyou.effacicy.dao.EffacicyMapper")
public interface EffacicyMapper extends BaseDAO<Effacicy,String> {

}
