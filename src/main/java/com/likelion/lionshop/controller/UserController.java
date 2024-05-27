package com.likelion.lionshop.controller;

import com.likelion.lionshop.dto.request.CreateUserRequestDto;
import com.likelion.lionshop.dto.request.UpdateUserRequestDto;
import com.likelion.lionshop.dto.response.UserResponseDto;
import com.likelion.lionshop.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Slf4j //로그 출력을 도와주는 어노테이션
@RestController
@RequestMapping("/user") // uri가 /user로 시작하는 요청을 받습니다.
@RequiredArgsConstructor
@Tag(name = "사용자 API", description = "사용자 관련 API입니다.")
public class UserController {

    private final UserService userService;

    // 1. 사용자를 생성하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 이름, 주소, ID, PW를 출력해줍니다. return 값은 "사용자 생성"입니다.
    @Operation(method = "POST", summary = "사용자 생성", description = "사용자를 생성합니다. 클라이언트가 사용자 생성 정보를 포함한 HTTP POST 요청을 보내면, 데이터가 CreateUserRequestDto 객체로 변환되어 로그에 출력된 후 userService의 createUser 메서드로 전달되어 새로운 사용자가 생성됩니다.")
    @PostMapping("create")
    public String createUser(@Valid @RequestBody CreateUserRequestDto createUserRequestDto) {
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
    @Operation(method = "GET", summary = "사용자 조회", description = "사용자를 조회합니다. userService의 getUser 메서드를 호출하여 사용자 정보를 조회하고, 조회된 정보를 UserResponseDto 객체로 반환합니다.")
    @GetMapping("")
    public UserResponseDto getUser(@AuthenticationPrincipal UserDetails userDetails) {
        log.info("Email: {}", userDetails.getUsername());
        UserResponseDto userResponseDto = userService.getUser(userDetails.getUsername());

        return userResponseDto;
    }

    // 3. 사용자를 수정하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용를여 사용자의 이름, 주소를 출력해줍니다. return 값은 "사용자 수정"입니다.
    //UpdateUserRequestDto 클래스를 매개변수로 받습니다.
    @Operation(method = "PUT", summary = "사용자 수정", description = "사용자를 수정합니다. 요청 본문의 사용자 수정 정보가 이메일과 함께 UpdateUserRequestDto 객체로 전달되어, 해당 정보를 기반으로 사용자를 업데이트하고 로그에 출력한다.")
    @PutMapping()
    public String updateUser(@AuthenticationPrincipal String email ,UpdateUserRequestDto updateUserRequestDto) {
        log.info("이름: {}", updateUserRequestDto.getName());
        log.info("주소: {}", updateUserRequestDto.getAddress());

        userService.updateUser(updateUserRequestDto);

        return "사용자 수정";
    }

    // 4. 사용자를 삭제하는 컨트롤러를 만듭니다.
    // 이때 log.info 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 삭제"입니다.
    @Operation(method = "DELETE", summary = "사용자 삭제", description = "사용자를 삭제합니다. 이메일을 기반으로, 해당 사용자의 정보가 삭제됩니다.")
    @DeleteMapping("")
    public String deleteUser(@AuthenticationPrincipal String email) {
        log.info("Email: {}", email);
        userService.deleteUser(email);

        return "사용자 삭제";
    }

}
