package com.hailian.service.impl;

import com.hailian.entity.CommonInterfaceExc;
import com.hailian.mapper.CommonInterfaceExcMapper;
import com.hailian.service.ICommonInterfaceExcService;
import com.hailian.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
/**
 * 统一接口服务实现类
 * @author zuoqb123
 * @date 2018-09-27
 */
@Service
@Transactional
public class CommonInterfaceExcServiceImpl extends BaseServiceImpl<CommonInterfaceExcMapper, CommonInterfaceExc> implements ICommonInterfaceExcService {

    @Autowired
    private CommonInterfaceExcMapper commonInterfaceExcMapper;
   
}
