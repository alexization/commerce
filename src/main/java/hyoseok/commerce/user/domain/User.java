package hyoseok.commerce.user.domain;

import hyoseok.commerce.common.entity.BaseTimeEntity;

import hyoseok.commerce.common.exception.BusinessException;
import hyoseok.commerce.common.response.ResponseCode;
import hyoseok.commerce.cart.Cart;
import hyoseok.commerce.order.Order;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.Pattern;


@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 50)
    private String name;

    // 단순 조회를 위한 양방향 관계 설정
    @OneToMany(mappedBy = "user")
    private List<Cart> carts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @Builder
    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public static User createUser(String email, String name) {
        validateEmail(email);
        validateName(name);

        return User.builder()
                .email(email)
                .name(name)
                .build();
    }

    private static void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new BusinessException(ResponseCode.INVALID_EMAIL);
        }
        if (!Pattern.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", email)) {
            throw new BusinessException(ResponseCode.INVALID_EMAIL);
        }
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new BusinessException(ResponseCode.INVALID_NAME);
        }
        if (name.length() < 2 || name.length() > 10){
            throw new BusinessException(ResponseCode.INVALID_NAME);
        }
    }

}
