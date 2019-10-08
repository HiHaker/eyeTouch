package com.yonyou.effacicy.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.effacicy.dao.EffacicyMapper;
import com.yonyou.effacicy.po.Effacicy;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.effacicy.service.EffacicyService")
public class EffacicyService extends GenericAssoService<Effacicy,String>{

    private EffacicyMapper effacicyMapper;

    @Autowired
    public void setEffacicyMapper(EffacicyMapper effacicyMapper) {
        this.effacicyMapper = effacicyMapper;
        super.setGenericMapper(effacicyMapper);
    }



    /**
     * 可插拔设计
     * @return 向父类 提供可插拔的特性声明
     */
    @Override
    protected ServiceFeature[] getFeats() {
        return new ServiceFeature[]{ AUDIT,I18N_ENUM };
    }

    /**
     * 根据id删除记录
     * @param id
     */
    public void deleteById(String id){
        List<String> ids = new ArrayList<>();
        ids.add(id);
        effacicyMapper.deleteByIds(ids);
    }
}