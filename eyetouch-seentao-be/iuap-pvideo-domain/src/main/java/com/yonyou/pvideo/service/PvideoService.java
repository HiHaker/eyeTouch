package com.yonyou.pvideo.service;
import java.util.List;
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
}