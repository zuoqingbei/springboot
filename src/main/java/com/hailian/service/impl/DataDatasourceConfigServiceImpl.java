package com.hailian.service.impl;

import org.jon.lv.pagination.Page;
import com.hailian.entity.DataDatasourceConfig;
import com.hailian.mapper.DataDatasourceConfigMapper;
import com.hailian.service.IDataDatasourceConfigService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * <p>
 * 数据源配置 服务实现类
 * </p>
 * @author zuoqb123
 * @date 2018-09-24
 */
@Service
@Transactional
public class DataDatasourceConfigServiceImpl extends ServiceImpl<DataDatasourceConfigMapper, DataDatasourceConfig> implements IDataDatasourceConfigService {


    @Autowired
    private DataDatasourceConfigMapper dataDatasourceConfigMapper;
    
	@Override
	public DataDatasourceConfig selectByIds(Integer id) {
		// TODO Auto-generated method stub
		return dataDatasourceConfigMapper.selectByIds(id);
	}
	
	/**
     * @todo   分页查询
     * @author zuoqb123
     * @date   2018-09-24
     */
	@Override
	public List<DataDatasourceConfig> queryPage(Page<DataDatasourceConfig> page) {
		// TODO Auto-generated method stub
		return dataDatasourceConfigMapper.queryPage(page);
	}
   
}
