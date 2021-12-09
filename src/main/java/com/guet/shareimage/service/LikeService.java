package com.guet.shareimage.service;

import com.guet.shareimage.response.RespBean;

/**
 * @Author LZDWTL
 * @Date 2021-12-08 17:23
 * @ClassName LikeService
 * @Description
 */
public interface LikeService {
    RespBean saveLike(int pictureId,int userId);
}
