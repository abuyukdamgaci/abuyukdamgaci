package com.abuyukdamgaci.brokage.model;

import jakarta.persistence.*;

@Entity
@Table(name="asset")
public class Asset {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  String id;
    private String customer;
    private String assetName;
    private String size;
    private String usableSize;

    public Asset() {
    }

    public Asset(String id, String customer, String assetName, String size, String usableSize) {
        this.id = id;
        this.customer = customer;
        this.assetName = assetName;
        this.size = size;
        this.usableSize = usableSize;
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

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUsableSize() {
        return usableSize;
    }

    public void setUsableSize(String usableSize) {
        this.usableSize = usableSize;
    }
}
