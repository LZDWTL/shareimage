package com.guet.shareimage.service.impl;

import com.guet.shareimage.exception.ServicesException;
import com.guet.shareimage.mapper.LikeMapper;
import com.guet.shareimage.response.RespBean;
import com.guet.shareimage.response.RespBeanEnum;
import com.guet.shareimage.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author LZDWTL
 * @Date 2021-12-08 17:25
 * @ClassName LikeServiceImpl
 * @Description
 */
@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeMapper likeMapper;

    @Override
    public RespBean saveLike(int pictureId, int userId) {
        int result=likeMapper.saveLike(pictureId, userId);
        if (result!=1){
            throw new ServicesException(RespBeanEnum.GIVE_LIKE_FAILED);
        }
        return new RespBean(RespBeanEnum.SUCCESS);
    }
}
