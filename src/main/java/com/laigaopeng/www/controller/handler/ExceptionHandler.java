package com.laigaopeng.www.controller.handler;

import com.laigaopeng.www.exception.BusinessException;
import com.laigaopeng.www.pojo.vo.Result;
import com.laigaopeng.www.util.enumhelper.CodeEnum;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 */
@RestControllerAdvice
public class ExceptionHandler {

    /**
     * 对参数错误得异常处理
     *
     * @return 结果
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    public Result doBusinessException() {
        return new Result(false, CodeEnum.WRONG_PARAMETER.getCode(), CodeEnum.WRONG_PARAMETER.getMsg());
    }

    /**
     * 对运行错误得异常处理
     *
     * @return 结果
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public Result doRuntimeException() {
        return new Result(false, CodeEnum.EXCEPTION.getCode(), CodeEnum.EXCEPTION.getMsg());
    }
}
