package com.yonyou.relation.dto;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.entity.AuditTrail;
import com.yonyou.iuap.baseservice.entity.annotation.*;
import com.yonyou.iuap.baseservice.support.condition.Condition;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * 用户关系
 * @since v5.0.0
 * @date 2019-9-30 9:09:38
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RelationDTO  implements AuditTrail{

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


    private String follows;        //关注人id

    public void setFollows(String follows){
        this.follows = follows;
    }
    public String getFollows(){
        return this.follows;
    }



    private String fans;        //粉丝id

    public void setFans(String fans){
        this.fans = fans;
    }
    public String getFans(){
        return this.fans;
    }


}


