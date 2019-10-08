package com.yonyou.cimage.service;
import java.util.ArrayList;
import java.util.List;

import com.yonyou.cimage.api.CimageQueryService;
import com.yonyou.cimage.dto.CimageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.cimage.dao.CimageMapper;
import com.yonyou.cimage.po.Cimage;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.cimage.service.CimageService")
public class CimageService extends GenericAssoService<Cimage,String>{

    private CimageMapper cimageMapper;

    @Autowired
    CimageQueryService cimageQueryService;

    @Autowired
    public void setCimageMapper(CimageMapper cimageMapper) {
        this.cimageMapper = cimageMapper;
        super.setGenericMapper(cimageMapper);
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
     * 插入图片列表
     * @param cimageList
     */
    public void insertImages(List<Cimage> cimageList){
        for (Cimage c:cimageList){
            this.save(c,true,true);
        }
    }

    /**
     * 根据商品的id删除对应的图片
     * @param commodity_ID
     */
    public void deleteImagesByCommodityId(String commodity_ID){
        com.yonyou.cimage.dto.SimpleSearchDTO cimageSimpleDto = new
                com.yonyou.cimage.dto.SimpleSearchDTO();
        cimageSimpleDto.setSearch_cid(commodity_ID);
        cimageMapper.delete(cimageSimpleDto.toSearchParams(Cimage.class));
    }

    /**
     * 得到帖子的全部的图片的url列表
     * @param commodity_ID
     * @return
     */
    public List<Object> getImagesByCommodityId(String commodity_ID){
        com.yonyou.cimage.dto.SimpleSearchDTO cimageSimpleDto = new
                com.yonyou.cimage.dto.SimpleSearchDTO();
        cimageSimpleDto.setSearch_cid(commodity_ID);
        List cimageList = cimageQueryService.listCimage(cimageSimpleDto.toSearchParams(Cimage.class));
        return cimageList;
    }

    /**
     * 得到帖子的图片url列表
     * @param commodity_ID
     * @return
     */
    public List<String> eGetImagesUrl(String commodity_ID){
        List<Object> imgList = this.getImagesByCommodityId(commodity_ID);
        List<String> urls = new ArrayList<>();
        for (Object o:imgList){
            // 强制类型转换
            CimageDTO c = (CimageDTO)o;
            urls.add(c.getId());
        }
        return urls;
    }
}