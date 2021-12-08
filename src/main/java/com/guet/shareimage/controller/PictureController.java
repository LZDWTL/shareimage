package com.guet.shareimage.controller;

import com.guet.shareimage.mapper.PictureMapper;
import com.guet.shareimage.response.RespBean;
import com.guet.shareimage.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author LZDWTL
 * @Date 2021-12-07 19:46
 * @ClassName PictureController
 * @Description 图片控制器
 */
@RestController
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/uploadPicture")
    public RespBean uploadPicture(String imagePath) throws IOException {

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(imagePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int len = 0;
        byte[] buff = new byte[1024];
        List<byte[]> byteList = new ArrayList<byte[]>();
        int allLen = 0;

        while ((len = fileInputStream.read(buff)) != -1) {   //未读到文件末尾则接着读
            byte[] dest = new byte[len];
            System.arraycopy(buff, 0, dest, 0, len);   //将buff数组复制到的dest数组
//            dest=Arrays.copyOfRange(buff,0,len);
            /**
             * public static native void arraycopy(Object src,  int  srcPos, Object dest, int destPos,int length);
             *
             *     src：要复制的数组(源数组)
             *     srcPos：复制源数组的起始位置
             *     dest：目标数组
             *     destPos：目标数组的下标位置
             *     length：要复制的长度
             */
            allLen += len;
            byteList.add(dest);
        }
        fileInputStream.close();

        byte[] bytes = new byte[allLen];
        int position = 0;
        for (int i = 0; i < byteList.size(); i++) {
            if (i == 0) {
                position = 0;
            } else {
                position += byteList.get(i - 1).length;   //加上前面字节的位置
            }
            System.arraycopy(byteList.get(i), 0, bytes, position, byteList.get(i).length);
        }
        System.out.println(Arrays.toString(bytes));
//        String baseStr = Base64.getEncoder().encodeToString(bytes);
//        byte[] op = Base64.getDecoder().decode(baseStr);

//        return null;
        return pictureService.savePicture(bytes);
    }

}
