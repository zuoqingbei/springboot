/*package com.hailian.dynamic;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
*//**
 * 
 * @time   2018年9月25日 下午2:38:46
 * @author zuoqb
 * @todo   https://blog.csdn.net/FJeKin/article/details/79583744
 *//*
@Configuration
@MapperScan(basePackages={"com.hailian.mapper"})
public class MybatisPlusConfig
{

  @Autowired
  DruidProperties druidProperties;

  @Bean
  public PaginationInterceptor paginationInterceptor()
  {
    PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
    paginationInterceptor.setDialectType(DBType.MYSQL.getDb());
    return paginationInterceptor;
  }
  @Bean(name={"masterDataSource"})
  @Qualifier("masterDataSource")
  @ConfigurationProperties(prefix="spring.datasource")
  public DataSource masterDataSource() { 
	  return DataSourceBuilder.create().build(); 
  }

  @Bean(name={"slaveDataSource"})
  @Qualifier("slaveDataSource")
  public DataSource slaveDataSource() {
    DruidDataSource dataSource = new DruidDataSource();
    this.druidProperties.coinfig(dataSource);

    return dataSource;
  }

  @Bean
  @Primary
  public DynamicDataSource dataSource(@Qualifier("masterDataSource") DataSource master, @Qualifier("slaveDataSource") DataSource slave)
  {
    Map targetDataSources = new HashMap();
    targetDataSources.put(DatabaseType.master, master);
    targetDataSources.put(DatabaseType.slave, slave);

    DynamicDataSource dataSource = new DynamicDataSource();
    dataSource.setTargetDataSources(targetDataSources);
    dataSource.setDefaultTargetDataSource(slave);
    return dataSource;
  }

  @Bean
  public MybatisSqlSessionFactoryBean sqlSessionFactory(@Qualifier("masterDataSource") DataSource master, @Qualifier("slaveDataSource") DataSource slave) throws Exception
  {
    MybatisSqlSessionFactoryBean fb = new MybatisSqlSessionFactoryBean();
    fb.setDataSource(dataSource(master, slave));

    if (this.druidProperties.getOnOff().booleanValue()) {
      fb.setPlugins(new Interceptor[] { new DatabasePlugin() });
    }
    return fb;
  }
}*/