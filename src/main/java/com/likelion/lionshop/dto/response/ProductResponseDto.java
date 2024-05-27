package com.likelion.lionshop.dto.response;

import com.likelion.lionshop.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto {

    private String productName;

    private int productPrice;

    public static ProductResponseDto from(Product product){
        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .build();
    }

}
