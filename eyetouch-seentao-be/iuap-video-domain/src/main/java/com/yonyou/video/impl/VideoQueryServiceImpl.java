package com.yonyou.video.impl;

import com.yonyou.video.api.VideoQueryService;
import com.yonyou.video.dto.VideoDTO;
import com.yonyou.video.po.Video;
import com.yonyou.video.service.VideoService;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.iuap.ucf.dao.support.SqlParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RPC provider端
 * @author  
 * @date 2019-9-20 8:43:35
 */
@Service("com.yonyou.video.impl.VideoQueryServiceImpl")
public class VideoQueryServiceImpl implements VideoQueryService {

    private VideoService videoService;

    @Autowired
    public void setVideoService(VideoService videoService) {
        this.videoService = videoService;
    }


    @Override
    public List<VideoDTO> listVideo(SearchParams searchParams) {
        List<Video>  list = videoService.queryList(searchParams);
        List<VideoDTO> result = new ArrayList<>();
        if (list!=null){
            for (Video model:list){
                VideoDTO dto = new VideoDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
