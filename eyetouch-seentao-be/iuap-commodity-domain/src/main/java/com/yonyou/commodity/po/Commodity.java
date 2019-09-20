package com.yonyou.commodity.po;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.commodity.constant.CommodityConstant;
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
 * 商品
 * @since v5.0.0
 * @date 2019-9-20 9:52:27
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "commodity")

public class Commodity extends BasePO implements AuditTrail{

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
    @Column(name="content")
    private String content;        //商品内容

    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }


    @Condition(match=Match.EQ)
    @Column(name="effacicy")
    private String effacicy;        //商品功效

    public void setEffacicy(String effacicy){
        this.effacicy = effacicy;
    }
    public String getEffacicy(){
        return this.effacicy;
    }


    @Condition(match=Match.EQ)
    @Column(name="name")
    private String name;        //商品名称

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }


    @Condition(match=Match.EQ)
    @Column(name="brand")
    private String brand;        //商品品牌

    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getBrand(){
        return this.brand;
    }


    @Condition(match=Match.EQ)
    @Column(name="type")
    private String type;        //商品类型

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }


    @Condition(match=Match.EQ)
    @Column(name="link")
    private String link;        //商品链接

    public void setLink(String link){
        this.link = link;
    }
    public String getLink(){
        return this.link;
    }


}



