

CREATE TABLE [myimg] (

[ID] varchar(64)   NOT NULL ,
[TS] varchar(64)   NULL ,
[CREATE_TIME] varchar(64)   NULL ,
[CREATE_USER] varchar(64)   NULL ,
[LAST_MODIFIED] varchar(64)   NULL ,
[LAST_MODIFY_USER] varchar(64)   NULL ,

[course] VARCHAR(8000)   NULL ,
   PRIMARY KEY ([ID])
)
ON [PRIMARY]
GO

EXEC sp_addextendedproperty 'MS_Description',N'教程','user','dbo','TABLE','myimg','COLUMN','course'
GO


EXEC sp_addextendedproperty 'MS_Description',N'主键 ID','user','dbo','TABLE','myimg','COLUMN','ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'乐观锁时间戳','user','dbo','TABLE','myimg','COLUMN','TS'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改时间','user','dbo','TABLE','myimg','COLUMN','LAST_MODIFIED'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改人','user','dbo','TABLE','myimg','COLUMN','LAST_MODIFY_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建时间','user','dbo','TABLE','myimg','COLUMN','CREATE_TIME'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建人','user','dbo','TABLE','myimg','COLUMN','CREATE_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'租户标识','user','dbo','TABLE','myimg','COLUMN','TENANT_ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'是否删除','user','dbo','TABLE','myimg','COLUMN','DR'
GO



 


--------------------------------------------------------

