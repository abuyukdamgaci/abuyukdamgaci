package com.codewithmosh.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${payment-gateway:stripe}")
    private String serviceType;

    @Bean
    public PaymentService stripe(){
        return new StripePaymentService();
    }
    @Bean
    public PaymentService paypal(){
        return new PaypalPaymentService();
    }
    @Bean
    public OrderService orderService(){
        if (serviceType.equals("stripe"))
            return new OrderService(stripe());
                else
                    return new OrderService(paypal());
    }

}
