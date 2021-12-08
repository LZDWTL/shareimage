package com.guet.shareimage.service.impl;

import com.guet.shareimage.mapper.PictureMapper;
import com.guet.shareimage.mapper.UserMapper;
import com.guet.shareimage.response.RespBean;
import com.guet.shareimage.response.RespBeanEnum;
import com.guet.shareimage.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author LZDWTL
 * @Date 2021-12-07 19:50
 * @ClassName PictureServiceImpl
 * @Description
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureMapper pictureMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public RespBean savePicture(byte[] binaryPicture) {
//        String username="";
////        int userId =userMapper.findUser(token);  //怎么通过token去确定用户id   ？
        int result=pictureMapper.savePicture(binaryPicture,userId);

        if (result!=1){
            System.out.println("插入错误");
        }
        return new RespBean(RespBeanEnum.SUCCESS);
    }
}
