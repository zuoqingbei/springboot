package com.hailian.service.impl;

import com.hailian.entity.SysOperationLog;
import com.hailian.mapper.SysOperationLogMapper;
import com.hailian.service.ISysOperationLogService;
import com.hailian.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
/**
 * 操作日志服务实现类
 * @author zuoqb123
 * @date 2018-09-28
 */
@Service
@Transactional
public class SysOperationLogServiceImpl extends BaseServiceImpl<SysOperationLogMapper, SysOperationLog> implements ISysOperationLogService {

    @Autowired
    private SysOperationLogMapper sysOperationLogMapper;
   
}
