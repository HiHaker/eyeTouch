-- drop table video cascade constraints;
create table video
(
ID VARCHAR2(64) not null,
        constraint PK_video primary key (ID),
        pid VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column video.pid is '帖子id';
comment on column video.DR is '是否删除';
comment on column video.TS is '时间戳';
comment on column video.LAST_MODIFIED is '修改时间';
comment on column video.LAST_MODIFY_USER is '修改人';
comment on column video.CREATE_TIME is '创建时间';
comment on column video.CREATE_USER is '创建人';






