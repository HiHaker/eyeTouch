package com.yonyou.video.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.video.dao.VideoMapper;
import com.yonyou.video.po.Video;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.video.service.VideoService")
public class VideoService extends GenericAssoService<Video,String>{

    private VideoMapper videoMapper;

    @Autowired
    public void setVideoMapper(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
        super.setGenericMapper(videoMapper);
    }



    /**
     * 可插拔设计
     * @return 向父类 提供可插拔的特性声明
     */
    @Override
    protected ServiceFeature[] getFeats() {
        return new ServiceFeature[]{ AUDIT,I18N_ENUM };
    }
}