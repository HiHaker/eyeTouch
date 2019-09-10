

CREATE TABLE [post] (

[ID] varchar(64)   NOT NULL ,
[TS] varchar(64)   NULL ,
[CREATE_TIME] varchar(64)   NULL ,
[CREATE_USER] varchar(64)   NULL ,
[LAST_MODIFIED] varchar(64)   NULL ,
[LAST_MODIFY_USER] varchar(64)   NULL ,

[time] VARCHAR(64)   NULL ,
[content] VARCHAR(64)   NULL ,
[title] VARCHAR(64)   NULL ,
[type] VARCHAR(64)   NULL ,
[style] VARCHAR(64)   NULL ,
[uid] VARCHAR(64)   NULL ,
[fpid] VARCHAR(64)   NULL ,
   PRIMARY KEY ([ID])
)
ON [PRIMARY]
GO

EXEC sp_addextendedproperty 'MS_Description',N'发表时间','user','dbo','TABLE','post','COLUMN','time'
GO
EXEC sp_addextendedproperty 'MS_Description',N'帖子内容','user','dbo','TABLE','post','COLUMN','content'
GO
EXEC sp_addextendedproperty 'MS_Description',N'帖子标题','user','dbo','TABLE','post','COLUMN','title'
GO
EXEC sp_addextendedproperty 'MS_Description',N'帖子类型','user','dbo','TABLE','post','COLUMN','type'
GO
EXEC sp_addextendedproperty 'MS_Description',N'帖子风格','user','dbo','TABLE','post','COLUMN','style'
GO
EXEC sp_addextendedproperty 'MS_Description',N'用户id','user','dbo','TABLE','post','COLUMN','uid'
GO
EXEC sp_addextendedproperty 'MS_Description',N'转发的原帖id','user','dbo','TABLE','post','COLUMN','fpid'
GO


EXEC sp_addextendedproperty 'MS_Description',N'主键 ID','user','dbo','TABLE','post','COLUMN','ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'乐观锁时间戳','user','dbo','TABLE','post','COLUMN','TS'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改时间','user','dbo','TABLE','post','COLUMN','LAST_MODIFIED'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改人','user','dbo','TABLE','post','COLUMN','LAST_MODIFY_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建时间','user','dbo','TABLE','post','COLUMN','CREATE_TIME'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建人','user','dbo','TABLE','post','COLUMN','CREATE_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'租户标识','user','dbo','TABLE','post','COLUMN','TENANT_ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'是否删除','user','dbo','TABLE','post','COLUMN','DR'
GO



 


--------------------------------------------------------

