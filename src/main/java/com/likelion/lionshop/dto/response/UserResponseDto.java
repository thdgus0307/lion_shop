package com.likelion.lionshop.dto.response;

import com.likelion.lionshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {

    private Long id;

    private String address;

    private String tel;

    private String email;

    public static UserResponseDto from(User user){
        return UserResponseDto.builder()
                .id(user.getId())
                .address(user.getAddress())
                .tel(user.getTel())
                .email(user.getEmail())
                .build();
    }



}
