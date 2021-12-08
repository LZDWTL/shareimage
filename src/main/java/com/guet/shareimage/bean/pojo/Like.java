package com.guet.shareimage.bean.pojo;

import lombok.Data;

/**
 * @author LZDWTL
 * @date 2021-12-03 17:03
 */
@Data
public class Like {
    private int likeId;     //点赞id，一个id表示一个赞
    private int pictureId;  //图片id
    private int userId;     //用户id
}
