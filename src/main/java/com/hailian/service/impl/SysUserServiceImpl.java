package com.hailian.service.impl;

import com.hailian.entity.SysUser;
import com.hailian.mapper.SysUserMapper;
import com.hailian.service.ISysUserService;
import com.hailian.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
/**
 * 用户表服务实现类
 * @author zuoqb123
 * @date 2018-09-28
 */
@Service
@Transactional
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
   
}
