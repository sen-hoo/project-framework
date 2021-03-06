package com.cc.springsealed.webcore.advices;

import com.cc.common.ResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @Description web全局异常处理
 * @Author sen.hu
 * @Date 2018/11/29 13:36
 **/
@RestControllerAdvice
public class GloableExceptionAdvice {

    private Logger logger = LoggerFactory.getLogger(GloableExceptionAdvice.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultBuilder.Result exception500(Exception e) {
        logger.error("ServerError:", e);
        return ResultBuilder.getBaseResult(ResultBuilder.BaseResult.ServerError);
    }
    @ExceptionHandler(value = {MissingServletRequestParameterException.class, IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.OK)
    public ResultBuilder.Result exception400(MissingServletRequestParameterException e) {
        return ResultBuilder.getBaseResult(ResultBuilder.BaseResult.BadRequest);
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultBuilder.Result exception404(NoHandlerFoundException e) {
        return ResultBuilder.getBaseResult(ResultBuilder.BaseResult.NotFound);
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultBuilder.Result exception405(MethodArgumentTypeMismatchException e) {
        return ResultBuilder.getBaseResult(ResultBuilder.BaseResult.MethodNotAllowed);
    }
    @ExceptionHandler(ResultBuilder.CustomizedException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultBuilder.Result businessException(ResultBuilder.CustomizedException e) {
        return ResultBuilder.getBaseResult(e.getDefaultMsg());
    }

}
