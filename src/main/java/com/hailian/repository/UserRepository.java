package com.hailian.repository;

import com.hailian.enums.PlatformType;
import com.hailian.result.ResultDO;

/**
 * @author Jack
 * @date 2018/1/22
 */
public interface UserRepository {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    ResultDO<String> login(String username, String password, PlatformType platformType);

    /**
     * 重置密码
     * @param userId
     * @return
     */
    ResultDO<Boolean> resetPwd(Long userId);

    /**
     * 找回密码
     * @param userId
     * @return
     */
    ResultDO<Boolean> retrievePwd(Long userId);
}
