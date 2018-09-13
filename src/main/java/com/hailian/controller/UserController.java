package com.hailian.controller;

import io.swagger.annotations.ApiOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hailian.annotation.AuthPower;
import com.hailian.domain.DbConfig;
import com.hailian.domain.User;
import com.hailian.result.ResultDO;
import com.hailian.service.UserService;
import com.hailian.utils.JdbcUtil;

/**
 * @Package com.hailian.controller.UserController
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/12 15:30
 * version V1.0.0
 */
@RestController
@RequestMapping("/api/{version}/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	@ApiOperation(value = "查询单个用户", notes = "根据传入id查找用户", httpMethod = "GET")
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResultDO<User> get(@PathVariable("id") Integer id) {
		ResultDO<User> resultDO = new ResultDO<>();
		resultDO.setSuccess(true);
		resultDO.setData(userService.getUserById(id));
		return resultDO;
	}

	/*  @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
	  @ApiImplicitParams({
	          @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
	  })*/
	@ApiOperation(value = "新增用户信息", notes = "根据过来的user信息来新增用户")
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public ResultDO<Integer> add(User user) {
		ResultDO<Integer> resultDO = new ResultDO<>();
		resultDO.setSuccess(true);
		resultDO.setData(userService.save(user));
		return resultDO;
	}

	/**
	 * 
	 * @time   2018年9月13日 上午10:39:24
	 * @author zuoqb
	 * @todo   测试jdbc获取数据库信息
	 * @param  @param id
	 * @param  @return
	 * @return_type   ResultDO<List<Map<String,Object>>>
	 */
	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	@ApiOperation(value = "jdbc获取单个用户", notes = "根据传入id查找用户", httpMethod = "GET")
	@RequestMapping(value = "/getByJdbc/{id}", method = RequestMethod.GET)
	public ResultDO<List<Map<String, Object>>> getByJdbc(@PathVariable("id") Integer id) {
		ResultDO<List<Map<String, Object>>> resultDO = new ResultDO<>();
		String sql = "select * from user where id='" + id + "'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> map : list) {
			Set<Entry<String, Object>> entrySet = map.entrySet();
			if (entrySet != null) {
				Iterator<Entry<String, Object>> iterator = entrySet.iterator();
				while (iterator.hasNext()) {
					Entry<String, Object> entry = (Entry<String, Object>) iterator.next();
					System.out.println(entry.getKey() + ":" + entry.getValue());
				}
			}
		}
		resultDO.setSuccess(true);
		resultDO.setData(list);
		return resultDO;
	}

	/**
	 * 
	 * @time   2018年9月13日 上午10:39:24
	 * @author zuoqb
	 * @todo   测试原始jdbc获取数据库信息
	 * @param  @param id
	 * @param  @return
	 * @return_type   ResultDO<User>
	 */
	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	@ApiOperation(value = "原始jdbc获取用户", notes = "根据传入id查找用户", httpMethod = "GET")
	@RequestMapping(value = "/getByOrgJdbc/{id}", method = RequestMethod.GET)
	public ResultDO<User> getByOrgJdbc(@PathVariable("id") Integer id) {
		ResultDO<User> resultDO = new ResultDO<>();
		DbConfig config = new DbConfig("mysql", "com.mysql.jdbc.Driver",
				"jdbc:mysql://10.130.96.74:3306/lianxin?characterEncoding=utf8", "root", "hl123456");
		Connection conn = JdbcUtil.getConn(config);
		PreparedStatement pstmt;
		ResultSet rs;
		try {
			String sql = "select * from sys_user where userid='" + id + "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			User user=null;
			while (rs.next()) {
				user=new User(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getInt(6), null);
			}
			JdbcUtil.close(conn, pstmt, rs);
			resultDO.setSuccess(true);
			resultDO.setData(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultDO;
	}
}
