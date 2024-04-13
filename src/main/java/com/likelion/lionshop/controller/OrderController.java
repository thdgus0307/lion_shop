package com.likelion.lionshop.controller;

import com.likelion.lionshop.dto.request.CreateOrderRequestDto;
import com.likelion.lionshop.dto.request.UpdateOrderRequestDto;
import com.likelion.lionshop.dto.response.OrderResponseDto;
import com.likelion.lionshop.entity.Order;
import com.likelion.lionshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.*;

@Slf4j //로그 출력을 도와주는 어노테이션
@RestController
@RequestMapping("/order") // uri가 /oroder로 시작하는 요청을 받습니다.
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // 1. 주문을 생성하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 생성하기"입니다. -> 주문은 리스트 형태로 요청을 보내주세요!
    //CreateOrderRequestDto 클래스를 매개변수로 받습니다.
    @PostMapping()
    public String createOrder(@RequestBody CreateOrderRequestDto createOrderRequestDto) {
        orderService.createOrder(createOrderRequestDto);
        return "주문 생성하기";
    }


    // 2. 주문을 가져오는 컨트롤러를 만듭니다. 이때 return 값은 "주문 가져오기"입니다.
    @GetMapping("/{id}")
    public OrderResponseDto getOrder(@PathVariable int id) {
        OrderResponseDto orderResponseDto = orderService.getOrder(id);
        return orderResponseDto;
    }

    // 3. 주문을 수정하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 수정하기"입니다.
    //UpdateOrderRequestDto 클래스를 매개변수로 받습니다.
    @PutMapping()
    public String updateOrder(@RequestBody UpdateOrderRequestDto updateOrderRequestDto) {
        orderService.updateOrder(updateOrderRequestDto);
        return "주문 수정하기";
    }

    // 4. 주문을 삭제하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 삭제하기"입니다.
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable int id) {
        log.info("ID: {}", id);
        orderService.deleteOrder(id);

        return "주문 삭제하기";
    }

}
