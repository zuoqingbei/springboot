package com.hailian.dynamic;

import com.alibaba.druid.pool.DruidDataSource;
import java.sql.SQLException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="slave.datasource")
public class DruidProperties
{
  private String url;

  private String username;

  private String password ;

  private String driverClassName;

  private Integer initialSize = Integer.valueOf(2);

  private Integer minIdle = Integer.valueOf(1);

  private Integer maxActive = Integer.valueOf(20);

  private Integer maxWait = Integer.valueOf(60000);

  private Integer timeBetweenEvictionRunsMillis = Integer.valueOf(60000);

  private Integer minEvictableIdleTimeMillis = Integer.valueOf(300000);

  private String validationQuery = "SELECT 'x' from dual";

  private Boolean testWhileIdle = Boolean.valueOf(true);

  private Boolean testOnBorrow = Boolean.valueOf(false);

  private Boolean testOnReturn = Boolean.valueOf(false);

  private Boolean poolPreparedStatements = Boolean.valueOf(true);

  private Integer maxPoolPreparedStatementPerConnectionSize = Integer.valueOf(20);

  private String filters = "stat";

  private Boolean onOff = Boolean.valueOf(false);

  public void coinfig(DruidDataSource dataSource)
  {
    dataSource.setUrl(this.url);
    dataSource.setUsername(this.username);
    dataSource.setPassword(this.password);

    dataSource.setDriverClassName(this.driverClassName);
    dataSource.setInitialSize(this.initialSize.intValue());
    dataSource.setMinIdle(this.minIdle.intValue());
    dataSource.setMaxActive(this.maxActive.intValue());
    dataSource.setMaxWait(this.maxWait.intValue());

    dataSource.setTimeBetweenEvictionRunsMillis(this.timeBetweenEvictionRunsMillis.intValue());

    dataSource.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis.intValue());
    dataSource.setValidationQuery(this.validationQuery);
    dataSource.setTestWhileIdle(this.testWhileIdle.booleanValue());
    dataSource.setTestOnBorrow(this.testOnBorrow.booleanValue());
    dataSource.setTestOnReturn(this.testOnReturn.booleanValue());

    dataSource.setPoolPreparedStatements(this.poolPreparedStatements.booleanValue());
    dataSource.setMaxPoolPreparedStatementPerConnectionSize(this.maxPoolPreparedStatementPerConnectionSize.intValue());
    try
    {
      dataSource.setFilters(this.filters);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getDriverClassName() {
    return this.driverClassName;
  }

  public void setDriverClassName(String driverClassName) {
    this.driverClassName = driverClassName;
  }

  public Integer getInitialSize() {
    return this.initialSize;
  }

  public void setInitialSize(Integer initialSize) {
    this.initialSize = initialSize;
  }

  public Integer getMinIdle() {
    return this.minIdle;
  }

  public void setMinIdle(Integer minIdle) {
    this.minIdle = minIdle;
  }

  public Integer getMaxActive() {
    return this.maxActive;
  }

  public void setMaxActive(Integer maxActive) {
    this.maxActive = maxActive;
  }

  public Integer getMaxWait() {
    return this.maxWait;
  }

  public void setMaxWait(Integer maxWait) {
    this.maxWait = maxWait;
  }

  public Integer getTimeBetweenEvictionRunsMillis() {
    return this.timeBetweenEvictionRunsMillis;
  }

  public void setTimeBetweenEvictionRunsMillis(Integer timeBetweenEvictionRunsMillis) {
    this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
  }

  public Integer getMinEvictableIdleTimeMillis() {
    return this.minEvictableIdleTimeMillis;
  }

  public void setMinEvictableIdleTimeMillis(Integer minEvictableIdleTimeMillis) {
    this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
  }

  public String getValidationQuery() {
    return this.validationQuery;
  }

  public void setValidationQuery(String validationQuery) {
    this.validationQuery = validationQuery;
  }

  public Boolean getTestWhileIdle() {
    return this.testWhileIdle;
  }

  public void setTestWhileIdle(Boolean testWhileIdle) {
    this.testWhileIdle = testWhileIdle;
  }

  public Boolean getTestOnBorrow() {
    return this.testOnBorrow;
  }

  public void setTestOnBorrow(Boolean testOnBorrow) {
    this.testOnBorrow = testOnBorrow;
  }

  public Boolean getTestOnReturn() {
    return this.testOnReturn;
  }

  public void setTestOnReturn(Boolean testOnReturn) {
    this.testOnReturn = testOnReturn;
  }

  public Boolean getPoolPreparedStatements() {
    return this.poolPreparedStatements;
  }

  public void setPoolPreparedStatements(Boolean poolPreparedStatements) {
    this.poolPreparedStatements = poolPreparedStatements;
  }

  public Integer getMaxPoolPreparedStatementPerConnectionSize() {
    return this.maxPoolPreparedStatementPerConnectionSize;
  }

  public void setMaxPoolPreparedStatementPerConnectionSize(Integer maxPoolPreparedStatementPerConnectionSize) {
    this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
  }

  public String getFilters() {
    return this.filters;
  }

  public void setFilters(String filters) {
    this.filters = filters;
  }

  public Boolean getOnOff() {
    return this.onOff;
  }

  public void setOnOff(Boolean onOff) {
    this.onOff = onOff;
  }
}