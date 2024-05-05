package com.likelion.lionshop.repository;

import com.likelion.lionshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface OrderRepository extends JpaRepository<Order, Long> {

    void deleteById(int id);
}