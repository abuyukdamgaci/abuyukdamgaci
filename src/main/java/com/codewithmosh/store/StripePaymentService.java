package com.codewithmosh.store;

import org.springframework.stereotype.Service;


public class StripePaymentService  {

    public void pay(double amount){
        System.out.println("STRIPE");
        System.out.println("Amount : " + amount);
    }
}
