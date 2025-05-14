package com.jh.version2.common.exception;

import com.jh.version2.common.response.BaseResponse;
import com.jh.version2.common.response.ResponseService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ResponseService responseService;

    // 400: 필수 파라미터 누락
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<BaseResponse> handleMissingRequestParam(MissingServletRequestParameterException e) {
        log.warn("필수 파라미터 누락: {}", e.getMessage());
        return ResponseEntity
                .badRequest()
                .body(responseService.failure(400, "필수 파라미터가 누락되었습니다: " + e.getParameterName()));
    }

    // 400: 잘못된 요청
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<BaseResponse> handleIllegalArgument(IllegalArgumentException e) {
        log.warn("잘못된 요청: {}", e.getMessage());
        return ResponseEntity
                .badRequest()
                .body(responseService.failure(400, "잘못된 요청입니다: " + e.getMessage()));
    }

    // 401: 인증 실패
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<BaseResponse> handleAuthenticationException(AuthenticationException e) {
        log.warn("인증 실패: {}", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(responseService.failure(401, "인증이 필요합니다."));
    }

    // 403: 권한 없음
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<BaseResponse> handleAccessDeniedException(AccessDeniedException e) {
        log.warn("접근 거부: {}", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(responseService.failure(403, "접근 권한이 없습니다."));
    }

    // 404: 리소스 없음
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<BaseResponse> handleEntityNotFoundException(EntityNotFoundException e) {
        log.warn("리소스를 찾을 수 없음: {}", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(responseService.failure(HttpStatus.NOT_FOUND.value(), StringUtils.defaultString(e.getMessage(), "요청하신 리소스를 찾을 수 없습니다.")));
    }

    // 500: 그 외 모든 예외
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handleAll(Exception e, HttpServletRequest request) throws Exception {
        String uri = request.getRequestURI();

        // Swagger 요청은 감싸지 말고 그냥 그대로 예외 던지기
        if (uri.contains("/v3/api-docs") || uri.contains("/swagger-ui") || uri.contains("/swagger-resources")) {
            throw e;
        }

        log.error("전역 예외 발생: {}", e.getMessage(), e);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(responseService.failure(500, "알 수 없는 서버 오류가 발생했습니다."));
    }

}