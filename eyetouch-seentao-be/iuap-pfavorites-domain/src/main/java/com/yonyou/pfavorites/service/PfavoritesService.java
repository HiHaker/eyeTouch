package com.yonyou.pfavorites.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.pfavorites.dao.PfavoritesMapper;
import com.yonyou.pfavorites.po.Pfavorites;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.pfavorites.service.PfavoritesService")
public class PfavoritesService extends GenericAssoService<Pfavorites,String>{

    private PfavoritesMapper pfavoritesMapper;

    @Autowired
    public void setPfavoritesMapper(PfavoritesMapper pfavoritesMapper) {
        this.pfavoritesMapper = pfavoritesMapper;
        super.setGenericMapper(pfavoritesMapper);
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