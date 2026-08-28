package com.codewithmosh.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("stripe")
public class StripePaymentService  implements  PaymentService{
    @Value("${stripe.apiUrl}")
    private String apiUrl;

    @Value("${stripe.enabled}")
    private boolean enabled;

    @Value("${stripe.timeout}")
    private int timeout;

    @Value("${stripe.supported-currencies}")
    private List<String> supportedCurrencies;

    public void pay(double amount){
        System.out.println("STRIPE");
        System.out.println("Api Url : " + apiUrl);
        System.out.println("Enabled : " + enabled);
        System.out.println("Timeout : " + timeout);
        System.out.println("Supported currencies : " + supportedCurrencies);
        System.out.println("Amount : " + amount);
    }
}
