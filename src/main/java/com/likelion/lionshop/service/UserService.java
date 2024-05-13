package com.likelion.lionshop.service;


import com.likelion.lionshop.dto.request.CreateUserRequestDto;
import com.likelion.lionshop.dto.request.UpdateUserRequestDto;
import com.likelion.lionshop.dto.response.UserResponseDto;
import com.likelion.lionshop.entity.User;
import com.likelion.lionshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void createUser(CreateUserRequestDto createUserRequestDto){
        User user = createUserRequestDto.toEntity(passwordEncoder);
        userRepository.save(user);
    }

    public UserResponseDto getUser(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        UserResponseDto dto = UserResponseDto.from(user);
        return dto;
    }

    public void updateUser(UpdateUserRequestDto updateUserRequestDto) {
        Optional<User> optionalUser = userRepository.findById(updateUserRequestDto.getId());

        optionalUser.ifPresent(user -> {user.update(updateUserRequestDto.getName(), updateUserRequestDto.getAddress());
        });
        User user = userRepository.findById(updateUserRequestDto.getId()).orElseThrow(
                ()-> new IllegalArgumentException("상품이 존재하지 않습니다."));

    }

    public void deleteUser(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();

        userRepository.deleteById(user.getId());

    }

}
