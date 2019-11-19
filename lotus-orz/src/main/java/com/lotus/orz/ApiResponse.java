package com.lotus.orz;

import lombok.Data;
import lombok.experimental.Accessors;

/***
 * 通用API请求返回数据结构
 *
 * @haikuo.zhk
 */
@Data
@Accessors(chain = true)
public class ApiResponse<T> {

    /** 请求是否成功 */
    private boolean success = true;

    /** 消息描述 */
    private String message;

    /** 返回的数据对象 */
    private T data;

    /***
     * 成功返回
     *
     * @return
     */
    public static ApiResponse<?> ok() {
        return ok("ok");
    }

    /***
     * 成功返回
     *
     * @param message
     * @return
     */
    public static ApiResponse<?> ok(String message) {
        ApiResponse<?> response = new ApiResponse<>();
        response.setSuccess(true)
                .setMessage(message);
        return response;
    }

    /***
     * 成功返回
     *
     * @param data
     * @return
     */
    public static ApiResponse<?> ok(Object data) {
        ApiResponse<Object> response = new ApiResponse<>();
        response.setSuccess(true)
                .setMessage("ok")
                .setData(data);
        return response;
    }

    /***
     * 错误返回
     *
     * @return
     */
    public static ApiResponse<?> error() {
        return error("error");
    }

    /***
     * 错误返回
     *
     * @param message
     * @return
     */
    public static ApiResponse<?> error(String message) {
        ApiResponse<?> response = new ApiResponse<>();
        response.setSuccess(false)
                .setMessage(message);
        return response;
    }
}
