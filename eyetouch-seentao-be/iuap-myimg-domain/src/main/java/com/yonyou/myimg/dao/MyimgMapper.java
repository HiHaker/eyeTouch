package com.yonyou.myimg.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.myimg.po.Myimg;

@MyBatisRepository("com.yonyou.myimg.dao.MyimgMapper")
public interface MyimgMapper extends BaseDAO<Myimg,String> {

}
