-- drop table pvideo cascade constraints;
create table pvideo
(
ID VARCHAR2(64) not null,
        constraint PK_pvideo primary key (ID),
        pid VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column pvideo.pid is '帖子id';
comment on column pvideo.DR is '是否删除';
comment on column pvideo.TS is '时间戳';
comment on column pvideo.LAST_MODIFIED is '修改时间';
comment on column pvideo.LAST_MODIFY_USER is '修改人';
comment on column pvideo.CREATE_TIME is '创建时间';
comment on column pvideo.CREATE_USER is '创建人';






