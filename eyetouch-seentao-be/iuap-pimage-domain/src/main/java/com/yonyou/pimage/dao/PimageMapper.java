package com.yonyou.pimage.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.pimage.po.Pimage;

@MyBatisRepository("com.yonyou.pimage.dao.PimageMapper")
public interface PimageMapper extends BaseDAO<Pimage,String> {

}
