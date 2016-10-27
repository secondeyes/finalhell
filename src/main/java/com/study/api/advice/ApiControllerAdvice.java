package com.study.api.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by yongjunjung on 2016. 10. 12..
 */

@ControllerAdvice
public class ApiControllerAdvice {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IllegalStateException.class)
    public String errorHandler(IllegalStateException ie) {
        logger.error("- IllegalStateException", ie);
        return "redirect:/";
    }

}
