package com.hailian.service.impl;

import com.hailian.entity.DbDatasourceConfig;
import com.hailian.mapper.DbDatasourceConfigMapper;
import com.hailian.service.IDbDatasourceConfigService;
import com.hailian.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
/**
 * 数据源配置服务实现类
 * @author zuoqb123
 * @date 2018-09-27
 */
@Service
@Transactional
public class DbDatasourceConfigServiceImpl extends BaseServiceImpl<DbDatasourceConfigMapper, DbDatasourceConfig> implements IDbDatasourceConfigService {

    @Autowired
    private DbDatasourceConfigMapper dbDatasourceConfigMapper;
   
}
