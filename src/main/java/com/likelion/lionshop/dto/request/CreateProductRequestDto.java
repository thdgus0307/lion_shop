package com.likelion.lionshop.dto.request;

import com.likelion.lionshop.entity.Product;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateProductRequestDto {

    @Size(min = 1, max = 20, message = "상품명은 1~20 글자여야 합니다.")
    public String productName;      // 상품명

    @NotNull(message = "가격은 필수값입니다.")
    public int productPrice;        // 가격

    public Product toEntity(){
        return Product.builder()
                .productName(productName)
                .productPrice(productPrice)
                .build();
    }
}
