package com.guet.shareimage.mapper;

import com.guet.shareimage.bean.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author LZDWTL
 * @date 2021-12-04 17:18
 */
@Mapper
public interface UserMapper {

    int saveUser(String username, String password, String salt);     //保存用户

    User findUser(String username);             //根据用户名查询用户
}
