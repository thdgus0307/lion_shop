package com.likelion.lionshop.dto.response;


import com.likelion.lionshop.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {

    private Long orderId;

    private String name;

    private int price;

    private int quantity;

    public static OrderResponseDto from(Order order){
        return OrderResponseDto.builder()
                .orderId(order.getId())
                .name(order.getName())
                .quantity(order.getQuantity())
                .price(order.getPrice())
                .build();
    }

}
