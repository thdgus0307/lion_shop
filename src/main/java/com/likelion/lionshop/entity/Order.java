package com.likelion.lionshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id // 기본값
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성
    private Long Id;    // 주문번호

    private String email;      // 주문자 id

    private String name; // 제품명

    private int quantity;   // 수량

    private int price;      // 가격

    @Builder
    public Order(String email, String name, int quantity, int price) {
        this.email = email;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void update(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
