package com.lotus.web.interceptor;

import com.lotus.orz.ApiResponse;
import com.lotus.web.exception.BizzException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/***
 * 控制层统一异常处理
 *
 * @haikuo.zhk
 */
@RestControllerAdvice
@Slf4j
public class StandardWebExceptionHandler {

    /***
     * 处理Controller层抛出的Exception异常
     *
     * @param e
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ExceptionHandler({ Exception.class })
    public ApiResponse<?> handleException(Exception e, WebRequest request) throws Exception {
        try {
            if (e instanceof HttpRequestMethodNotSupportedException) {
                throw new BizzException("METHOD_ERR", "Request method is not supported");
            } else if (e instanceof MissingPathVariableException) {
                throw new BizzException("MISSING_PATHVAR", e.getMessage());
            } else if (e instanceof MissingServletRequestParameterException) {
                MissingServletRequestParameterException localEx = (MissingServletRequestParameterException) e;
                throw new BizzException("MISSING_" + localEx.getParameterName().toUpperCase(), localEx.getMessage());
            } else if (e instanceof TypeMismatchException) {
                throw new BizzException("TYPE_MISMATCH", e.getMessage());
            } else if (e instanceof HttpMessageNotReadableException) {
                throw new BizzException("UNREADABLE_BODY", e.getMessage());
            } else {
                throw new BizzException("UNDEFINED", e.getMessage());
            }
        } catch (BizzException ex) {
            /** 根据异常类型统一封装成BizException返回 */
            return ApiResponse.error(ex.getMessage());

        } catch (Exception ex) {
            log.error("Error when handling controller exception, re-throw controller exception", ex);
            throw ex;
        }
    }
}
