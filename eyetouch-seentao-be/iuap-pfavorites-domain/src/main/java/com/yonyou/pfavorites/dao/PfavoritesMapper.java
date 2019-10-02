package com.yonyou.pfavorites.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.pfavorites.po.Pfavorites;

@MyBatisRepository("com.yonyou.pfavorites.dao.PfavoritesMapper")
public interface PfavoritesMapper extends BaseDAO<Pfavorites,String> {

}
