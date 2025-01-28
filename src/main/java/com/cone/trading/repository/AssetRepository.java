package com.cone.trading.repository;

import com.cone.trading.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepository  extends JpaRepository<Asset,Long> {

    List<Asset> findByUserId(Long userId );

    Asset findByUserIdAndCoinId(Long userId , Long coinId );



}
