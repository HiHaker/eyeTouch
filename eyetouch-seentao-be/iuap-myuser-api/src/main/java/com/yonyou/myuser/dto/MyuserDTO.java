package com.yonyou.myuser.dto;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.entity.AuditTrail;
import com.yonyou.iuap.baseservice.entity.annotation.*;
import com.yonyou.iuap.baseservice.support.condition.Condition;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * 平台用户
 * @since v5.0.0
 * @date 2019-9-29 21:10:18
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyuserDTO  implements AuditTrail{

    private String id;
    private String tenantId;
    private Date ts;
    private Integer dr;
    private String createTime;
    private String createUser;
    private String lastModified;
    private String lastModifyUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }
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


    private String avatar;        //头像id

    public void setAvatar(String avatar){
        this.avatar = avatar;
    }
    public String getAvatar(){
        return this.avatar;
    }



    private String password;        //密码

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }



    private String sex;        //性别

    public void setSex(String sex){
        this.sex = sex;
    }
    public String getSex(){
        return this.sex;
    }



    private String nickname;        //昵称

    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public String getNickname(){
        return this.nickname;
    }



    private String register_date;        //注册日期

    public void setRegister_date(String register_date){
        this.register_date = register_date;
    }
    public String getRegister_date(){
        return this.register_date;
    }



    private String birthday;        //生日

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    public String getBirthday(){
        return this.birthday;
    }



    private String phone_number;        //电话号码

    public void setPhone_number(String phone_number){
        this.phone_number = phone_number;
    }
    public String getPhone_number(){
        return this.phone_number;
    }



    private String login_name;        //登录名

    public void setLogin_name(String login_name){
        this.login_name = login_name;
    }
    public String getLogin_name(){
        return this.login_name;
    }



    private String profile;        //简介

    public void setProfile(String profile){
        this.profile = profile;
    }
    public String getProfile(){
        return this.profile;
    }



    private String mailbox;        //邮箱

    public void setMailbox(String mailbox){
        this.mailbox = mailbox;
    }
    public String getMailbox(){
        return this.mailbox;
    }


}



