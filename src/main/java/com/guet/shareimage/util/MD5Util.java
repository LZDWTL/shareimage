package com.guet.shareimage.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author LZDWTL
 * @Date 2021-12-07 11:34
 * @ClassName MD5Util
 * @Description MD5两次加密
 */
public class MD5Util {

    public static String md5(String src) {        //md5加密
        return DigestUtils.md5Hex(src);
    }

    /**
     * 公用固定盐
     */
    private static final String salt = "5e4d2b";

    //第一次加密
    public static String inputPassToFromPass(String inputPass) {
        /**
         * 这里只去盐的一部分，做了一下混淆
         * 54cb
         */
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(3) + salt.charAt(5);
        return md5(str);
    }

    //第二次加密，盐可以是随机私有盐
    public static String formPassToDBPass(String formPass, String privateSalt) {
        String str = "" + privateSalt.charAt(0) + privateSalt.charAt(2) + formPass + privateSalt.charAt(3) + privateSalt.charAt(5);
        return md5(str);
    }

    public static String inputPassToDBPass(String inputPass, String privateSalt) {
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = formPassToDBPass(fromPass, privateSalt);
        return dbPass;
    }

    public static void main(String[] args) {
        //9f3fdb9e03cbe7562241a7b80195b810
        System.out.println(inputPassToFromPass("123456"));

        //037af99060dadab029bec70daf800e17
        System.out.println(formPassToDBPass("9f3fdb9e03cbe7562241a7b80195b810", salt));

        System.out.println(inputPassToDBPass("123456", salt));
    }
}
