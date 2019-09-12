-- drop table pimage cascade constraints;
create table pimage
(
ID VARCHAR2(64) not null,
        constraint PK_pimage primary key (ID),
        pid VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column pimage.pid is '帖子的id';
comment on column pimage.DR is '是否删除';
comment on column pimage.TS is '时间戳';
comment on column pimage.LAST_MODIFIED is '修改时间';
comment on column pimage.LAST_MODIFY_USER is '修改人';
comment on column pimage.CREATE_TIME is '创建时间';
comment on column pimage.CREATE_USER is '创建人';






