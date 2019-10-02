package com.yonyou.cfavorites.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.cfavorites.po.Cfavorites;

@MyBatisRepository("com.yonyou.cfavorites.dao.CfavoritesMapper")
public interface CfavoritesMapper extends BaseDAO<Cfavorites,String> {

}
