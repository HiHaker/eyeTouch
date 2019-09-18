package com.yonyou.post.po;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.post.constant.PostConstant;
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
 * 帖子
 * @since v5.0.0
 * @date 2019-9-10 20:00:26
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "post")

public class Post extends BasePO implements AuditTrail{

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
    @Column(name="time")
    private String time;        //发表时间

    public void setTime(String time){
        this.time = time;
    }
    public String getTime(){
        return this.time;
    }


    @Condition(match=Match.EQ)
    @Column(name="content")
    private String content;        //帖子内容

    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }


    @Condition(match=Match.EQ)
    @Column(name="title")
    private String title;        //帖子标题

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }


    @Condition(match=Match.EQ)
    @Column(name="type")
    private Integer type;        //帖子类型

    public void setType(Integer type){
        this.type = type;
    }
    public Integer getType(){
        return this.type;
    }


    @Condition(match=Match.EQ)
    @Column(name="style")
    private Integer style;        //帖子风格

    public void setStyle(Integer style){
        this.style = style;
    }
    public Integer getStyle(){
        return this.style;
    }


    @Condition(match=Match.EQ)
    @Column(name="uid")
    private String uid;        //用户id

    public void setUid(String uid){
        this.uid = uid;
    }
    public String getUid(){
        return this.uid;
    }


    @Condition(match=Match.EQ)
    @Column(name="fpid")
    private String fpid;        //转发的原帖id

    public void setFpid(String fpid){
        this.fpid = fpid;
    }
    public String getFpid(){
        return this.fpid;
    }


}



