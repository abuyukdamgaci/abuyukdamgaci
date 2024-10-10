package com.abuyukdamgaci.brokage.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="customer_order")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  String id;
    private String customer;
    private String asset;
    private String side;
    private String size;
    private String price;
    private String status;

    private Date createDate;

    public Order() {
    }

    public Order(String id, String customer, String asset, String side, String size, String price, String status, Date createDate) {
        this.id = id;
        this.customer = customer;
        this.asset = asset;
        this.side = side;
        this.size = size;
        this.price = price;
        this.status = status;
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
