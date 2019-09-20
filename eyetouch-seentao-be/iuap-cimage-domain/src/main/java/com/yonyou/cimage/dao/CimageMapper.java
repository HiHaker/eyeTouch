package com.yonyou.cimage.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.cimage.po.Cimage;

@MyBatisRepository("com.yonyou.cimage.dao.CimageMapper")
public interface CimageMapper extends BaseDAO<Cimage,String> {

}
