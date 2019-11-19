package com.lotus.web.exception;

/***
 * 统一业务异常封装
 *
 * @haikuo.zhk
 */
public class BizzException extends Exception {

    private String errorCode = "UNDEFINED";

    public BizzException(String message) {
        super(message);
    }

    public BizzException(String errorCode, String message) {
        super(errorCode + "-" + message);
        this.errorCode = errorCode;
    }

    public BizzException(String message, Exception e) {
        super(message, e);
    }
}
