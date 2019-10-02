package com.yonyou.cfavorites.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.cfavorites.dao.CfavoritesMapper;
import com.yonyou.cfavorites.po.Cfavorites;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.cfavorites.service.CfavoritesService")
public class CfavoritesService extends GenericAssoService<Cfavorites,String>{

    private CfavoritesMapper cfavoritesMapper;

    @Autowired
    public void setCfavoritesMapper(CfavoritesMapper cfavoritesMapper) {
        this.cfavoritesMapper = cfavoritesMapper;
        super.setGenericMapper(cfavoritesMapper);
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