-- drop table relation cascade constraints;
create table relation
(
ID VARCHAR2(64) not null,
        constraint PK_relation primary key (ID),
        follows VARCHAR2(64) null,
        fans VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column relation.follows is '关注人id';
        comment on column relation.fans is '粉丝id';
comment on column relation.DR is '是否删除';
comment on column relation.TS is '时间戳';
comment on column relation.LAST_MODIFIED is '修改时间';
comment on column relation.LAST_MODIFY_USER is '修改人';
comment on column relation.CREATE_TIME is '创建时间';
comment on column relation.CREATE_USER is '创建人';






