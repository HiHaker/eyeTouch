package com.yonyou.post.dto;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.entity.AuditTrail;
import com.yonyou.iuap.baseservice.entity.annotation.*;
import com.yonyou.iuap.baseservice.support.condition.Condition;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * 帖子
 * @since v5.0.0
 * @date 2019-9-10 19:59:15
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostDTO  implements AuditTrail{

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


    private String time;        //发表时间

    public void setTime(String time){
        this.time = time;
    }
    public String getTime(){
        return this.time;
    }



    private String content;        //帖子内容

    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }



    private String title;        //帖子标题

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }



    private String type;        //帖子类型

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }



    private String style;        //帖子风格

    public void setStyle(String style){
        this.style = style;
    }
    public String getStyle(){
        return this.style;
    }



    private String uid;        //用户id

    public void setUid(String uid){
        this.uid = uid;
    }
    public String getUid(){
        return this.uid;
    }



    private String fpid;        //转发的原帖id

    public void setFpid(String fpid){
        this.fpid = fpid;
    }
    public String getFpid(){
        return this.fpid;
    }


}



