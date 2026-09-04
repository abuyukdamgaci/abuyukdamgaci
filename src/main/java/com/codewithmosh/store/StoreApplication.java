package com.codewithmosh.store;

import com.codewithmosh.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(StoreApplication.class, args);
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(StoreApplication.class, args);
//        var orderService = applicationContext.getBean(OrderService.class);

//        var heavyResource = applicationContext.getBean(HeavyResource.class);

        //var orderService = new OrderService();
        //orderService.setPaymentService(new StripePaymentService());
//        orderService.placeOrder();

        /*var orderServicePaypal = new OrderService();
        orderServicePaypal.setPaymentService(new PaypalPaymentService());
        orderServicePaypal.placeOrder();*/

//        var notificationManager = applicationContext.getBean(NotificationManager.class);
//        notificationManager.sendNotification("NOTIFIED");

//        applicationContext.close();//PreDestroy islemlerini bundan once yapiliyor mesela DB connection kapama

        //ENTITY
//        var user = new User(1L,"john","email","password");
//        user.setName("John");
//        user.setEmail("john@email.com");
//        user.setPassword("password");
        //BUILDER
//        var user = User.builder().name("John")
//                .email("john@email.com")
//                .password("password")
//                .build();
//
//        var address = Address.builder().city("city")
//                .state("state")
//                .street("street")
//                .build();

//        user.getAddresses().add(address);
//        address.setUser(user);

//        user.addAddress(address);

//        user.addTag("tag1");

//        var profile = Profile.builder().bio("bio").build();
//        user.setProfile(profile);
//        profile.setUser(user);
//        System.out.println(user);
//
//        var category = Category.builder().name("category").build();
//        category.addProduct("productName", BigDecimal.valueOf(4354));
//        System.out.println(category);

        //REPOSITORY
//        var userRepository = applicationContext.getBean(UserRepository.class);
//        var user = User.builder().name("abu").email("abu@gmail.com").password("pass").build();
//        userRepository.save(user);

        //get
//        userRepository.findById(1L).get();
//        userRepository.findById(1L).orElse(null);//yoksa null döner
//        userRepository.findById(1L);//yoksa birsey yapmaz
//        var user = userRepository.findById(1L).orElseThrow();//yoksa exception atar
//        System.out.println(user.getEmail());

//        userRepository.findAll().forEach(user -> System.out.println(user.getEmail()));

        //delete
//        userRepository.deleteById(1L);

        var userService = applicationContext.getBean(UserService.class);
//        userService.showEntityStates();

//        userService.showRelatedEntities();;

//        userService.showRelatedEntitiesForAddres();

//        userService.persistRelated();

//        userService.deleteRelated();

//        userService.deleteRelatedChild();

//        userService.createProductService();
//        userService.addNewProdcutCategory();
//        userService.addProductsToWishListUser();
//        userService.deleteProduct();

//        userService.updateProductPrice();
//        userService.fetchProducts();

//        userService.fetchUser();
//        userService.fetchUsers();

//        userService.fetchUsersAddess();

//        userService.findProductsByPrice();

//        userService.fetchProfiles();

//        userService.fetchProductsJpa();

//        userService.fetchProductByCriteria();

//        userService.fetchProductsBySpecificaitons("new", BigDecimal.valueOf(3),null);
//        userService.fetchSortedProducts();
        userService.fetchPaginatedProducts(0,10);
    }

}
