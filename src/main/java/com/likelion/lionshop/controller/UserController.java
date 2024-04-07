package com.likelion.lionshop.controller;

import com.likelion.lionshop.dto.CreateUserRequestDto;
import com.likelion.lionshop.dto.UpdateUserRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j //로그 출력을 도와주는 어노테이션
@RestController
@RequestMapping("/user") // uri가 /user로 시작하는 요청을 받습니다.
public class UserController {

    // 1. 사용자를 생성하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 이름, 주소, ID, PW를 출력해줍니다. return 값은 "사용자 생성"입니다.
    @PostMapping
    public String createUser(CreateUserRequestDto createUserRequestDto) {
        log.info("이름: {}", createUserRequestDto.name);
        log.info("주소: {}", createUserRequestDto.address);
        log.info("ID: {}", createUserRequestDto.id);
        log.info("PW: {}", createUserRequestDto.password);

        return "사용자 생성";
    }

    //CreateUserRequestDto 클래스를 매개변수로 받습니다.
    // 2. 사용자를 조회하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 조회"입니다.
    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {
        log.info("ID: {}", id);

        return "사용자 조회";
    }

    // 3. 사용자를 수정하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용를여 사용자의 이름, 주소를 출력해줍니다. return 값은 "사용자 수정"입니다.
    //UpdateUserRequestDto 클래스를 매개변수로 받습니다.
    @PutMapping()
    public String updateUser(UpdateUserRequestDto updateUserRequestDto) {
        log.info("이름: {}", updateUserRequestDto.name);
        log.info("주소: {}", updateUserRequestDto.address);

        return "사용자 수정";
    }

    // 4. 사용자를 삭제하는 컨트롤러를 만듭니다.
    // 이때 log.info 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 삭제"입니다.
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        log.info("ID: {}", id);

        return "사용자 삭제";
    }

}
