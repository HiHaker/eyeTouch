package com.yonyou.pvideo.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.pvideo.po.Pvideo;

@MyBatisRepository("com.yonyou.pvideo.dao.PvideoMapper")
public interface PvideoMapper extends BaseDAO<Pvideo,String> {

}
