-- drop table pcomments cascade constraints;
create table pcomments
(
ID VARCHAR2(64) not null,
        constraint PK_pcomments primary key (ID),
        auid VARCHAR2(64) null,
        buid VARCHAR2(64) null,
        time VARCHAR2(64) null,
        pid VARCHAR2(64) null,
        content VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column pcomments.auid is 'a用户id';
        comment on column pcomments.buid is 'b用户id';
        comment on column pcomments.time is '发表时间';
        comment on column pcomments.pid is '帖子id';
        comment on column pcomments.content is '评论内容';
comment on column pcomments.DR is '是否删除';
comment on column pcomments.TS is '时间戳';
comment on column pcomments.LAST_MODIFIED is '修改时间';
comment on column pcomments.LAST_MODIFY_USER is '修改人';
comment on column pcomments.CREATE_TIME is '创建时间';
comment on column pcomments.CREATE_USER is '创建人';






