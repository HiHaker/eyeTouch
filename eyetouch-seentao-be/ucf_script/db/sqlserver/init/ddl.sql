

CREATE TABLE [pcomments] (

[ID] varchar(64)   NOT NULL ,
[TS] varchar(64)   NULL ,
[CREATE_TIME] varchar(64)   NULL ,
[CREATE_USER] varchar(64)   NULL ,
[LAST_MODIFIED] varchar(64)   NULL ,
[LAST_MODIFY_USER] varchar(64)   NULL ,

[auid] VARCHAR(64)   NULL ,
[buid] VARCHAR(64)   NULL ,
[time] VARCHAR(64)   NULL ,
[pid] VARCHAR(64)   NULL ,
[content] VARCHAR(64)   NULL ,
   PRIMARY KEY ([ID])
)
ON [PRIMARY]
GO

EXEC sp_addextendedproperty 'MS_Description',N'a用户id','user','dbo','TABLE','pcomments','COLUMN','auid'
GO
EXEC sp_addextendedproperty 'MS_Description',N'b用户id','user','dbo','TABLE','pcomments','COLUMN','buid'
GO
EXEC sp_addextendedproperty 'MS_Description',N'发表时间','user','dbo','TABLE','pcomments','COLUMN','time'
GO
EXEC sp_addextendedproperty 'MS_Description',N'帖子id','user','dbo','TABLE','pcomments','COLUMN','pid'
GO
EXEC sp_addextendedproperty 'MS_Description',N'评论内容','user','dbo','TABLE','pcomments','COLUMN','content'
GO


EXEC sp_addextendedproperty 'MS_Description',N'主键 ID','user','dbo','TABLE','pcomments','COLUMN','ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'乐观锁时间戳','user','dbo','TABLE','pcomments','COLUMN','TS'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改时间','user','dbo','TABLE','pcomments','COLUMN','LAST_MODIFIED'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改人','user','dbo','TABLE','pcomments','COLUMN','LAST_MODIFY_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建时间','user','dbo','TABLE','pcomments','COLUMN','CREATE_TIME'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建人','user','dbo','TABLE','pcomments','COLUMN','CREATE_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'租户标识','user','dbo','TABLE','pcomments','COLUMN','TENANT_ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'是否删除','user','dbo','TABLE','pcomments','COLUMN','DR'
GO



 


--------------------------------------------------------

