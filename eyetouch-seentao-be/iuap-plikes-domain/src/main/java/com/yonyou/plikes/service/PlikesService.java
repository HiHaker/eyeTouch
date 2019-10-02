package com.yonyou.plikes.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.plikes.dao.PlikesMapper;
import com.yonyou.plikes.po.Plikes;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.plikes.service.PlikesService")
public class PlikesService extends GenericAssoService<Plikes,String>{

    private PlikesMapper plikesMapper;

    @Autowired
    public void setPlikesMapper(PlikesMapper plikesMapper) {
        this.plikesMapper = plikesMapper;
        super.setGenericMapper(plikesMapper);
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