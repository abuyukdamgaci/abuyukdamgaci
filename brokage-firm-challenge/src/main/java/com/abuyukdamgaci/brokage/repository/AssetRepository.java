package com.abuyukdamgaci.brokage.repository;

import com.abuyukdamgaci.brokage.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset,String> {
}
