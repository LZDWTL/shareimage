package com.guet.shareimage.exception;

import com.guet.shareimage.response.RespBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author LZDWTL
 * @Date 2021-12-06 21:22
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * @Author: LZDWTL
     * @param: [e]
     * @return: com.guet.shareimage.response.RespBean
     * @Description: 业务异常
     */
    @ExceptionHandler(value = ServicesException.class)
    public RespBean servicesExceptionHandler(ServicesException e){
        logger.error("发生业务异常!原因是：{}",e.getMsg());
        return new RespBean(e);
    }


    /**
     * @Author: LZDWTL
     * @param: [e]
     * @return: com.guet.shareimage.response.RespBean
     * @Description: 其他异常
     */
    @ExceptionHandler(value =Exception.class)
    public RespBean exceptionHandler(Exception e){
        logger.error("未知异常！原因是:",e);
        return new RespBean();
    }
}
