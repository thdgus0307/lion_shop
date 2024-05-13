package com.likelion.lionshop.service;

import com.likelion.lionshop.dto.request.CreateOrderRequestDto;
import com.likelion.lionshop.dto.request.UpdateOrderRequestDto;
import com.likelion.lionshop.dto.response.OrderResponseDto;
import com.likelion.lionshop.entity.Order;
import com.likelion.lionshop.entity.User;
import com.likelion.lionshop.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public void createOrder(List<CreateOrderRequestDto> createOrderRequestDto) {
       createOrderRequestDto.forEach(orderRequestDto -> {
           log.info("[ Order Service ] 주문 생성 이름 --->{}", orderRequestDto.getName());

           Order order = orderRequestDto.toEntity();
           orderRepository.save(order);
       });
        // repository를 사용하여 db에 저장

    }

    public OrderResponseDto getOrder(String email) {
        // repository 사용 전 임의의 OrderResponseDto 객체 생성하여 반환
        OrderResponseDto dto = new OrderResponseDto(1L, "사자인형", 10000, 3);
        return dto;
    }

    public void updateOrder(UpdateOrderRequestDto updateOrderRequestDto) {
        //repository를 사용하여 조회해서 Order Entiity 받아오기
        Optional<Order> optionalOrder = orderRepository.findById(updateOrderRequestDto.getId());

        optionalOrder.ifPresent(order -> {
            order.update(updateOrderRequestDto.getName(), updateOrderRequestDto.getQuantity(), updateOrderRequestDto.getPrice());
            orderRepository.save(order);

       });
        Order order = orderRepository.findById(updateOrderRequestDto.getId()).orElseThrow(
                ()-> new IllegalArgumentException("상품이 존재하지 않습니다."));



    }

    public void deleteOrder(String email) {
        // repository를 사용하여 삭제
        Order order = orderRepository.findByEmail(email).orElseThrow();

        orderRepository.deleteById(order.getId());
    }


}
