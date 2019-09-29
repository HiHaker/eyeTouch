
-- drop table if EXISTS myuser;
CREATE TABLE `myuser` (
`ID` VARCHAR(64) NOT NULL COMMENT '主键',
    PRIMARY KEY (`ID`),
    `avatar` VARCHAR(64) DEFAULT NULL COMMENT '头像id',
    `password` VARCHAR(64) DEFAULT NULL COMMENT '密码',
    `sex` VARCHAR(64) DEFAULT NULL COMMENT '性别',
    `nickname` VARCHAR(64) DEFAULT NULL COMMENT '昵称',
    `register_date` VARCHAR(64) DEFAULT NULL COMMENT '注册日期',
    `birthday` VARCHAR(64) DEFAULT NULL COMMENT '生日',
    `phone_number` VARCHAR(64) DEFAULT NULL COMMENT '电话号码',
    `login_name` VARCHAR(64) DEFAULT NULL COMMENT '登录名',
    `profile` VARCHAR(64) DEFAULT NULL COMMENT '简介',
    `mailbox` VARCHAR(64) DEFAULT NULL COMMENT '邮箱',
        `TENANT_ID` varchar(64) DEFAULT NULL,
        `DR` int(11) DEFAULT NULL COMMENT '是否删除',
        `TS` varchar(64) DEFAULT NULL COMMENT '时间戳',
        `LAST_MODIFIED` varchar(64) DEFAULT NULL COMMENT '修改时间',
        `LAST_MODIFY_USER` varchar(64) DEFAULT NULL COMMENT '修改人',
        `CREATE_TIME` varchar(64) DEFAULT NULL COMMENT '创建时间',
        `CREATE_USER` varchar(64) DEFAULT NULL COMMENT '创建人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;




