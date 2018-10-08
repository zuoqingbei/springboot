package com.hailian.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import org.apache.commons.lang3.StringUtils;

import com.alibaba.druid.util.JdbcConstants;
import com.hailian.entity.DbDatasourceConfig;

/**
 * @time   2018年9月13日 上午10:38:25
 * @author zuoqb
 * @todo   原始JDBC连接工具
 */
public class JdbcUtil {
	private static Connection conn = null;
	/*static String HIVE_JDBC_DRIVER = "org.apache.hive.jdbc.HiveDriver";
	static String MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String ORACLE_JDBC_DRIVER = "oracle.jdbc.OracleDriver";
	static String IMPALA_JDBC_DRIVER = "com.cloudera.impala.jdbc41.Driver";
	static String POSTGRESQL_JDBC_DRIVER="org.postgresql.Driver";*/
	/**
	 * 统一接口jdbc连接配置
	 */
	public static Connection getConn(DbDatasourceConfig config) {
		if(config==null){
			return null;
		}
		if(StringUtils.isEmpty(config.getDbUrl())||StringUtils.isEmpty(config.getDbName())
				||StringUtils.isEmpty(config.getDbDiver())||StringUtils.isEmpty(config.getDbType())){
			return null;
		}
		try {
			String dbType = config.getDbType().toLowerCase();
			String connectionUrl = config.getDbUrl();
			switch (dbType) {
			case JdbcConstants.MYSQL:
				connectionUrl=connectionUrl.split("\\?")[0];
				connectionUrl+="?useUnicode=true&characterEncoding=utf8&useSSL=false";
				break;
			/*case "impala":
				connectionUrl+=";auth=noSasl";
				break;*/
			default:
				break;
			}
			System.out.println(connectionUrl);
			Connection conn = null;
			Class.forName(config.getDbDiver());
			conn = DriverManager.getConnection(connectionUrl, config.getDbName(), config.getDbPassword());
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	/**
	 * 
	 * @time   2018年9月13日 上午11:09:37
	 * @author zuoqb
	 * @todo   关闭
	 */
	public static void close(Connection conn,Statement stat,ResultSet rs){
		 try {
			 if (rs!=null) {
				rs.close();
			 }
			 if (stat!=null) {
				stat.close();
			 }
			 if (conn!=null&&!conn.isClosed()) {
				 //保证从池当中拿出的连接都是自动提交的
				//conn.setAutoCommit(true);
				conn.close();
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	 /**
     * 
     * @time   2018年9月27日 上午12:17:18
     * @author zuoqb
     * @todo   将结果集转成List<Map<String,Object>>
     */
	public static List<Map<String, Object>> parseResultSet2List(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		String[] colNames = new String[columnCount];//所有列名
		for(int bo = 0; bo < colNames.length; ++bo) {
		    colNames[bo] = rsmd.getColumnLabel(bo + 1);
		    if(colNames[bo] != null) {
		        colNames[bo] = colNames[bo];
		    }
		}
		while(rs.next()) {
		    Map<String, Object> mapOfColValues = new HashMap<String, Object>();
		    for(int i = 1; i <= columnCount; ++i) {
		    	mapOfColValues.put(colNames[i - 1], rs.getString(i));
		    }
		    list.add(mapOfColValues);
		}
		return list;
	}

}
