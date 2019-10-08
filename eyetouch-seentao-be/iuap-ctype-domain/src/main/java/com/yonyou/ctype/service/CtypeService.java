package com.yonyou.ctype.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.ctype.dao.CtypeMapper;
import com.yonyou.ctype.po.Ctype;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.ctype.service.CtypeService")
public class CtypeService extends GenericAssoService<Ctype,String>{

    private CtypeMapper ctypeMapper;

    @Autowired
    public void setCtypeMapper(CtypeMapper ctypeMapper) {
        this.ctypeMapper = ctypeMapper;
        super.setGenericMapper(ctypeMapper);
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
        ctypeMapper.deleteByIds(ids);
    }
}