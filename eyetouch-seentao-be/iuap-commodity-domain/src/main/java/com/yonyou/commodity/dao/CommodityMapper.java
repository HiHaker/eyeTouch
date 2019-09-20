package com.yonyou.commodity.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.commodity.po.Commodity;

@MyBatisRepository("com.yonyou.commodity.dao.CommodityMapper")
public interface CommodityMapper extends BaseDAO<Commodity,String> {

}
