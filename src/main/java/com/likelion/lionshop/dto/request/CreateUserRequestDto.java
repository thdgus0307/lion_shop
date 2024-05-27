package com.likelion.lionshop.dto.request;

import com.likelion.lionshop.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@NoArgsConstructor //매개변수 없는 생성자를 생성해 줍니다.
@AllArgsConstructor //모든 매개변수를 받는 생성자를 생성해 줍니다.
@Getter //모든 필드의 Getter 메서드를 자동으로 생성해줍니다.
public class CreateUserRequestDto {

    @Size(min = 1, max = 20, message = "이름은 1~20 글자여야 합니다.")
    public String name;

    @NotNull(message = "email은 필수값입니다.")
    public String email;

    @Size(min = 8, message = "비밀번호는 8자리 이상이어야 합니다.")
    public String password;

    public String address;

    public User toEntity(PasswordEncoder passwordEncoder) {
        String encodedPassword = passwordEncoder.encode(password);
        return User.builder()
                .name(name)
                .email(email)
                .password(encodedPassword)
                .address(address)
                .roles("USER")
                .build();
    }

}
