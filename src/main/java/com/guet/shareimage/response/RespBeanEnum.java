package com.guet.shareimage.response;

/**
 * @Author LZDWTL
 * @Date 2021-12-06 15:34
 * @ClassName RespBeanEnum
 * @Description 返回码枚举类
 */
public enum RespBeanEnum implements CommonResp{

    SUCCESS(200,"请求成功!"),
    ERROR(500,"服务器响应错误！"),

    /** 10XX 表示用户错误*/
    USER_REGISTER_FAILED(1001, "注册失败"),
    USER_ACOUNT_EXISTED(1002,"用户名已存在"),
    USER_ACOUNT_NOT_EXISTED(1003,"用户名不存在"),
    USER_PASSWORD_ERROR(1004,"密码错误"),



    /** 20XX 表示服务器错误 */
    PICTURE_UPLOAD_FAILED(2001,"上传图片失败"),
    GIVE_LIKE_FAILED(2002,"点赞失败"),
    ;

    private Integer code;
    private String msg;

    RespBeanEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    @Override
    public CommonResp setMsg(String msg) {
        this.msg=msg;
        return this;
    }
}
