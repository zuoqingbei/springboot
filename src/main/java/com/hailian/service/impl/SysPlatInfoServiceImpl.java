package com.hailian.service.impl;

import com.hailian.entity.SysPlatInfo;
import com.hailian.mapper.SysPlatInfoMapper;
import com.hailian.service.ISysPlatInfoService;
import com.hailian.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
/**
 * 平台信息服务实现类
 * @author zuoqb123
 * @date 2018-09-27
 */
@Service
@Transactional
public class SysPlatInfoServiceImpl extends BaseServiceImpl<SysPlatInfoMapper, SysPlatInfo> implements ISysPlatInfoService {

    @Autowired
    private SysPlatInfoMapper sysPlatInfoMapper;
   
}
