package com.hailian.dynamic;

import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Intercepts({@org.apache.ibatis.plugin.Signature(type=Executor.class, method="update", args={MappedStatement.class, Object.class}), @org.apache.ibatis.plugin.Signature(type=Executor.class, method="query", args={MappedStatement.class, Object.class, org.apache.ibatis.session.RowBounds.class, org.apache.ibatis.session.ResultHandler.class})})
public class DatabasePlugin
  implements Interceptor
{
  protected static final Logger logger = LoggerFactory.getLogger(DatabasePlugin.class);
  private static final String REGEX = ".*insert\\u0020.*|.*delete\\u0020.*|.*update\\u0020.*";
  private static final Map<String, DatabaseType> cacheMap = new ConcurrentHashMap();

  public Object intercept(Invocation invocation)
    throws Throwable
  {
    boolean synchronizationActive = TransactionSynchronizationManager.isSynchronizationActive();
   /* if (!synchronizationActive) {*/
    if (true) {
      Object[] objects = invocation.getArgs();
      MappedStatement ms = (MappedStatement)objects[0];

      DatabaseType databaseType = null;

      if ((databaseType = (DatabaseType)cacheMap.get(ms.getId())) == null)
      {
        if (ms.getSqlCommandType().equals(SqlCommandType.SELECT))
        {
          if (ms.getId().contains("!selectKey")) {
            databaseType = DatabaseType.master;
          } else {
            BoundSql boundSql = ms.getSqlSource().getBoundSql(objects[1]);
            String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replaceAll("[\\t\\n\\r]", " ");
            if (sql.matches(".*insert\\u0020.*|.*delete\\u0020.*|.*update\\u0020.*"))
              databaseType = DatabaseType.master;
            else
              databaseType = DatabaseType.slave;
          }
        }
        else {
          databaseType = DatabaseType.master;
        }
        logger.warn("设置方法[{}] use [{}] Strategy, SqlCommandType [{}]..", new Object[] { ms.getId(), databaseType.name(), ms.getSqlCommandType().name() });
        cacheMap.put(ms.getId(), databaseType);
      }
      DatabaseContextHolder.setDatabaseType(databaseType);
    }

    return invocation.proceed();
  }

  public Object plugin(Object target)
  {
    if ((target instanceof Executor)) {
      return Plugin.wrap(target, this);
    }
    return target;
  }

  public void setProperties(Properties properties)
  {
  }
}