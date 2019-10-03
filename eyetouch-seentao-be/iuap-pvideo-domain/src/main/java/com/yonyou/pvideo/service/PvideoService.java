package com.yonyou.pvideo.service;
import java.util.ArrayList;
import java.util.List;

import com.yonyou.pvideo.api.PvideoQueryService;
import com.yonyou.pvideo.dto.PvideoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.pvideo.dao.PvideoMapper;
import com.yonyou.pvideo.po.Pvideo;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.pvideo.service.PvideoService")
public class PvideoService extends GenericAssoService<Pvideo,String>{

    private PvideoMapper pvideoMapper;

    @Autowired
    PvideoQueryService pvideoQueryService;

    @Autowired
    public void setPvideoMapper(PvideoMapper pvideoMapper) {
        this.pvideoMapper = pvideoMapper;
        super.setGenericMapper(pvideoMapper);
    }



    /**
     * 可插拔设计
     * @return 向父类 提供可插拔的特性声明
     */
    @Override
    protected ServiceFeature[] getFeats() {
        return new ServiceFeature[]{ AUDIT,I18N_ENUM };
    }

    /**
     * 增加一条记录
     * @param pvideo
     */
    public void addRecord(Pvideo pvideo){
        this.save(pvideo,true,true);
    }

    /**
     * 根据帖子id删除对应的记录
     * @param post_ID
     */
    public void deleteVideoByPostId(String post_ID){
        com.yonyou.pvideo.dto.SimpleSearchDTO pvideoSimpleDto = new
                com.yonyou.pvideo.dto.SimpleSearchDTO();
        pvideoSimpleDto.setSearch_pid(post_ID);
        pvideoMapper.delete(pvideoSimpleDto.toSearchParams(Pvideo.class));
    }

    /**
     * 得到帖子的视频的记录
     * @param post_ID
     * @return
     */
    public List<Object> getVideoByPostId(String post_ID){
        com.yonyou.pvideo.dto.SimpleSearchDTO pvideoSimpleDto = new
                com.yonyou.pvideo.dto.SimpleSearchDTO();
        pvideoSimpleDto.setSearch_pid(post_ID);
        List pvideoList = pvideoQueryService.listPvideo(pvideoSimpleDto.toSearchParams(Pvideo.class));
        return pvideoList;
    }

    /**
     * 得到帖子的视频url列表
     * @param post_ID
     * @return
     */
    public List<String> eGetVideoUrl(String post_ID){
        List<Object> videoList = this.getVideoByPostId(post_ID);
        List<String> urls = new ArrayList<>();
        for (Object o:videoList){
            // 强制类型转换
            PvideoDTO p = (PvideoDTO)o;
            urls.add(p.getId());
        }
        return urls;
    }
}