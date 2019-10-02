package com.yonyou.ccomments.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.ccomments.dao.CcommentsMapper;
import com.yonyou.ccomments.po.Ccomments;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.ccomments.service.CcommentsService")
public class CcommentsService extends GenericAssoService<Ccomments,String>{

    private CcommentsMapper ccommentsMapper;

    @Autowired
    public void setCcommentsMapper(CcommentsMapper ccommentsMapper) {
        this.ccommentsMapper = ccommentsMapper;
        super.setGenericMapper(ccommentsMapper);
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