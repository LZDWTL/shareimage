package com.guet.shareimage.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author LZDWTL
 * @Date 2021-12-07 19:47
 * @ClassName PictureMapper
 * @Description
 */
@Mapper
public interface PictureMapper {
    int savePicture(byte[] picture,int userId);
}
