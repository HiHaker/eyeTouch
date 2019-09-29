package com.yonyou.user.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.user.dao.UserMapper;
import com.yonyou.user.po.User;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.user.service.UserService")
public class UserService extends GenericAssoService<User,String>{

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
        super.setGenericMapper(userMapper);
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