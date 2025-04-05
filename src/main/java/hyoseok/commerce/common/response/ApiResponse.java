package hyoseok.commerce.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private final boolean success;
    private final String message;
    private final int code;
    private final T data;
    private final LocalDateTime timestamp;

    private ApiResponse(boolean success, String message, int code, T data) {
        this.success = success;
        this.message = message;
        this.code = code;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    /* 성공 응답 생성 메서드 */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, "Success", HttpStatus.OK.value(), data);
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, HttpStatus.OK.value(), data);
    }

    /* 에러 응답 생성 메서드 */
    public static <T> ApiResponse<T> error(String message, HttpStatus status) {
        return new ApiResponse<>(false, message, status.value(), null);
    }

    public static <T> ApiResponse<T> error(String message, HttpStatus status, T data) {
        return new ApiResponse<>(false, message, status.value(), data);
    }
}
