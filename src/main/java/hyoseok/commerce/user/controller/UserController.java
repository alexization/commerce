package hyoseok.commerce.user.controller;

import hyoseok.commerce.common.response.ApiResponse;
import hyoseok.commerce.user.service.UserService;
import hyoseok.commerce.user.service.dto.UserRegisterRequest;
import hyoseok.commerce.user.service.dto.UserRegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ApiResponse<UserRegisterResponse> registerUser(@RequestBody UserRegisterRequest request) {
        return ApiResponse.success(userService.registerUser(request));
    }
}
