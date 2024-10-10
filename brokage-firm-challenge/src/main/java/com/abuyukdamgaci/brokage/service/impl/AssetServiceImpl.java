package com.abuyukdamgaci.brokage.service.impl;

import com.abuyukdamgaci.brokage.model.Asset;
import com.abuyukdamgaci.brokage.model.Order;
import com.abuyukdamgaci.brokage.repository.AssetRepository;
import com.abuyukdamgaci.brokage.service.AssetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    AssetRepository repository;

    public AssetServiceImpl(AssetRepository repository) {
        this.repository = repository;
    }

    @Override
    public String depositMoney(String customer, String amount) {
        List<Asset> assetList = repository.findAll().stream().filter(n -> n.getCustomer().equals(customer)&&n.getAssetName().equalsIgnoreCase("TRY")).toList();
        if(assetList!=null && assetList.size()>0) {
            Asset asset = assetList.get(0);
            asset.setSize(String.valueOf(Integer.valueOf(asset.getSize())+Integer.valueOf(amount)));
            repository.save(asset);
        }
        return "Deposit Money Applied.";
    }

    @Override
    public String withdrawMoney(String customer, String amount) {
        List<Asset> assetList = repository.findAll().stream().filter(n -> n.getCustomer().equals(customer)&&n.getAssetName().equalsIgnoreCase("TRY")).toList();
        if(assetList!=null && assetList.size()>0) {
            Asset asset = assetList.get(0);
            asset.setSize(String.valueOf(Integer.valueOf(asset.getSize())-Integer.valueOf(amount)));
            repository.save(asset);
        }
        return "Withdraw Money Applied.";
    }

    @Override
    public List<Asset> getAllAssets() {
        return repository.findAll();
    }
}
