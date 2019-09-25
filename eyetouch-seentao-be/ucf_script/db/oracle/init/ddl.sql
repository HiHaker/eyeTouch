-- drop table cbrand cascade constraints;
create table cbrand
(
ID VARCHAR2(64) not null,
        constraint PK_cbrand primary key (ID),
        name VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column cbrand.name is '品牌名称';
comment on column cbrand.DR is '是否删除';
comment on column cbrand.TS is '时间戳';
comment on column cbrand.LAST_MODIFIED is '修改时间';
comment on column cbrand.LAST_MODIFY_USER is '修改人';
comment on column cbrand.CREATE_TIME is '创建时间';
comment on column cbrand.CREATE_USER is '创建人';






