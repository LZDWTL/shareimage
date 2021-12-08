package com.guet.shareimage.util;

import java.util.Random;

/**
 * @Author LZDWTL
 * @Date 2021-12-07 11:47
 * @ClassName SaltUtil
 * @Description 盐工具类
 */
public class SaltUtil {

    public static String generateSalt(){
        String val = "";
        Random random = new Random();
        //用循环输出六个字符进行拼接
        for (int i = 0; i < 6; i++) {
            // 本次循环是数字还是字母
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "number";
            //rand.nextInt(100);中的100是随机数的上限,产生的随机数为0-100的整数,不包括100。

            // 字母
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 本次字母为大写还是小写（ASCII），求余为0就是大写字母，不为0就是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                //生成这个字符
                val += (char) (choice + random.nextInt(26));
            }
            // 数字
            else if ("number".equalsIgnoreCase(charOrNum)) {
                //数字可以直接生成
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    public static void main(String[] args) {

        System.out.println("6位验证码为：" + SaltUtil.generateSalt());
    }
}
