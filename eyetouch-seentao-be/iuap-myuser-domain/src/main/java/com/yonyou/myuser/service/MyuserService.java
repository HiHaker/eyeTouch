package com.yonyou.myuser.service;
import java.util.ArrayList;
import java.util.List;

import com.yonyou.myuser.api.MyuserQueryService;
import com.yonyou.myuser.dto.MyuserDTO;
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
     * 根据用户的id删除用户
     * @param user_ID
     */
    public void deleteUserById(String user_ID){
        List<String> userIds = new ArrayList<>();
        userIds.add(user_ID);
        myuserMapper.deleteByIds(userIds);
    }

    /**
     * 根据用户名查询用户（用户名唯一，返回一条记录）
     * @param loginName
     * @return
     */
    public Myuser getUserByLoginName(String loginName){
        com.yonyou.myuser.dto.SimpleSearchDTO myuserSimpleDto = new
                com.yonyou.myuser.dto.SimpleSearchDTO();
        myuserSimpleDto.setSearch_login_name(loginName);
        List myuserList = myuserQueryService.listMyuser(myuserSimpleDto.toSearchParams(Myuser.class));
        Myuser myuser = new Myuser();

        if (myuserList.size() == 0){
            myuser = null;
        } else{
            Object o = myuserList.get(0);
            MyuserDTO myuserDTO = (MyuserDTO)o;

            myuser.setId(myuserDTO.getId());
            myuser.setLogin_name(myuserDTO.getLogin_name());
            myuser.setPassword(myuserDTO.getPassword());
            myuser.setAvatar(myuserDTO.getAvatar());
            myuser.setNickname(myuserDTO.getNickname());
            myuser.setMailbox(myuserDTO.getMailbox());
            myuser.setBirthday(myuserDTO.getBirthday());
            myuser.setPhone_number(myuserDTO.getPhone_number());
            myuser.setProfile(myuserDTO.getProfile());
            myuser.setSex(myuserDTO.getSex());
            myuser.setRegister_date(myuserDTO.getRegister_date());
        }

        return myuser;
    }
}