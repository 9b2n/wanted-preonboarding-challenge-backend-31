package com.wanted.backend.enums;

public enum ErrorCode {
    INVALID_INPUT(400, "잘못된 입력 데이터"),
    RESOURCE_NOT_FOUND(404, "요청한 리소스를 찾을 수 없음"),
    UNAUTHORIZED(401, "인증되지 않은 요청"),
    FORBIDDEN(403, "권한이 없는 요청"),
    CONFLICT(409, "리소스 충돌 발생"),
    INTERNAL_ERROR(500, "서버 내부 오류")
    ;

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
