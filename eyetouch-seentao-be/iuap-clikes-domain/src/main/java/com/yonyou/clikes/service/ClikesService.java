package com.yonyou.clikes.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.clikes.dao.ClikesMapper;
import com.yonyou.clikes.po.Clikes;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.clikes.service.ClikesService")
public class ClikesService extends GenericAssoService<Clikes,String>{

    private ClikesMapper clikesMapper;

    @Autowired
    public void setClikesMapper(ClikesMapper clikesMapper) {
        this.clikesMapper = clikesMapper;
        super.setGenericMapper(clikesMapper);
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