package com.abuyukdamgaci.brokage.repository;

import com.abuyukdamgaci.brokage.model.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository repository;
    Order order;
    @BeforeEach
    void setUp() throws ParseException {
        order = new Order(null,"123","ASSET123","BUY","3","2","PENDING", new Date());
        repository.save(order);
    }
    @AfterEach
    void tearDown(){
        order = null;
        repository.deleteAll();
    }

    @Test
    void testFindOrder_Found(){
        List<Order> orderList = repository.findOrderByCustomer("123");
        assertThat(orderList.get(0).getAsset()).isEqualTo(order.getAsset());
    }

    @Test
    void testFindOrder_NotFound(){
        List<Order> orderList = repository.findOrderByCustomer("888");
        assertThat(orderList.isEmpty()).isTrue();
    }
}
