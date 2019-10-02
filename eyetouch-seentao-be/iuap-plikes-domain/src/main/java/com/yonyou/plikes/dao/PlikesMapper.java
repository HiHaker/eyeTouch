package com.yonyou.plikes.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.plikes.po.Plikes;

@MyBatisRepository("com.yonyou.plikes.dao.PlikesMapper")
public interface PlikesMapper extends BaseDAO<Plikes,String> {

}
