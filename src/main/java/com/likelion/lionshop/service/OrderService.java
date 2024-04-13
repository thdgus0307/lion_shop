package com.likelion.lionshop.service;

import com.likelion.lionshop.dto.request.CreateOrderRequestDto;
import com.likelion.lionshop.dto.request.UpdateOrderRequestDto;
import com.likelion.lionshop.dto.response.OrderResponseDto;
import com.likelion.lionshop.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public void createOrder(CreateOrderRequestDto createOrderRequestDto) {
        Order order = Order.builder()
                .id("lionking")
                .name(createOrderRequestDto.name)
                .price(createOrderRequestDto.price)
                .quantity(createOrderRequestDto.quantity)
                .build();

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
        order.update(updateOrderRequestDto.name, updateOrderRequestDto.quantity, updateOrderRequestDto.price);
    }

    public void deleteOrder(int id) {
        // repository를 사용하여 삭제
    }


}
