package hyoseok.commerce.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    /* 공통 응답 코드 */
    OK("200", "Success"),
    BAD_REQUEST("400", "Bad Request"),
    UNAUTHORIZED("401", "Unauthorized"),
    FORBIDDEN("403", "Forbidden"),
    NOT_FOUND("404", "Not Found"),
    INTERNAL_SERVER_ERROR("500", "Internal Server Error"),

    /* 계정 관련 응답 코드 */
    DUPLICATED_EMAIL("1000", "이미 사용중인 이메일입니다."),
    INVALID_EMAIL("1001", "올바르지 않은 이메일 형식입니다."),
    INVALID_NAME("1002", "올바르지 않은 이름입니다.");

    private final String code;
    private final String message;
}
