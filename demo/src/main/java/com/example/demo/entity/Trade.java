package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbltrade")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;
    @NotNull
    @Column(name = "by_sell_indicator")
	private String bySale;
    @NotNull
    @Column(name = "price")
    private double price;
    @NotNull
    @Column(name = "currentdate")
    private Date date;
    @NotNull
    @Column(name = "stock_name")
    private String stockName;
    @NotNull
    @Column(name = "no_of_stocks")
    private double noOfStocks;
    
    public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Trade() {  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getBySale() {
		return bySale;
	}

	public void setBySale(String bySale) {
		this.bySale = bySale;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public double getNoOfStocks() {
		return noOfStocks;
	}

	public void setNoOfStocks(double noOfStocks) {
		this.noOfStocks = noOfStocks;
	}

} 