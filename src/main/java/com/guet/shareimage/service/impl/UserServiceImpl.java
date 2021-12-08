package com.guet.shareimage.service.impl;

import com.guet.shareimage.bean.DTO.LoginDTO;
import com.guet.shareimage.bean.pojo.User;
import com.guet.shareimage.exception.ServicesException;
import com.guet.shareimage.mapper.UserMapper;
import com.guet.shareimage.response.RespBean;
import com.guet.shareimage.response.RespBeanEnum;
import com.guet.shareimage.service.UserService;
import com.guet.shareimage.util.MD5Util;
import com.guet.shareimage.util.SaltUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LZDWTL
 * @date 2021-12-04 17:15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册功能
     *
     * @param username
     * @param password
     * @return RespBean
     * @throws ServicesException
     */
    @Override
    public RespBean register(String username, String password) throws ServicesException {
        User user = userMapper.findUser(username);
        if (user != null) {
            throw new ServicesException("用户名已存在", RespBeanEnum.USER_ACOUNT_EXISTED);
        } else {
            String salt = SaltUtil.generateSalt();    //生成私有盐并存到数据库中
            String encryptionPswd = MD5Util.inputPassToDBPass(password, salt);    //将二次加密后的密码存入数据库
            int result = userMapper.saveUser(username, encryptionPswd, salt);
            if (result != 1) {
                throw new ServicesException(RespBeanEnum.USER_REGISTER_FAILED);  //插入错误抛出异常，不确定是不是1？
            }
            return new RespBean(RespBeanEnum.SUCCESS);
        }
    }

    /**
     * 登陆功能
     *
     * @param username
     * @param password
     * @return RespBean
     */
    @Override
    public RespBean doLogin(String username, String password) throws ServicesException{
        User user = userMapper.findUser(username);
        if(user==null){
            throw new ServicesException("用户名不存在",RespBeanEnum.USER_ACOUNT_NOT_EXISTED);   //用户名不存在
        }
        if(!user.getPassword().equals(MD5Util.formPassToDBPass(password,user.getSalt()))){
            throw new ServicesException(RespBeanEnum.USER_PASSWORD_ERROR);    //密码错误异常
        }
        return new RespBean(RespBeanEnum.SUCCESS);
    }

}
