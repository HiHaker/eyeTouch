package com.yonyou.cbrand.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.cbrand.dao.CbrandMapper;
import com.yonyou.cbrand.po.Cbrand;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.cbrand.service.CbrandService")
public class CbrandService extends GenericAssoService<Cbrand,String>{

    private CbrandMapper cbrandMapper;

    @Autowired
    public void setCbrandMapper(CbrandMapper cbrandMapper) {
        this.cbrandMapper = cbrandMapper;
        super.setGenericMapper(cbrandMapper);
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