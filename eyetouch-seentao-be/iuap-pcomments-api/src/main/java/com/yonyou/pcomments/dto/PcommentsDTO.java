package com.yonyou.pcomments.dto;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.entity.AuditTrail;
import com.yonyou.iuap.baseservice.entity.annotation.*;
import com.yonyou.iuap.baseservice.support.condition.Condition;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * 帖子评论
 * @since v5.0.0
 * @date 2019-10-2 20:05:58
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PcommentsDTO  implements AuditTrail{

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


    private String auid;        //a用户id

    public void setAuid(String auid){
        this.auid = auid;
    }
    public String getAuid(){
        return this.auid;
    }



    private String buid;        //b用户id

    public void setBuid(String buid){
        this.buid = buid;
    }
    public String getBuid(){
        return this.buid;
    }



    private String time;        //发表时间

    public void setTime(String time){
        this.time = time;
    }
    public String getTime(){
        return this.time;
    }



    private String pid;        //帖子id

    public void setPid(String pid){
        this.pid = pid;
    }
    public String getPid(){
        return this.pid;
    }



    private String content;        //评论内容

    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }


}



