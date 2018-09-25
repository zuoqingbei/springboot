package com.hailian.dynamic;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource
{
  protected Object determineCurrentLookupKey()
  {
    DatabaseType type = DatabaseContextHolder.getDatabaseType();

    if (type == null) {
      this.logger.info("========= dataSource ==========" + DatabaseType.slave.name());
      return DatabaseType.slave.name();
    }
    this.logger.info("========= dataSource ==========" + type);
    return type;
  }
}