package com.codewithmosh.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {

//        ApplicationContext applicationContext = SpringApplication.run(StoreApplication.class, args);
        ConfigurableApplicationContext applicationContext = SpringApplication.run(StoreApplication.class, args);
        var orderService = applicationContext.getBean(OrderService.class);

        var heavyResource = applicationContext.getBean(HeavyResource.class);

        //var orderService = new OrderService();
        //orderService.setPaymentService(new StripePaymentService());
        orderService.placeOrder();

        /*var orderServicePaypal = new OrderService();
        orderServicePaypal.setPaymentService(new PaypalPaymentService());
        orderServicePaypal.placeOrder();*/

        var notificationManager = applicationContext.getBean(NotificationManager.class);
        notificationManager.sendNotification("NOTIFIED");

//        applicationContext.close();//PreDestroy islemlerini bundan once yapiliyor mesela DB connection kapama
    }

}
