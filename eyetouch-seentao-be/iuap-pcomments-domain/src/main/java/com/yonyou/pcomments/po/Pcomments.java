package com.yonyou.pcomments.po;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.pcomments.constant.PcommentsConstant;
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
 * 帖子评论
 * @since v5.0.0
 * @date 2019-10-2 20:05:58
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "pcomments")

public class Pcomments extends BasePO implements AuditTrail{

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
    @Column(name="auid")
    private String auid;        //a用户id

    public void setAuid(String auid){
        this.auid = auid;
    }
    public String getAuid(){
        return this.auid;
    }


    @Condition(match=Match.EQ)
    @Column(name="buid")
    private String buid;        //b用户id

    public void setBuid(String buid){
        this.buid = buid;
    }
    public String getBuid(){
        return this.buid;
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
    @Column(name="pid")
    private String pid;        //帖子id

    public void setPid(String pid){
        this.pid = pid;
    }
    public String getPid(){
        return this.pid;
    }


    @Condition(match=Match.EQ)
    @Column(name="content")
    private String content;        //评论内容

    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }


}



