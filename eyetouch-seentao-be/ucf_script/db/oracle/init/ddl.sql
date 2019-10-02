-- drop table plikes cascade constraints;
create table plikes
(
ID VARCHAR2(64) not null,
        constraint PK_plikes primary key (ID),
        time VARCHAR2(64) null,
        pid VARCHAR2(64) null,
        uid VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column plikes.time is '发表时间';
        comment on column plikes.pid is '帖子id';
        comment on column plikes.uid is '用户id';
comment on column plikes.DR is '是否删除';
comment on column plikes.TS is '时间戳';
comment on column plikes.LAST_MODIFIED is '修改时间';
comment on column plikes.LAST_MODIFY_USER is '修改人';
comment on column plikes.CREATE_TIME is '创建时间';
comment on column plikes.CREATE_USER is '创建人';






