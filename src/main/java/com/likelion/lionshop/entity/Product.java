package com.likelion.lionshop.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;     // 상품번호

    private String  productName;    // 상품명

    private  int productPrice;     //가격

    @Builder // entity 만들기 위함
    public Product(Long productId, String productName, int productPrice){
        this.productId = productId; // 내가 entity에 가지고 있는 productId 값을 매개변수 productId로 저장
        this.productName = productName;
        this.productPrice = productPrice;
    }


    public void update(String productName, int productPrice) {
        this.productName = productName; //// 내가 entity에 가지고 있는 productName 값을 매개변수 productName로 저장
        this.productPrice = productPrice;
    }
}
