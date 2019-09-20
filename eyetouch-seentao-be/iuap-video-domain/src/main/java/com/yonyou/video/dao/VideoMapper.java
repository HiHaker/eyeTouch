package com.yonyou.video.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.video.po.Video;

@MyBatisRepository("com.yonyou.video.dao.VideoMapper")
public interface VideoMapper extends BaseDAO<Video,String> {

}
