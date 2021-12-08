package com.guet.shareimage.service;

import com.guet.shareimage.bean.DTO.LoginDTO;
import com.guet.shareimage.response.RespBean;

/**
 * @author LZDWTL
 * @date 2021-12-04 17:14
 */
public interface UserService {

    RespBean register(String username, String password);  //注册用户

    RespBean doLogin(String username, String password);  //登陆
}
