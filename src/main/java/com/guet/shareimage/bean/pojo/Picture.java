package com.guet.shareimage.bean.pojo;

import lombok.Data;

/**
 * @author LZDWTL
 * @date 2021-12-03 17:01
 */
@Data
public class Picture {
    private int pictureId;     //图片id
    private byte[] picture;    //图片
    private int userId;        //用户id
    private String details;    //图片简介详情
}
