package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Trade;

import java.util.List;

@Repository
public interface TradeRepository extends CrudRepository<Trade, Integer> {
	 List<Trade> findAll();
	 Trade findById(int tradeId);
	 List<Trade> findByStockName(String stockName);
	 
	 
	 @Query(value = "SELECT * FROM tbltrade order by stock_name", nativeQuery = true)
	  public List<Trade> findAllTradeGropByStockName();
	 
	 @Query(value = "SELECT DISTINCT a.stock_name FROM tbltrade a", nativeQuery = true )
	  List<String> findDistinctStockName();
	 
	 
}