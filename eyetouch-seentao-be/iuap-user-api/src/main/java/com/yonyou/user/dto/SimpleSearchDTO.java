package com.yonyou.user.dto;

import cn.hutool.core.util.ReflectUtil;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.condition.Match;
import com.yonyou.iuap.ucf.common.entity.Identifier;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.iuap.ucf.core.utils.EntityUtil;
import com.yonyou.iuap.ucf.dao.support.SqlParam;
import com.yonyou.iuap.ucf.dao.utils.FieldUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

 /**
  * 用于构造查询条件
  * @since v5.0.0
  * @date 2019-9-29 11:51:37
  */
public class SimpleSearchDTO {
    private static Logger logger = LoggerFactory.getLogger(SimpleSearchDTO.class);
    private static String PARAM_SEARCH_PREFIX = "search_";
        private String search_avatar;     //头像id

        public void setSearch_avatar(String avatar){
            this.search_avatar = avatar;
        }
        public String getSearch_avatar(){
            return this.search_avatar;
        }

        private String search_password;     //密码

        public void setSearch_password(String password){
            this.search_password = password;
        }
        public String getSearch_password(){
            return this.search_password;
        }

        private String search_sex;     //性别

        public void setSearch_sex(String sex){
            this.search_sex = sex;
        }
        public String getSearch_sex(){
            return this.search_sex;
        }

        private String search_register_date;     //注册日期

        public void setSearch_register_date(String register_date){
            this.search_register_date = register_date;
        }
        public String getSearch_register_date(){
            return this.search_register_date;
        }

        private String search_birthday;     //生日

        public void setSearch_birthday(String birthday){
            this.search_birthday = birthday;
        }
        public String getSearch_birthday(){
            return this.search_birthday;
        }

        private String search_nickname;     //用户昵称

        public void setSearch_nickname(String nickname){
            this.search_nickname = nickname;
        }
        public String getSearch_nickname(){
            return this.search_nickname;
        }

        private String search_phone_number;     //电话号码

        public void setSearch_phone_number(String phone_number){
            this.search_phone_number = phone_number;
        }
        public String getSearch_phone_number(){
            return this.search_phone_number;
        }

        private String search_login_name;     //登录名

        public void setSearch_login_name(String login_name){
            this.search_login_name = login_name;
        }
        public String getSearch_login_name(){
            return this.search_login_name;
        }

        private String search_profile;     //简介

        public void setSearch_profile(String profile){
            this.search_profile = profile;
        }
        public String getSearch_profile(){
            return this.search_profile;
        }

        private String search_mailbox;     //邮箱

        public void setSearch_mailbox(String mailbox){
            this.search_mailbox = mailbox;
        }
        public String getSearch_mailbox(){
            return this.search_mailbox;
        }


        private String search_NA;     //外键

        public void setSearch_NA(String fk){
            this.search_NA = fk;
        }
        public String getSearch_NA(){
            return this.search_NA;
        }

    private Set<String> likeFields = new HashSet<>(); // 使用like的field名
    private Set<String> inFields = new HashSet<>();  //使用in的field名
    private LinkedHashMap<String, String> sorts = new LinkedHashMap<>();

    public Set<String> getLikeFields() {
        return likeFields;
    }

    public void setLikeFields(Set<String> likeFields) {
        this.likeFields = likeFields;
    }

    public Set<String> getInFields() {
        return inFields;
    }

    public void setInFields(Set<String> inFields) {
        this.inFields = inFields;
    }

    public LinkedHashMap<String, String> getSorts() {
        return sorts;
    }

    public void setSorts(LinkedHashMap<String, String> sorts) {
        this.sorts = sorts;
    }


    public SearchParams toSearchParams(Class<? extends Identifier> entityClass) {

        String table=EntityUtil.getTableName(entityClass);
        SqlParam result = SqlParam.of().table(table);
        for (Field searchField : ReflectUtil.getFields(SimpleSearchDTO.class)) {
            if (ReflectUtil.getFieldValue(this, searchField) != null) {
                Field keyField;
                if (searchField.getName().toLowerCase().startsWith(PARAM_SEARCH_PREFIX)) {
                    keyField = ReflectUtil.getField(entityClass, searchField.getName().replace(PARAM_SEARCH_PREFIX, ""));
                } else {
                    keyField = ReflectUtil.getField(entityClass, searchField.getName());
                }
                if (keyField != null) {
                    Condition cond = keyField.getAnnotation(Condition.class);
                    String keyCol = FieldUtil.getColumnName(keyField);
                    if (cond == null || cond.match() == Match.EQ) {
                        result.eq(keyCol, ReflectUtil.getFieldValue(this, searchField));
                    } else if (cond.match() == Match.IN) {
                        try {
                            @SuppressWarnings("unchecked")
                            List<Object> ls = (List<Object>) ReflectUtil.getFieldValue(this, searchField);
                            result.in(keyCol, ls);
                        } catch (Exception e) {
                            logger.error("error happened while reading IN param from search params:" + keyField.getName(), e);
                        }
                    } else if (cond.match() == Match.LIKE) {
                        try {
                            result.like(keyCol,ReflectUtil.getFieldValue(this, searchField).toString());
                        } catch (Exception e) {
                            logger.error("error happened while reading Like param from search params:" + keyField.getName(), e);
                        }
                    } else if (cond.match() == Match.BETWEEN) {
                        try {
                            Object[] values = (Object[]) ReflectUtil.getFieldValue(this, searchField);
                            result.between(keyCol, values[0], values[1]);
                        } catch (Exception e) {
                            logger.error("error happened while reading BETWEEN param from search params:" + keyField.getName(), e);
                        }
                    } else {
                        result.and(keyCol + " " + cond.match()+ " "  + ReflectUtil.getFieldValue(this, searchField));
                    }

                }

            }

        }


        return result;
    }
}
