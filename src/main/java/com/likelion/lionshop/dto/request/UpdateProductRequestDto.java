package com.likelion.lionshop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateProductRequestDto {

    public Long productId;      //상품번호

    public String productName;  //상품명

    public int productPrice;    //가격
}
