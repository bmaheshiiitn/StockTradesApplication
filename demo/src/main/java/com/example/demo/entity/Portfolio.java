package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;




public class Portfolio  {
   
    private int id;
    private String stockName;
    private List<Trade> tradesList;
    
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public List<Trade> getTradesList() {
		return tradesList;
	}

	public void setTradesList(List<Trade> tradesList) {
		this.tradesList = tradesList;
	}

    
    
}