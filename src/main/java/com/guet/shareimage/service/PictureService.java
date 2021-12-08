package com.guet.shareimage.service;

import com.guet.shareimage.response.RespBean;

/**
 * @Author LZDWTL
 * @Date 2021-12-07 19:49
 * @ClassName PictureService
 * @Description
 */
public interface PictureService {
    RespBean savePicture(byte[] binaryPicture);
}
