-- drop table commodity cascade constraints;
create table commodity
(
ID VARCHAR2(64) not null,
        constraint PK_commodity primary key (ID),
        content VARCHAR2(64) null,
        effacicy VARCHAR2(64) null,
        name VARCHAR2(64) null,
        brand VARCHAR2(64) null,
        type VARCHAR2(64) null,
        link VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column commodity.content is '商品内容';
        comment on column commodity.effacicy is '商品功效';
        comment on column commodity.name is '商品名称';
        comment on column commodity.brand is '商品品牌';
        comment on column commodity.type is '商品类型';
        comment on column commodity.link is '商品链接';
comment on column commodity.DR is '是否删除';
comment on column commodity.TS is '时间戳';
comment on column commodity.LAST_MODIFIED is '修改时间';
comment on column commodity.LAST_MODIFY_USER is '修改人';
comment on column commodity.CREATE_TIME is '创建时间';
comment on column commodity.CREATE_USER is '创建人';






