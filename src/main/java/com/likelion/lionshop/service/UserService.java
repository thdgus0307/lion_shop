package com.likelion.lionshop.service;


import com.likelion.lionshop.dto.request.CreateUserRequestDto;
import com.likelion.lionshop.dto.request.UpdateOrderRequestDto;
import com.likelion.lionshop.dto.request.UpdateUserRequestDto;
import com.likelion.lionshop.dto.response.OrderResponseDto;
import com.likelion.lionshop.dto.response.UserResponseDto;
import com.likelion.lionshop.entity.Order;
import com.likelion.lionshop.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void createUser(CreateUserRequestDto createUserRequestDto){
        User user = User.builder()
                .name(createUserRequestDto.getName())
                .address(createUserRequestDto.getAddress())
                .password(createUserRequestDto.getPassword())
                .build();
    }

    public UserResponseDto getUser(String id) {
        User user = null;
        UserResponseDto dto = UserResponseDto.from(user);
        return dto;
    }

    public void updateUser(UpdateUserRequestDto updateUserRequestDto) {
        User user = null;
        user.update(updateUserRequestDto.name, updateUserRequestDto.address);
    }

    public static void deleteUser(String id) {

    }

}
