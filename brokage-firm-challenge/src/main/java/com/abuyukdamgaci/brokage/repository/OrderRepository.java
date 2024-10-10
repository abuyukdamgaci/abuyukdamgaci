package com.abuyukdamgaci.brokage.repository;

import com.abuyukdamgaci.brokage.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String> {
    List<Order> findOrderByCustomer(String customer);
}
