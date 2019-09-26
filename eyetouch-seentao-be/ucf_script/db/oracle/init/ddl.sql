-- drop table effacicy cascade constraints;
create table effacicy
(
ID VARCHAR2(64) not null,
        constraint PK_effacicy primary key (ID),
        name VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column effacicy.name is '商品功效名称';
comment on column effacicy.DR is '是否删除';
comment on column effacicy.TS is '时间戳';
comment on column effacicy.LAST_MODIFIED is '修改时间';
comment on column effacicy.LAST_MODIFY_USER is '修改人';
comment on column effacicy.CREATE_TIME is '创建时间';
comment on column effacicy.CREATE_USER is '创建人';






