-- drop table pfavorites cascade constraints;
create table pfavorites
(
ID VARCHAR2(64) not null,
        constraint PK_pfavorites primary key (ID),
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
        comment on column pfavorites.time is '发表时间';
        comment on column pfavorites.pid is '帖子id';
        comment on column pfavorites.uid is '用户id';
comment on column pfavorites.DR is '是否删除';
comment on column pfavorites.TS is '时间戳';
comment on column pfavorites.LAST_MODIFIED is '修改时间';
comment on column pfavorites.LAST_MODIFY_USER is '修改人';
comment on column pfavorites.CREATE_TIME is '创建时间';
comment on column pfavorites.CREATE_USER is '创建人';






