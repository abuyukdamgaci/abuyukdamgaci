package com.abuyukdamgaci.brokage.controller;

import com.abuyukdamgaci.brokage.model.Asset;
import com.abuyukdamgaci.brokage.service.AssetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asset")
public class AssetController {
    AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PutMapping
    public String depositMoney(@RequestParam List<String> parameterList) throws Exception {
        if(parameterList!=null&&parameterList.size()>1) {
            assetService.depositMoney(parameterList.get(0), parameterList.get(1));
            return "depositMoney applied.";
        }else{
            throw new Exception("Check parameterList, it has to contain customer and amount parameters.");
        }
    }

    @PutMapping(path="/withdrawMoney")
    public String withdrawMoney(@RequestParam List<String> parameterList) throws Exception {
        if(parameterList!=null&&parameterList.size()>1) {
            assetService.withdrawMoney(parameterList.get(0), parameterList.get(1));
            return "withdrawMoney applied.";
        }else{
            throw new Exception("Check parameterList, it has to contain customer and amount parameters.");
        }
    }

    @GetMapping
    public List<Asset> getAllOrder(){
        return assetService.getAllAssets();
    }
}
