package com.jh.version2.common.response;

import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    public <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(true, 200, "성공", data);
    }

    public BaseResponse<?> failure(int httpStatus, String message) {
        return new BaseResponse<>(false, httpStatus, message, null);
    }

}
