package com.abuyukdamgaci.brokage.service.impl;

import com.abuyukdamgaci.brokage.model.Order;
import com.abuyukdamgaci.brokage.repository.OrderRepository;
import com.abuyukdamgaci.brokage.service.OrderService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class OrderServiceImpl implements OrderService {

    OrderRepository repository;
    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }
    @Override
    public String createOrder(Order order) {
        repository.save(order);
        return "Done";
    }

    @Override
    public String updateOrder(Order order) {
        repository.save(order);
        return "Done";
    }

    @Override
    public String deleteOrder(String id) throws Exception {
        if(repository.findById(id).get().getStatus().equals("CANCELED")) {
            repository.deleteById(id);
            return "Done";
        }else{
            throw new Exception("Check status of order, it has to be CANCELED.");
        }
    }

    @Override
    public Order getOrder(String id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Order> getAllOrder() {
        return repository.findAll();
    }

    @Override
    public String createAllOrder(List<Order> orderList) throws Exception {
        if(!orderList.stream().allMatch(n->n.getStatus().toUpperCase().matches("PENDING|MATCHED|CANCELED"))){
            throw new Exception("Check status of order, it has to be PENDING,MATCHED,CANCELED");
        }
        if(!orderList.stream().allMatch(n->n.getSide().toUpperCase().matches("BUY|SELL"))){
            throw new Exception("Check side of order, it has to be BUY,SELL");
        }
        repository.saveAll(orderList);
        return "Done";
    }

    @Override
    public List<Order> listOrders(String customer, String range) throws ParseException {
        if(customer==null){
        return repository.findAll();
        }else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            Date rangeDate = formatter.parse(range);
            return repository.findAll().stream().filter(n -> n.getCustomer().equals(customer) && n.getCreateDate().after(rangeDate)).toList();
        }
    }
}
