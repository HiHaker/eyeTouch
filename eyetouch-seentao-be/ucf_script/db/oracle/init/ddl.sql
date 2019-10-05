-- drop table myimg cascade constraints;
create table myimg
(
ID VARCHAR2(64) not null,
        constraint PK_myimg primary key (ID),
        course VARCHAR2(8000) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column myimg.course is '教程';
comment on column myimg.DR is '是否删除';
comment on column myimg.TS is '时间戳';
comment on column myimg.LAST_MODIFIED is '修改时间';
comment on column myimg.LAST_MODIFY_USER is '修改人';
comment on column myimg.CREATE_TIME is '创建时间';
comment on column myimg.CREATE_USER is '创建人';






