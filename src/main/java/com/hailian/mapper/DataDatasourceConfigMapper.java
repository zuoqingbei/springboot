package com.hailian.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.jon.lv.pagination.Page;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hailian.entity.DataDatasourceConfig;

/**
 * <p>
  * 数据源配置 Mapper 接口
 * </p>
 *
 * @author zuoqb123
 * @since 2018-09-21
 */
@Mapper
public interface DataDatasourceConfigMapper extends BaseMapper<DataDatasourceConfig> {
	@ResultMap(value = "BaseResultMap")
    @Select("SELECT * FROM data_datasource_config WHERE  id = #{id}")
    List<DataDatasourceConfig> selectListBySQL(Integer id);
	List<DataDatasourceConfig> queryPage(Page<DataDatasourceConfig> page);

}


