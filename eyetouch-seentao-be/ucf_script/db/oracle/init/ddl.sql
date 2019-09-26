-- drop table ctype cascade constraints;
create table ctype
(
ID VARCHAR2(64) not null,
        constraint PK_ctype primary key (ID),
        name VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column ctype.name is '商品类型名称';
comment on column ctype.DR is '是否删除';
comment on column ctype.TS is '时间戳';
comment on column ctype.LAST_MODIFIED is '修改时间';
comment on column ctype.LAST_MODIFY_USER is '修改人';
comment on column ctype.CREATE_TIME is '创建时间';
comment on column ctype.CREATE_USER is '创建人';






