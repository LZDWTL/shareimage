package com.guet.shareimage.controller;

import com.guet.shareimage.response.RespBean;
import com.guet.shareimage.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LZDWTL
 * @Date 2021-12-08 17:20
 * @ClassName LikeController
 * @Description 点赞
 */
@RestController
public class LikeController {

    @Autowired
    private LikeService likeService;

    @RequestMapping("/giveLike")
    public RespBean giveLike(){
        return likeService.saveLike(1,1);
    }
}
