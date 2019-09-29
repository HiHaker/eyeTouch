package com.yonyou.user.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.user.po.User;

@MyBatisRepository("com.yonyou.user.dao.UserMapper")
public interface UserMapper extends BaseDAO<User,String> {

}
