package com.likelion.lionshop.controller;

import com.likelion.lionshop.dto.request.CreateOrderRequestDto;
import com.likelion.lionshop.dto.request.UpdateOrderRequestDto;
import com.likelion.lionshop.dto.response.OrderResponseDto;
import com.likelion.lionshop.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //로그 출력을 도와주는 어노테이션
@RestController
@RequestMapping("/order") // uri가 /oroder로 시작하는 요청을 받습니다.
@RequiredArgsConstructor
@Tag(name = "주문 API", description = "주문 관련 API입니다.")
public class OrderController {

    private final OrderService orderService;

    // 1. 주문을 생성하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 생성하기"입니다. -> 주문은 리스트 형태로 요청을 보내주세요!
    //CreateOrderRequestDto 클래스를 매개변수로 받습니다.
    @Operation(method = "POST", summary = "주문 생성", description = "주문을 생성합니다. 생서할 주문 List를 Body에 담아서 전송합니다.")
    @PostMapping()
    public String createOrder(@AuthenticationPrincipal String email, @RequestBody List<CreateOrderRequestDto> orderRequestDto) {
        orderService.createOrder(orderRequestDto);
        return "주문 생성하기";
    }


    // 2. 주문을 가져오는 컨트롤러를 만듭니다. 이때 return 값은 "주문 가져오기"입니다.
    @Operation(method = "GET", summary = "주문 조회", description = "주문을 가져옵니다. 주입된 email과 연결된 주문정보를 orderService를 통해 가져온 후 orderResponseDto에 저장합니다.")
    @GetMapping("/{id}")
    public OrderResponseDto getOrder(@AuthenticationPrincipal String  email) {
        OrderResponseDto orderResponseDto = orderService.getOrder(email);
        return orderResponseDto;
    }

    // 3. 주문을 수정하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 수정하기"입니다.
    //UpdateOrderRequestDto 클래스를 매개변수로 받습니다.
    @Operation(method = "PUT", summary = "주문 수정", description = "주문을 수정합니다. 요청 본문에 포함된 주문 수정 정보는 UpdateOrderRequestDto 객체로 변환되어 orderService의 updateOrder 메서드로 전달되고, 이에 따라 주문이 업데이트됩니다.")
    @PutMapping()
    public String updateOrder(@AuthenticationPrincipal UserDetails userDetails, @RequestBody UpdateOrderRequestDto updateOrderRequestDto) {
        orderService.updateOrder(updateOrderRequestDto);
        return "주문 수정하기";
    }

    // 4. 주문을 삭제하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 삭제하기"입니다.
    @Operation(method = "DELETE", summary = "주문 삭제", description = "주문을 삭제합니다. 사용자의 이메일을 인증 정보에서 가져와 해당 이메일과 관련된 주문을 삭제합니다.")
    @DeleteMapping("/{id}")
    public String deleteOrder(@AuthenticationPrincipal String email) {
        log.info("Email: {}", email);
        orderService.deleteOrder(email);

        return "주문 삭제하기";
    }

}
