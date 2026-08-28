package com.codewithmosh.store;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
//@Service
public class OrderService {
    private PaymentService paymentService;

    public OrderService(){

    }

    public OrderService(PaymentService paymentService){
    this.paymentService = paymentService;
        System.out.println("OrderService Bean Created");
    }

    @PostConstruct
    public void init(){
        System.out.println("Order Service Post Construct");
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("Order Service Pre Destroy");
    }



    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(){
        paymentService.pay(10);
    }
}
