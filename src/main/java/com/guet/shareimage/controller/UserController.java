package com.guet.shareimage.controller;

import com.guet.shareimage.bean.DTO.LoginDTO;
import com.guet.shareimage.response.RespBean;
import com.guet.shareimage.response.RespBeanEnum;
import com.guet.shareimage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LZDWTL
 * @date 2021-12-03 17:12
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Author: LZDWTL
     * @param: [loginDTO]
     * @return: com.guet.shareimage.response.RespBean
     * @Description: 注册用户
     */
    @RequestMapping("/register")
    public RespBean register(@RequestBody LoginDTO loginDTO) {

        RespBean respBean = userService.register(loginDTO.getUsername(), loginDTO.getPassword());

        if (respBean.getCode().equals(RespBeanEnum.SUCCESS.getCode())) {
            return new RespBean(RespBeanEnum.SUCCESS);          //注册成功
        } else {
            return new RespBean(RespBeanEnum.USER_REGISTER_FAILED);   //注册失败
        }
    }


    /**
     * @Author: LZDWTL
     * @param: [loginDTO]
     * @return: com.guet.shareimage.response.RespBean
     * @Description: 登陆
     */
    @RequestMapping("/doLogin")
    public RespBean doLogin(@RequestBody LoginDTO loginDTO){

        return userService.doLogin(loginDTO.getUsername(),loginDTO.getPassword());
    }

}
