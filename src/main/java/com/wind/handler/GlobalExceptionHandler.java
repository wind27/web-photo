package com.wind.handler;

import com.wind.common.ErrorCode;
import com.wind.utils.JsonResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalExceptionHandler
 *
 * @author qianchun 2019/1/10
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * 捕获异常
     * @param e 异常
     * @return 返回结果
     */
    @ExceptionHandler({ Exception.class }) // 申明捕获那个异常类
    public String exceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);

        return JsonResponseUtil.fail(ErrorCode.SYS_ERROR);
    }

    /**
     * 捕获RuntimeException
     * @param e 异常
     * @return 返回结果
     */
    @ExceptionHandler({ RuntimeException.class }) // 申明捕获那个异常类
    public String runtimeExceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);

        return JsonResponseUtil.fail(ErrorCode.SYS_ERROR);
    }

}
