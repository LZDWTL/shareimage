package com.guet.shareimage.response;

import com.guet.shareimage.exception.ServicesException;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author LZDWTL
 * @Date 2021-12-06 15:33
 * @ClassName ReapBean
 * @Description 公用返回对象
 */
@Data
public class RespBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String msg;
    private Object obj;

    public RespBean(RespBeanEnum respBeanEnum, Object obj) {
        this.code = respBeanEnum.getCode();
        this.msg = respBeanEnum.getMsg();
        this.obj = obj;
    }

    public RespBean(RespBeanEnum respBeanEnum) {
        this.code = respBeanEnum.getCode();
        this.msg = respBeanEnum.getMsg();
    }

    public RespBean() {
        this.code = RespBeanEnum.ERROR.getCode();
        this.msg = RespBeanEnum.ERROR.getMsg();
    }

    public RespBean(String msg) {
        this.code = RespBeanEnum.ERROR.getCode();
        this.msg = msg;
    }

    //自定义的业务异常错误码和信息
    public RespBean(ServicesException e){
        this.code=e.getCode();
        this.msg=e.getMsg();
    }

}
