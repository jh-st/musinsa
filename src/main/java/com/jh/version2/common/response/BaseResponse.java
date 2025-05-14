package com.jh.version2.common.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class BaseResponse<T> {

    private boolean success;
    private int code;
    private String message;
    private T data;

    public static <T> BaseResponse<T> ok(int code, String message, T data) {
        return new BaseResponse<>(true, code, message, data);
    }

    public static BaseResponse<Void> ok(int code, String message) {
        return new BaseResponse<>(true, code, message, null);
    }

    public static BaseResponse<Void> fail(int code, String message) {
        return new BaseResponse<>(false, code, message, null);
    }

}
