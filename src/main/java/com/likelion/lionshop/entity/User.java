package com.likelion.lionshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
}
