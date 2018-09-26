package com.hailian.service.impl;

import com.hailian.entity.DataDatasourceConfig;
import com.hailian.mapper.DataDatasourceConfigMapper;
import com.hailian.service.IDataDatasourceConfigService;
import com.hailian.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
/**
 * 数据源配置服务实现类
 * @author zuoqb123
 * @date 2018-09-26
 */
@Service
@Transactional
public class DataDatasourceConfigServiceImpl extends BaseServiceImpl<DataDatasourceConfigMapper, DataDatasourceConfig> implements IDataDatasourceConfigService {

    @Autowired
    private DataDatasourceConfigMapper dataDatasourceConfigMapper;
   
}
