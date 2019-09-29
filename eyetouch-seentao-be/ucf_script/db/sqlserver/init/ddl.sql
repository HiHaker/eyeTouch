

CREATE TABLE [user] (

[ID] varchar(64)   NOT NULL ,
[TS] varchar(64)   NULL ,
[CREATE_TIME] varchar(64)   NULL ,
[CREATE_USER] varchar(64)   NULL ,
[LAST_MODIFIED] varchar(64)   NULL ,
[LAST_MODIFY_USER] varchar(64)   NULL ,

[avatar] VARCHAR(64)   NULL ,
[password] VARCHAR(64)   NULL ,
[sex] VARCHAR(64)   NULL ,
[register_date] VARCHAR(64)   NULL ,
[birthday] VARCHAR(64)   NULL ,
[nickname] VARCHAR(64)   NULL ,
[phone_number] VARCHAR(64)   NULL ,
[login_name] VARCHAR(64)   NULL ,
[profile] VARCHAR(64)   NULL ,
[mailbox] VARCHAR(64)   NULL ,
   PRIMARY KEY ([ID])
)
ON [PRIMARY]
GO

EXEC sp_addextendedproperty 'MS_Description',N'头像id','user','dbo','TABLE','user','COLUMN','avatar'
GO
EXEC sp_addextendedproperty 'MS_Description',N'密码','user','dbo','TABLE','user','COLUMN','password'
GO
EXEC sp_addextendedproperty 'MS_Description',N'性别','user','dbo','TABLE','user','COLUMN','sex'
GO
EXEC sp_addextendedproperty 'MS_Description',N'注册日期','user','dbo','TABLE','user','COLUMN','register_date'
GO
EXEC sp_addextendedproperty 'MS_Description',N'生日','user','dbo','TABLE','user','COLUMN','birthday'
GO
EXEC sp_addextendedproperty 'MS_Description',N'用户昵称','user','dbo','TABLE','user','COLUMN','nickname'
GO
EXEC sp_addextendedproperty 'MS_Description',N'电话号码','user','dbo','TABLE','user','COLUMN','phone_number'
GO
EXEC sp_addextendedproperty 'MS_Description',N'登录名','user','dbo','TABLE','user','COLUMN','login_name'
GO
EXEC sp_addextendedproperty 'MS_Description',N'简介','user','dbo','TABLE','user','COLUMN','profile'
GO
EXEC sp_addextendedproperty 'MS_Description',N'邮箱','user','dbo','TABLE','user','COLUMN','mailbox'
GO


EXEC sp_addextendedproperty 'MS_Description',N'主键 ID','user','dbo','TABLE','user','COLUMN','ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'乐观锁时间戳','user','dbo','TABLE','user','COLUMN','TS'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改时间','user','dbo','TABLE','user','COLUMN','LAST_MODIFIED'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改人','user','dbo','TABLE','user','COLUMN','LAST_MODIFY_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建时间','user','dbo','TABLE','user','COLUMN','CREATE_TIME'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建人','user','dbo','TABLE','user','COLUMN','CREATE_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'租户标识','user','dbo','TABLE','user','COLUMN','TENANT_ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'是否删除','user','dbo','TABLE','user','COLUMN','DR'
GO



 


--------------------------------------------------------

