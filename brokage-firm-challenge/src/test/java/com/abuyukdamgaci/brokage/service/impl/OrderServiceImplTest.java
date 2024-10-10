package com.abuyukdamgaci.brokage.service.impl;

import com.abuyukdamgaci.brokage.model.Order;
import com.abuyukdamgaci.brokage.repository.OrderRepository;
import com.abuyukdamgaci.brokage.service.OrderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class OrderServiceImplTest {

    @Mock
    private OrderRepository repository;
    private OrderService orderService;
    AutoCloseable autoCloseable;
    Order order;
    List<Order> orderList;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        orderService = new OrderServiceImpl(repository);
        order = new Order(null,"123","ASSET123","BUY","3","2","PENDING", new Date());
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testDeleteOrder() throws Exception {
        mock(Order.class);
        mock(OrderRepository.class, Mockito.CALLS_REAL_METHODS);

       doAnswer(Answers.CALLS_REAL_METHODS).when(repository).deleteById(any());
       assertThat(orderService.deleteOrder("1")).isEqualTo("Done");
    }

    @Test
    void testCreateAllOrder() throws Exception {
        mock(Order.class);
        mock(OrderRepository.class);

        List<Order> orderList1 = new ArrayList<>();
        orderList1.add(order);

        when(repository.save(order)).thenReturn(order);
        assertThat(orderService.createAllOrder(orderList1)).isEqualTo("Done");
    }

    @Test
    void testListOrders() throws ParseException {
        mock(Order.class);
        mock(OrderRepository.class);

        repository.save(order);

        when(repository.findAll()).thenReturn(orderList);
        assertThat(orderService.listOrders(null,null).size()).isGreaterThan(0);
    }
}