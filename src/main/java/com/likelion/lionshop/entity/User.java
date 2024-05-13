package com.likelion.lionshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id // 기본값
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성
    private Long id;          // 사용자 id

    private String name;        // 이름

    private String address;     // 주소

    private String password;    // 비밀번호

    private String tel;        // 전화번호

    private String email;       // 이메일

    private String roles;


    @Builder
    public User(String name, String address, String password, String email, String roles) {
        this.name = name;
        this.address = address;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public void update(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> order;

}
