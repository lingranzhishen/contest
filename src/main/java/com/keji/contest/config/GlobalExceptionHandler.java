package com.keji.contest.config;


import com.keji.contest.enums.ResultCode;
import com.keji.contest.exception.CommonException;
import com.keji.contest.gson.IntlResultGson;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        logger.error(ExceptionUtils.getFullStackTrace(e));  // 记录错误信息
        IntlResultGson resultGson=new IntlResultGson();
        if(e instanceof CommonException){
            resultGson.setRes_code(((CommonException) e).getErrorCode().getCode());
            resultGson.setRes_msg(((CommonException) e).getErrorMsg());
        }else{
            resultGson.setRes_code(ResultCode.EXCEPTION.getCode());
            resultGson.setRes_msg(ResultCode.EXCEPTION.getDesc());
        }
        return resultGson;
    }
}
