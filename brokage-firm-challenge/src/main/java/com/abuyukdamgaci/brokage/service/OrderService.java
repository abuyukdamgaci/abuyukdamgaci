package com.abuyukdamgaci.brokage.service;

import com.abuyukdamgaci.brokage.model.Order;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

public interface OrderService {
    String createOrder(Order order);
    String updateOrder(Order order);
    String deleteOrder(String id) throws Exception;
    Order getOrder(String id);
    List<Order> getAllOrder();

    String createAllOrder(List<Order> orderList) throws Exception;

    List<Order> listOrders(String customer, String range) throws ParseException;
}
