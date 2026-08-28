package com.codewithmosh.store;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Service("paypal")
//@Primary
public class PaypalPaymentService implements PaymentService{

    @Override
    public void pay(double amount) {
        System.out.println("PAYPAL");
        System.out.println("Amount : " + 5*amount);
    }
}
