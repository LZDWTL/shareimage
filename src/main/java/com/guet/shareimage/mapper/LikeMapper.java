package com.guet.shareimage.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author LZDWTL
 * @Date 2021-12-08 17:29
 * @ClassName LikeMapper
 * @Description
 */
@Mapper
public interface LikeMapper {
    int saveLike(int pictureId,int userId);
}
