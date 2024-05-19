package com.likelion.lionshop.controller;

import com.likelion.lionshop.dto.request.CreateUserRequestDto;
import com.likelion.lionshop.dto.request.UpdateUserRequestDto;
import com.likelion.lionshop.dto.response.UserResponseDto;
import com.likelion.lionshop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Slf4j //로그 출력을 도와주는 어노테이션
@RestController
@RequestMapping("/user") // uri가 /user로 시작하는 요청을 받습니다.
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 1. 사용자를 생성하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 이름, 주소, ID, PW를 출력해줍니다. return 값은 "사용자 생성"입니다.
    @PostMapping("create")
    public String createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        log.info("이름: {}", createUserRequestDto.getName());
        log.info("주소: {}", createUserRequestDto.getAddress());
        log.info("Email: {}", createUserRequestDto.getEmail());
        log.info("PW: {}", createUserRequestDto.getPassword());

        userService.createUser(createUserRequestDto);

        return "사용자 생성";
    }

    //CreateUserRequestDto 클래스를 매개변수로 받습니다.
    // 2. 사용자를 조회하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 조회"입니다.
    @GetMapping("")
    public UserResponseDto getUser(@AuthenticationPrincipal UserDetails userDetails) {
        log.info("Email: {}", userDetails.getUsername());
        UserResponseDto userResponseDto = userService.getUser(userDetails.getUsername());

        return userResponseDto;
    }

    // 3. 사용자를 수정하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용를여 사용자의 이름, 주소를 출력해줍니다. return 값은 "사용자 수정"입니다.
    //UpdateUserRequestDto 클래스를 매개변수로 받습니다.
    @PutMapping()
    public String updateUser(@AuthenticationPrincipal String email ,UpdateUserRequestDto updateUserRequestDto) {
        log.info("이름: {}", updateUserRequestDto.getName());
        log.info("주소: {}", updateUserRequestDto.getAddress());

        userService.updateUser(updateUserRequestDto);

        return "사용자 수정";
    }

    // 4. 사용자를 삭제하는 컨트롤러를 만듭니다.
    // 이때 log.info 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 삭제"입니다.
    @DeleteMapping("")
    public String deleteUser(@AuthenticationPrincipal String email) {
        log.info("Email: {}", email);
        userService.deleteUser(email);

        return "사용자 삭제";
    }

}
