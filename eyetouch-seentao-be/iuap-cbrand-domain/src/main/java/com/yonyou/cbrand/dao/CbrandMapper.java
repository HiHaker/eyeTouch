package com.yonyou.cbrand.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.cbrand.po.Cbrand;

@MyBatisRepository("com.yonyou.cbrand.dao.CbrandMapper")
public interface CbrandMapper extends BaseDAO<Cbrand,String> {

}
