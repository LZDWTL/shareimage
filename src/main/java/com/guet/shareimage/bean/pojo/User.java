package com.guet.shareimage.bean.pojo;

import lombok.Data;

/**
 * @author LZDWTL
 * @date 2021-12-03 16:57
 */
@Data
public class User {
    private int userId;             //用户id，用于区分用户，不做业务
    private String username;       //用户名
    private String password;       //密码
    private String nickname;       //昵称
    private byte[] headPortrait;    //头像
    private String details;        //简介详情
    private String salt;            //私有盐
}
