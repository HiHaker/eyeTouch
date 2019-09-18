package com.yonyou.pimage.service;
import java.util.List;

import com.yonyou.pimage.api.PimageQueryService;
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
}