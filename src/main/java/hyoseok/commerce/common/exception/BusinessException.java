package hyoseok.commerce.common.exception;

import hyoseok.commerce.common.response.ResponseCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final ResponseCode code;
    private final String message;

    public BusinessException(ResponseCode code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(ResponseCode code) {
        this(code, code.getMessage());
    }

    public BusinessException(String message) {
        super(message);
        this.code = ResponseCode.BAD_REQUEST;
        this.message = message;
    }
}
