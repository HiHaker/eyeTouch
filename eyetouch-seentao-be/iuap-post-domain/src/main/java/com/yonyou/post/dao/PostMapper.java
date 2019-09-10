package com.yonyou.post.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.post.po.Post;

@MyBatisRepository("com.yonyou.post.dao.PostMapper")
public interface PostMapper extends BaseDAO<Post,String> {

}
