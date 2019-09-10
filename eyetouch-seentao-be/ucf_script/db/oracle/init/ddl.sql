-- drop table post cascade constraints;
create table post
(
ID VARCHAR2(64) not null,
        constraint PK_post primary key (ID),
        time VARCHAR2(64) null,
        content VARCHAR2(64) null,
        title VARCHAR2(64) null,
        type VARCHAR2(64) null,
        style VARCHAR2(64) null,
        uid VARCHAR2(64) null,
        fpid VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column post.time is '发表时间';
        comment on column post.content is '帖子内容';
        comment on column post.title is '帖子标题';
        comment on column post.type is '帖子类型';
        comment on column post.style is '帖子风格';
        comment on column post.uid is '用户id';
        comment on column post.fpid is '转发的原帖id';
comment on column post.DR is '是否删除';
comment on column post.TS is '时间戳';
comment on column post.LAST_MODIFIED is '修改时间';
comment on column post.LAST_MODIFY_USER is '修改人';
comment on column post.CREATE_TIME is '创建时间';
comment on column post.CREATE_USER is '创建人';






