package com.codewithmosh.store;

import org.springframework.stereotype.Service;

public interface PaymentService {
    void pay(double amount);
}
