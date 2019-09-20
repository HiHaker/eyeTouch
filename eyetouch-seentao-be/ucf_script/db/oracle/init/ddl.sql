-- drop table cimage cascade constraints;
create table cimage
(
ID VARCHAR2(64) not null,
        constraint PK_cimage primary key (ID),
        cid VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column cimage.cid is '商品id';
comment on column cimage.DR is '是否删除';
comment on column cimage.TS is '时间戳';
comment on column cimage.LAST_MODIFIED is '修改时间';
comment on column cimage.LAST_MODIFY_USER is '修改人';
comment on column cimage.CREATE_TIME is '创建时间';
comment on column cimage.CREATE_USER is '创建人';






