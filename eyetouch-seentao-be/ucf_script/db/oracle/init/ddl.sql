-- drop table user cascade constraints;
create table user
(
ID VARCHAR2(64) not null,
        constraint PK_user primary key (ID),
        avatar VARCHAR2(64) null,
        password VARCHAR2(64) null,
        sex VARCHAR2(64) null,
        register_date VARCHAR2(64) null,
        birthday VARCHAR2(64) null,
        nickname VARCHAR2(64) null,
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
        comment on column user.avatar is '头像id';
        comment on column user.password is '密码';
        comment on column user.sex is '性别';
        comment on column user.register_date is '注册日期';
        comment on column user.birthday is '生日';
        comment on column user.nickname is '用户昵称';
        comment on column user.phone_number is '电话号码';
        comment on column user.login_name is '登录名';
        comment on column user.profile is '简介';
        comment on column user.mailbox is '邮箱';
comment on column user.DR is '是否删除';
comment on column user.TS is '时间戳';
comment on column user.LAST_MODIFIED is '修改时间';
comment on column user.LAST_MODIFY_USER is '修改人';
comment on column user.CREATE_TIME is '创建时间';
comment on column user.CREATE_USER is '创建人';






