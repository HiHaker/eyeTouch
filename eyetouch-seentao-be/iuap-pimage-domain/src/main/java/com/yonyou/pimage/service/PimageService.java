package com.yonyou.pimage.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.pimage.api.PimageQueryService;
import com.yonyou.pimage.dto.PimageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.pimage.dao.PimageMapper;
import com.yonyou.pimage.po.Pimage;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.pimage.service.PimageService")
public class PimageService extends GenericAssoService<Pimage,String>{

    private PimageMapper pimageMapper;

    @Autowired
    PimageQueryService pimageQueryService;

    @Autowired
    public void setPimageMapper(PimageMapper pimageMapper) {
        this.pimageMapper = pimageMapper;
        super.setGenericMapper(pimageMapper);
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
     * @param pimage
     */
    public void addRecord(Pimage pimage){
        this.save(pimage,true,true);
    }

    /**
     * 根据查询到的id列表进行删除
     * @param post_ID
     */
    public void deleteByIds(String post_ID){
        // 逻辑：先根据帖子的id找到对应的所有的图片的记录，将这些记录的id存到列表里面，再使用deleteByIds删除
        com.yonyou.pimage.dto.SimpleSearchDTO pimageSimpleDto = new
                com.yonyou.pimage.dto.SimpleSearchDTO();
        pimageSimpleDto.setSearch_pid(post_ID);
        List pimageList = pimageQueryService.listPimage(pimageSimpleDto.toSearchParams(Pimage.class));
        List<String> pimageIds = new ArrayList<>();
        for (Object o:pimageList){
            // 进行强制类型转换
            PimageDTO record = (PimageDTO)o;
            pimageIds.add(record.getId());
        }
        pimageMapper.deleteByIds(pimageIds);
    }

    /**
     * 得到帖子的全部的图片的url列表
     * @param post_ID
     * @return
     */
    public List<String> getAllPostImages(String post_ID){
        com.yonyou.pimage.dto.SimpleSearchDTO pimageSimpleDto = new
                com.yonyou.pimage.dto.SimpleSearchDTO();
        pimageSimpleDto.setSearch_pid(post_ID);
        List pimageList = pimageQueryService.listPimage(pimageSimpleDto.toSearchParams(Pimage.class));
        List<String> imgUrls = new ArrayList<>();
        for (Object o:pimageList){
            PimageDTO record = (PimageDTO)o;
            imgUrls.add(record.getId());
        }
        return imgUrls;
    }
}