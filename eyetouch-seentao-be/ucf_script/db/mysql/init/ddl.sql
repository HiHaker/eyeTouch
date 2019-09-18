
drop table if EXISTS post;
CREATE TABLE `post` (
`ID` VARCHAR(64) NOT NULL COMMENT '主键',
    PRIMARY KEY (`ID`),
    `time` VARCHAR(64) DEFAULT NULL COMMENT '发表时间',
    `content` VARCHAR(8000) DEFAULT NULL COMMENT '帖子内容',
    `title` VARCHAR(64) DEFAULT NULL COMMENT '帖子标题',
    `type` int DEFAULT NULL COMMENT '帖子类型',
    `style` int DEFAULT NULL COMMENT '帖子风格',
    `uid` VARCHAR(64) DEFAULT NULL COMMENT '用户id',
    `fpid` VARCHAR(64) DEFAULT NULL COMMENT '转发的原帖id',
        `TENANT_ID` varchar(64) DEFAULT NULL,
        `DR` int(11) DEFAULT NULL COMMENT '是否删除',
        `TS` varchar(64) DEFAULT NULL COMMENT '时间戳',
        `LAST_MODIFIED` varchar(64) DEFAULT NULL COMMENT '修改时间',
        `LAST_MODIFY_USER` varchar(64) DEFAULT NULL COMMENT '修改人',
        `CREATE_TIME` varchar(64) DEFAULT NULL COMMENT '创建时间',
        `CREATE_USER` varchar(64) DEFAULT NULL COMMENT '创建人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

drop table if EXISTS pimage;
CREATE TABLE `pimage` (
`ID` VARCHAR(64) NOT NULL COMMENT '主键',
    PRIMARY KEY (`ID`),
    `pid` VARCHAR(64) DEFAULT NULL COMMENT '帖子的id',
        `TENANT_ID` varchar(64) DEFAULT NULL,
        `DR` int(11) DEFAULT NULL COMMENT '是否删除',
        `TS` varchar(64) DEFAULT NULL COMMENT '时间戳',
        `LAST_MODIFIED` varchar(64) DEFAULT NULL COMMENT '修改时间',
        `LAST_MODIFY_USER` varchar(64) DEFAULT NULL COMMENT '修改人',
        `CREATE_TIME` varchar(64) DEFAULT NULL COMMENT '创建时间',
        `CREATE_USER` varchar(64) DEFAULT NULL COMMENT '创建人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

alter table pimage add constraint FK_Reference_1 foreign key (pid)
      references post (ID) on delete restrict on update restrict;