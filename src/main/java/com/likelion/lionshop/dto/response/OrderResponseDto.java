package com.likelion.lionshop.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

    private int orderId;

    private String name;

    private int price;

    private int quantity;

}
