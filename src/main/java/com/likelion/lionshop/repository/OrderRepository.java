package com.likelion.lionshop.repository;

import com.likelion.lionshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    void deleteById(Long id);

    Optional<Order> findByEmail(String email);
}