package com.yonyou.pcomments.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.pcomments.po.Pcomments;

@MyBatisRepository("com.yonyou.pcomments.dao.PcommentsMapper")
public interface PcommentsMapper extends BaseDAO<Pcomments,String> {

}
