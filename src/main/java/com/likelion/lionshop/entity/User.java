package com.likelion.lionshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id // 기본값
    private String id;          // 사용자 id

    private String name;        // 이름

    private String address;     // 주소

    private String password;    // 비밀번호

    private String tel;        // 전화번호

    private String email;       // 이메일

    @Builder
    public User(String id, String name, String address, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.password = password;
    }

    public void update(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> order;
}
