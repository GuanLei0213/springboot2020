/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.aop.service.impl;

import com.gl.springboot.aop.service.UserService;
import com.gl.springboot.entity.UserInfo;
import com.gl.springboot.vo.ResultVO;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Auther: za-guanlei
 * @Date: 2021/05/28/16:24
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public ResultVO addUserInfo(UserInfo userInfo) {
        return ResultVO.build(Boolean.TRUE,"success!",userInfo);
    }
}
