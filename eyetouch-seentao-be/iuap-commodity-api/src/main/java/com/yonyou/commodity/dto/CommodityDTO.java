package com.yonyou.commodity.dto;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.entity.AuditTrail;
import com.yonyou.iuap.baseservice.entity.annotation.*;
import com.yonyou.iuap.baseservice.support.condition.Condition;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * 商品
 * @since v5.0.0
 * @date 2019-9-20 9:52:28
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommodityDTO  implements AuditTrail{

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


    private String content;        //商品内容

    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }



    private String effacicy;        //商品功效

    public void setEffacicy(String effacicy){
        this.effacicy = effacicy;
    }
    public String getEffacicy(){
        return this.effacicy;
    }



    private String name;        //商品名称

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }



    private String brand;        //商品品牌

    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getBrand(){
        return this.brand;
    }



    private String type;        //商品类型

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }



    private String link;        //商品链接

    public void setLink(String link){
        this.link = link;
    }
    public String getLink(){
        return this.link;
    }


}



