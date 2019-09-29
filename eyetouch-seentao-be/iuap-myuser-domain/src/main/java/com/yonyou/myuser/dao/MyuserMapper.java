package com.yonyou.myuser.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.myuser.po.Myuser;

@MyBatisRepository("com.yonyou.myuser.dao.MyuserMapper")
public interface MyuserMapper extends BaseDAO<Myuser,String> {

}
