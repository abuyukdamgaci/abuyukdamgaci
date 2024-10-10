package com.abuyukdamgaci.brokage.service;


import com.abuyukdamgaci.brokage.model.Asset;
import com.abuyukdamgaci.brokage.model.Order;

import java.util.List;

public interface AssetService {

    String depositMoney(String customer, String amount);
    String withdrawMoney(String customer, String amount);
    List<Asset> getAllAssets();
}
