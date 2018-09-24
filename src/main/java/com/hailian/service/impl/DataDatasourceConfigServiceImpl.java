package com.hailian.service.impl;

import java.util.List;

import org.jon.lv.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hailian.entity.DataDatasourceConfig;
import com.hailian.mapper.DataDatasourceConfigMapper;
import com.hailian.service.IDataDatasourceConfigService;
/**
 * <p>
 * 数据源配置 服务实现类
 * </p>
 *
 * @author zuoqb123
 * @since 2018-09-21
 */
@Service
@Transactional
public class DataDatasourceConfigServiceImpl extends ServiceImpl<DataDatasourceConfigMapper, DataDatasourceConfig> implements IDataDatasourceConfigService {


    @Autowired
    private DataDatasourceConfigMapper dataDatasourceConfigMapper;

	@Override
	public List<DataDatasourceConfig> selectListBySQL(Integer id) {
		// TODO Auto-generated method stub
		return dataDatasourceConfigMapper.selectListBySQL(id);
	}

	@Override
	public List<DataDatasourceConfig> queryPage(Page<DataDatasourceConfig> page) {
		// TODO Auto-generated method stub
		return dataDatasourceConfigMapper.queryPage(page);
	}
}
