package com.yonyou.myimg.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.myimg.dao.MyimgMapper;
import com.yonyou.myimg.po.Myimg;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.myimg.service.MyimgService")
public class MyimgService extends GenericAssoService<Myimg,String>{

    private MyimgMapper myimgMapper;

    @Autowired
    public void setMyimgMapper(MyimgMapper myimgMapper) {
        this.myimgMapper = myimgMapper;
        super.setGenericMapper(myimgMapper);
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