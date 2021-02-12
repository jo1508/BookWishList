use master;
GO
CREATE login com_johan_wishlist WITH password = 'sqlsa.johan.com#15' 


USE MyApps;
GO
CREATE USER com_johan_wishlist FOR LOGIN com_johan_wishlist WITH DEFAULT_SCHEMA=wishlist;
GO


