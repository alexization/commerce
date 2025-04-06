package hyoseok.commerce.user.service.dto;

import hyoseok.commerce.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRegisterResponse {
    private final String email;
    private final String name;

    public static UserRegisterResponse from(User user) {
        return UserRegisterResponse.builder()
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
