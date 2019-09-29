-- drop table myuser cascade constraints;
create table myuser
(
ID VARCHAR2(64) not null,
        constraint PK_myuser primary key (ID),
        avatar VARCHAR2(64) null,
        password VARCHAR2(64) null,
        sex VARCHAR2(64) null,
        nickname VARCHAR2(64) null,
        register_date VARCHAR2(64) null,
        birthday VARCHAR2(64) null,
        phone_number VARCHAR2(64) null,
        login_name VARCHAR2(64) null,
        profile VARCHAR2(64) null,
        mailbox VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column myuser.avatar is '头像id';
        comment on column myuser.password is '密码';
        comment on column myuser.sex is '性别';
        comment on column myuser.nickname is '昵称';
        comment on column myuser.register_date is '注册日期';
        comment on column myuser.birthday is '生日';
        comment on column myuser.phone_number is '电话号码';
        comment on column myuser.login_name is '登录名';
        comment on column myuser.profile is '简介';
        comment on column myuser.mailbox is '邮箱';
comment on column myuser.DR is '是否删除';
comment on column myuser.TS is '时间戳';
comment on column myuser.LAST_MODIFIED is '修改时间';
comment on column myuser.LAST_MODIFY_USER is '修改人';
comment on column myuser.CREATE_TIME is '创建时间';
comment on column myuser.CREATE_USER is '创建人';






