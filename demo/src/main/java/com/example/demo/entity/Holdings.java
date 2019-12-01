package com.example.demo.entity;

public class Holdings  {
	private String stockName;
	private double avgBuys;
    private double totalStocks;
    
    public Holdings(String stockName, double avgBuys, double totalStocks) {
    	this.stockName = stockName;
    	this.avgBuys = avgBuys;
    	this.totalStocks = totalStocks;
    }
    public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public double getAvgBuys() {
		return avgBuys;
	}
	public void setAvgBuys(double avgBuys) {
		this.avgBuys = avgBuys;
	}
	public double getTotalStocks() {
		return totalStocks;
	}
	public void setTotalStocks(double totalStocks) {
		this.totalStocks = totalStocks;
	}
	
   
}