package com.likelion.lionshop.service;


import com.likelion.lionshop.dto.request.CreateUserRequestDto;
import com.likelion.lionshop.dto.request.UpdateUserRequestDto;
import com.likelion.lionshop.dto.response.UserResponseDto;
import com.likelion.lionshop.entity.User;
import com.likelion.lionshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static UserRepository userRepository;

    public void createUser(CreateUserRequestDto createUserRequestDto){
        User user = User.builder()
                .name(createUserRequestDto.getName())
                .address(createUserRequestDto.getAddress())
                .password(createUserRequestDto.getPassword())
                .build();
        userRepository.save(user);
    }

    public UserResponseDto getUser(String id) {
        User user = null;
        UserResponseDto dto = UserResponseDto.from(user);
        return dto;
    }

    public void updateUser(UpdateUserRequestDto updateUserRequestDto) {
        Optional<User> optionalUser = userRepository.findById(updateUserRequestDto.getId());

        optionalUser.ifPresent(user -> {user.update(updateUserRequestDto.getName(), updateUserRequestDto.getAddress());
        });

    }

    public static void deleteUser(String id) {
        userRepository.deleteById(id);

    }

}
