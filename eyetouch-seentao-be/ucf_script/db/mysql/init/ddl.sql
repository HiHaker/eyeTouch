
-- drop table if EXISTS pcomments;
CREATE TABLE `pcomments` (
`ID` VARCHAR(64) NOT NULL COMMENT '主键',
    PRIMARY KEY (`ID`),
    `time` VARCHAR(64) DEFAULT NULL COMMENT '发表时间',
    `pid` VARCHAR(64) DEFAULT NULL COMMENT '帖子id',
    `uid` VARCHAR(64) DEFAULT NULL COMMENT '用户id',
    `content` VARCHAR(64) DEFAULT NULL COMMENT '评论内容',
        `TENANT_ID` varchar(64) DEFAULT NULL,
        `DR` int(11) DEFAULT NULL COMMENT '是否删除',
        `TS` varchar(64) DEFAULT NULL COMMENT '时间戳',
        `LAST_MODIFIED` varchar(64) DEFAULT NULL COMMENT '修改时间',
        `LAST_MODIFY_USER` varchar(64) DEFAULT NULL COMMENT '修改人',
        `CREATE_TIME` varchar(64) DEFAULT NULL COMMENT '创建时间',
        `CREATE_USER` varchar(64) DEFAULT NULL COMMENT '创建人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;




