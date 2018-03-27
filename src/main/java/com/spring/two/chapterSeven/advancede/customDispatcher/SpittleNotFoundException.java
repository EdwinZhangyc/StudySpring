package com.spring.two.chapterSeven.advancede.customDispatcher;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 程序清单7.8 @ResponseStatus注解：将异常映射为特定的状态码
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,
                reason = "Spittle Not Found")
public class SpittleNotFoundException extends RuntimeException {
}