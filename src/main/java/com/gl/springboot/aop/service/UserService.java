package com.gl.springboot.aop.service;

import com.gl.springboot.entity.UserInfo;
import com.gl.springboot.vo.ResultVO;

/**
 * @Description:
 * @Auther: za-guanlei
 * @Date: 2021/05/28/16:23
 */
public interface UserService {

    ResultVO addUserInfo(UserInfo userInfo);
}
