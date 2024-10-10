package com.abuyukdamgaci.brokage.controller;

import com.abuyukdamgaci.brokage.model.Order;
import com.abuyukdamgaci.brokage.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("{id}")
    public Order getOrder(@PathVariable("id") String id){
        return orderService.getOrder(id);
        //return new Order("1","11","asset","BUY","1","1","PENDING");
    }

//    @GetMapping
//    public List<Order> getAllOrder(){
//        return orderService.getAllOrder();
//    }

//    @PostMapping
//    public String createOrder(@RequestBody Order order){
//        orderService.createOrder(order);
//
//        //DB insert
//        //customer, asset, side, size and price
//        /*Side can be BUY or SELL. Customer is a unique id for a customer.
//        Asset is the name of the stock customer wants to buy.
//        Size represents how many shares customer wants to buy.
//        Price represents how much customer wants to pay for per share.*/
//        return "Order created.";
//    }

    @PutMapping
    public String updateOrder(@RequestBody Order order){
        orderService.updateOrder(order);
        return "Order updated.";
    }

    @DeleteMapping("{id}")
    public String deleteOrder(@PathVariable("id") String id) throws Exception {
        orderService.deleteOrder(id);
        return "Order deleted.";
    }

    @PostMapping
    public String createAllOrder(@RequestBody List<Order> orderList) throws Exception {
        orderService.createAllOrder(orderList);
        return "Order list created.";
    }

    @GetMapping()
    public List<Order> listOrders(@RequestParam List<String> parameterList) throws Exception {
        if(parameterList!=null&&parameterList.size()>1) {
            return orderService.listOrders(parameterList.get(0), parameterList.get(1));
        }else{
            throw new Exception("Check parameterList, it has to contain customer and range parameters.");
        }
    }
}
