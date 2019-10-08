

CREATE TABLE [commodity] (

[ID] varchar(64)   NOT NULL ,
[TS] varchar(64)   NULL ,
[CREATE_TIME] varchar(64)   NULL ,
[CREATE_USER] varchar(64)   NULL ,
[LAST_MODIFIED] varchar(64)   NULL ,
[LAST_MODIFY_USER] varchar(64)   NULL ,

[price] VARCHAR(64)   NULL ,
[content] VARCHAR(64)   NULL ,
[effacicy] VARCHAR(64)   NULL ,
[name] VARCHAR(64)   NULL ,
[brand] VARCHAR(64)   NULL ,
[type] VARCHAR(64)   NULL ,
[link] VARCHAR(64)   NULL ,
   PRIMARY KEY ([ID])
)
ON [PRIMARY]
GO

EXEC sp_addextendedproperty 'MS_Description',N'商品价格','user','dbo','TABLE','commodity','COLUMN','price'
GO
EXEC sp_addextendedproperty 'MS_Description',N'商品内容','user','dbo','TABLE','commodity','COLUMN','content'
GO
EXEC sp_addextendedproperty 'MS_Description',N'商品功效','user','dbo','TABLE','commodity','COLUMN','effacicy'
GO
EXEC sp_addextendedproperty 'MS_Description',N'商品名称','user','dbo','TABLE','commodity','COLUMN','name'
GO
EXEC sp_addextendedproperty 'MS_Description',N'商品品牌','user','dbo','TABLE','commodity','COLUMN','brand'
GO
EXEC sp_addextendedproperty 'MS_Description',N'商品类型','user','dbo','TABLE','commodity','COLUMN','type'
GO
EXEC sp_addextendedproperty 'MS_Description',N'商品链接','user','dbo','TABLE','commodity','COLUMN','link'
GO


EXEC sp_addextendedproperty 'MS_Description',N'主键 ID','user','dbo','TABLE','commodity','COLUMN','ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'乐观锁时间戳','user','dbo','TABLE','commodity','COLUMN','TS'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改时间','user','dbo','TABLE','commodity','COLUMN','LAST_MODIFIED'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改人','user','dbo','TABLE','commodity','COLUMN','LAST_MODIFY_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建时间','user','dbo','TABLE','commodity','COLUMN','CREATE_TIME'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建人','user','dbo','TABLE','commodity','COLUMN','CREATE_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'租户标识','user','dbo','TABLE','commodity','COLUMN','TENANT_ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'是否删除','user','dbo','TABLE','commodity','COLUMN','DR'
GO



 


--------------------------------------------------------

