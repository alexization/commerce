package hyoseok.commerce.user.service;

import hyoseok.commerce.common.exception.BusinessException;
import hyoseok.commerce.common.response.ResponseCode;
import hyoseok.commerce.domain.user.User;
import hyoseok.commerce.user.repository.UserRepository;
import hyoseok.commerce.user.service.dto.UserRegisterRequest;
import hyoseok.commerce.user.service.dto.UserRegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserRegisterResponse registerUser(UserRegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BusinessException(ResponseCode.DUPLICATED_EMAIL);
        }

        User user = User.createUser(request.getEmail(), request.getName());
        User savedUser = userRepository.save(user);

        return UserRegisterResponse.from(savedUser);
    }
}
