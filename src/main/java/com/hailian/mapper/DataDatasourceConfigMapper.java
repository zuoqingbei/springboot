package com.hailian.mapper;
import java.util.List;

import org.jon.lv.pagination.Page;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hailian.entity.DataDatasourceConfig;

/**
 * <p>
  * 数据源配置 Mapper 接口
 * </p>
 * @author zuoqb123
 * @date 2018-09-24
 */
public interface DataDatasourceConfigMapper extends BaseMapper<DataDatasourceConfig> {
    /**
	 * 
	 * @date 2018-09-24
	 * @author zuoqb123
	 * @todo   分页查询数据源配置
	 */
	List<DataDatasourceConfig> queryPage(Page<DataDatasourceConfig> page);
	DataDatasourceConfig selectByIds(Integer id);
}


