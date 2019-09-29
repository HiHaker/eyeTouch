package com.yonyou.user.po;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.user.constant.UserConstant;
import com.yonyou.iuap.baseservice.entity.AuditTrail;
import com.yonyou.iuap.baseservice.entity.annotation.*;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.condition.Match;
import com.yonyou.iuap.ucf.dao.BasePO;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;
/**
 * 用户
 * @since v5.0.0
 * @date 2019-9-29 11:51:37
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "user")

public class User extends BasePO implements AuditTrail{

    @Column(name="create_time")
    private String createTime;

    @Column(name="create_user")
    @Condition
    private String createUser;

    @Column(name="last_modified")
    private String lastModified;

    @Column(name="last_modify_user")
    @Condition
    private String lastModifyUser;

    @Override
    public String getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getCreateUser() {
        return createUser;
    }

    @Override
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public String getLastModified() {
        return lastModified;
    }

    @Override
    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String getLastModifyUser() {
        return lastModifyUser;
    }

    @Override
    public void setLastModifyUser(String lastModifyUser) {
        this.lastModifyUser = lastModifyUser;
    }

    @Condition(match=Match.EQ)
    @Column(name="avatar")
    private String avatar;        //头像id

    public void setAvatar(String avatar){
        this.avatar = avatar;
    }
    public String getAvatar(){
        return this.avatar;
    }


    @Condition(match=Match.EQ)
    @Column(name="password")
    private String password;        //密码

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }


    @Condition(match=Match.EQ)
    @Column(name="sex")
    private String sex;        //性别

    public void setSex(String sex){
        this.sex = sex;
    }
    public String getSex(){
        return this.sex;
    }


    @Condition(match=Match.EQ)
    @Column(name="register_date")
    private String register_date;        //注册日期

    public void setRegister_date(String register_date){
        this.register_date = register_date;
    }
    public String getRegister_date(){
        return this.register_date;
    }


    @Condition(match=Match.EQ)
    @Column(name="birthday")
    private String birthday;        //生日

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    public String getBirthday(){
        return this.birthday;
    }


    @Condition(match=Match.EQ)
    @Column(name="nickname")
    private String nickname;        //用户昵称

    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public String getNickname(){
        return this.nickname;
    }


    @Condition(match=Match.EQ)
    @Column(name="phone_number")
    private String phone_number;        //电话号码

    public void setPhone_number(String phone_number){
        this.phone_number = phone_number;
    }
    public String getPhone_number(){
        return this.phone_number;
    }


    @Condition(match=Match.EQ)
    @Column(name="login_name")
    private String login_name;        //登录名

    public void setLogin_name(String login_name){
        this.login_name = login_name;
    }
    public String getLogin_name(){
        return this.login_name;
    }


    @Condition(match=Match.EQ)
    @Column(name="profile")
    private String profile;        //简介

    public void setProfile(String profile){
        this.profile = profile;
    }
    public String getProfile(){
        return this.profile;
    }


    @Condition(match=Match.EQ)
    @Column(name="mailbox")
    private String mailbox;        //邮箱

    public void setMailbox(String mailbox){
        this.mailbox = mailbox;
    }
    public String getMailbox(){
        return this.mailbox;
    }


}



