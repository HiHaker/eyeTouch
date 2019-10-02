package com.yonyou.myuser.service;
import java.util.List;

import com.yonyou.myuser.api.MyuserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.myuser.dao.MyuserMapper;
import com.yonyou.myuser.po.Myuser;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.myuser.service.MyuserService")
public class MyuserService extends GenericAssoService<Myuser,String>{

    private MyuserMapper myuserMapper;

    @Autowired
    MyuserQueryService myuserQueryService;

    @Autowired
    public void setMyuserMapper(MyuserMapper myuserMapper) {
        this.myuserMapper = myuserMapper;
        super.setGenericMapper(myuserMapper);
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
     * 增加一条用户记录
     * @param user
     * @return
     */
    public void addRecord(Myuser user){
        this.save(user,true,true);
    }

    /**
     * 根据用户名查询用户
     * @param loginName
     * @return
     */
    public Object getUserByLoginName(String loginName){
        com.yonyou.myuser.dto.SimpleSearchDTO myuserSimpleDto = new
                com.yonyou.myuser.dto.SimpleSearchDTO();
        myuserSimpleDto.setSearch_login_name(loginName);
        List myuserList = myuserQueryService.listMyuser(myuserSimpleDto.toSearchParams(Myuser.class));
        return myuserList;
    }
}