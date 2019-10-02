package com.yonyou.clikes.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.clikes.po.Clikes;

@MyBatisRepository("com.yonyou.clikes.dao.ClikesMapper")
public interface ClikesMapper extends BaseDAO<Clikes,String> {

}
