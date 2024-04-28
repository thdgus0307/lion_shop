package com.likelion.lionshop.service;

import com.likelion.lionshop.dto.request.CreateOrderRequestDto;
import com.likelion.lionshop.dto.request.UpdateOrderRequestDto;
import com.likelion.lionshop.dto.response.OrderResponseDto;
import com.likelion.lionshop.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderService {

    public void createOrder(List<CreateOrderRequestDto> createOrderRequestDto) {
       createOrderRequestDto.forEach(orderRequestDto -> {
           log.info("[ Oder Service ] 주문 생성 이름 --->{}", orderRequestDto.getName());

           Order order = orderRequestDto.toEntity();
       });
        // repository를 사용하여 db에 저장
    }

    public OrderResponseDto getOrder(int id) {
        // repository 사용 전 임의의 OrderResponseDto 객체 생성하여 반환
        OrderResponseDto dto = new OrderResponseDto(id, "사자인형", 10000, 3);
        return dto;
    }

    public void updateOrder(UpdateOrderRequestDto updateOrderRequestDto) {
        // repository를 사용하여 조회해서 Order Entiity 받아오기
        Order order = null;
        order.update(updateOrderRequestDto.getName(), updateOrderRequestDto.getQuantity(), updateOrderRequestDto.getPrice());
    }

    public void deleteOrder(int id) {
        // repository를 사용하여 삭제
    }


}
