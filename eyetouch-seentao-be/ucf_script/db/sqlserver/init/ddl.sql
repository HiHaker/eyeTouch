

CREATE TABLE [ccomments] (

[ID] varchar(64)   NOT NULL ,
[TS] varchar(64)   NULL ,
[CREATE_TIME] varchar(64)   NULL ,
[CREATE_USER] varchar(64)   NULL ,
[LAST_MODIFIED] varchar(64)   NULL ,
[LAST_MODIFY_USER] varchar(64)   NULL ,

[time] VARCHAR(64)   NULL ,
[cid] VARCHAR(64)   NULL ,
[uid] VARCHAR(64)   NULL ,
[content] VARCHAR(64)   NULL ,
   PRIMARY KEY ([ID])
)
ON [PRIMARY]
GO

EXEC sp_addextendedproperty 'MS_Description',N'发表时间','user','dbo','TABLE','ccomments','COLUMN','time'
GO
EXEC sp_addextendedproperty 'MS_Description',N'商品id','user','dbo','TABLE','ccomments','COLUMN','cid'
GO
EXEC sp_addextendedproperty 'MS_Description',N'用户id','user','dbo','TABLE','ccomments','COLUMN','uid'
GO
EXEC sp_addextendedproperty 'MS_Description',N'评论内容','user','dbo','TABLE','ccomments','COLUMN','content'
GO


EXEC sp_addextendedproperty 'MS_Description',N'主键 ID','user','dbo','TABLE','ccomments','COLUMN','ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'乐观锁时间戳','user','dbo','TABLE','ccomments','COLUMN','TS'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改时间','user','dbo','TABLE','ccomments','COLUMN','LAST_MODIFIED'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改人','user','dbo','TABLE','ccomments','COLUMN','LAST_MODIFY_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建时间','user','dbo','TABLE','ccomments','COLUMN','CREATE_TIME'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建人','user','dbo','TABLE','ccomments','COLUMN','CREATE_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'租户标识','user','dbo','TABLE','ccomments','COLUMN','TENANT_ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'是否删除','user','dbo','TABLE','ccomments','COLUMN','DR'
GO



 


--------------------------------------------------------

