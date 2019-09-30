package com.yonyou.relation.po;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.relation.constant.RelationConstant;
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
 * 用户关系
 * @since v5.0.0
 * @date 2019-9-30 9:09:38
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "relation")

public class Relation extends BasePO implements AuditTrail{

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
    @Column(name="follows")
    private String follows;        //关注人id

    public void setFollows(String follows){
        this.follows = follows;
    }
    public String getFollows(){
        return this.follows;
    }


    @Condition(match=Match.EQ)
    @Column(name="fans")
    private String fans;        //粉丝id

    public void setFans(String fans){
        this.fans = fans;
    }
    public String getFans(){
        return this.fans;
    }


}



