package org.example.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Getter
@RequiredArgsConstructor
public enum ErrorList {

    AUTH_FAIL(HttpStatusCode.valueOf(401),"인증 실패");

    private final HttpStatusCode httpStatusCode;
    private final String message;
}
