package com.yonyou.cimage.service;
import java.util.List;
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
}