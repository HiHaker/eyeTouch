-- drop table cfavorites cascade constraints;
create table cfavorites
(
ID VARCHAR2(64) not null,
        constraint PK_cfavorites primary key (ID),
        time VARCHAR2(64) null,
        cid VARCHAR2(64) null,
        uid VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column cfavorites.time is '发表时间';
        comment on column cfavorites.cid is '商品id';
        comment on column cfavorites.uid is '用户id';
comment on column cfavorites.DR is '是否删除';
comment on column cfavorites.TS is '时间戳';
comment on column cfavorites.LAST_MODIFIED is '修改时间';
comment on column cfavorites.LAST_MODIFY_USER is '修改人';
comment on column cfavorites.CREATE_TIME is '创建时间';
comment on column cfavorites.CREATE_USER is '创建人';






