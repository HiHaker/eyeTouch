package com.yonyou.pcomments.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.pcomments.dao.PcommentsMapper;
import com.yonyou.pcomments.po.Pcomments;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.pcomments.service.PcommentsService")
public class PcommentsService extends GenericAssoService<Pcomments,String>{

    private PcommentsMapper pcommentsMapper;

    @Autowired
    public void setPcommentsMapper(PcommentsMapper pcommentsMapper) {
        this.pcommentsMapper = pcommentsMapper;
        super.setGenericMapper(pcommentsMapper);
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