package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Holdings;
import com.example.demo.entity.HttpRestfulResponse;
import com.example.demo.entity.Trade;
import com.example.demo.repository.TradeRepository;
import com.example.demo.service.TradeService;

@RequestMapping("/portfolio")
@Controller
public class TradeController {
	@Autowired
	private TradeService tradeService;
	@Autowired
	private TradeRepository tradeRepo;

	@RequestMapping("/")
	public @ResponseBody HttpRestfulResponse getAllTrades() {
		HttpRestfulResponse response = new HttpRestfulResponse();
		List<Trade> trades = tradeService.tradeByOrder();
		if (trades != null && trades.size() > 0) {
			response.setData(tradeService.tradeByOrder());
			response.setStatus(true);
		} else {
			response.setData(trades);
			response.setStatus(false);
		}
		return response;
	}

	@RequestMapping("/returns")
	public @ResponseBody HttpRestfulResponse getReturns() {
		HttpRestfulResponse response = new HttpRestfulResponse();
		List<Trade> trades = tradeService.tradeByOrder();
		double sum = 0;
		if (trades != null && trades.size() > 0) {
			for (Trade t : trades) {
				if (t.getBySale().equalsIgnoreCase("SELL")) {
					sum = sum + (t.getPrice() * t.getNoOfStocks());
				} else if (t.getBySale().equalsIgnoreCase("BUY")) {
					sum = sum + (-(t.getPrice() * t.getNoOfStocks()));
				}
			}
			response.setData(sum);
			response.setStatus(true);
		} else {
			response.setData(trades);
			response.setStatus(false);
		}
		return response;
	}

	@RequestMapping("/holdings")
	public @ResponseBody HttpRestfulResponse getHoldings() {
		HttpRestfulResponse response = new HttpRestfulResponse();
		double totalBuys, totalStocks;
		int totalBuysCount = 0;
		List<Holdings> holdings = new ArrayList<Holdings>();
		Holdings holding;
		List<String> uniqueStockNames = tradeRepo.findDistinctStockName();
		for (String stockName : uniqueStockNames) {
			List<Trade> tradeStocks = tradeRepo.findByStockName(stockName);
			totalBuys = 0;
			totalStocks = 0;
			for (Trade t : tradeStocks) {
				if (t.getBySale().equalsIgnoreCase("BUY")) {
					totalBuysCount++;
					totalStocks = totalStocks + t.getNoOfStocks();
					totalBuys = totalBuys + t.getPrice();
				} else if (t.getBySale().equalsIgnoreCase("SELL")) {
					totalStocks = totalStocks - t.getNoOfStocks();
				}
			}
			holding = new Holdings(stockName, totalBuys / totalBuysCount, totalStocks);
			holdings.add(holding);
		}
		if (holdings != null && holdings.size() > 0) {
			response.setData(holdings);
			response.setStatus(true);
		} else {
			response.setData(null);
			response.setStatus(false);
		}

		return response;
	}

	@PostMapping("/addTrade")
	public @ResponseBody HttpRestfulResponse createTrade(@RequestBody Trade trade) {
		Trade t1 = tradeRepo.save(trade);
		HttpRestfulResponse response = new HttpRestfulResponse();
		if (t1 != null) {
			response.setData(t1);
			response.setStatus(true);
		} else {
			response.setData(t1);
			response.setStatus(false);
		}
		return response;
	}

	@PostMapping("/updateTrade")
	public @ResponseBody HttpRestfulResponse updateTrade(@RequestBody Trade trade) {
		Trade t1 = tradeRepo.save(trade);
		HttpRestfulResponse response = new HttpRestfulResponse();
		if (t1 != null) {
			response.setData(t1);
			response.setStatus(true);
		} else {
			response.setData(t1);
			response.setStatus(false);
		}
		return response;
	}

	@DeleteMapping("/removeTrade")
	public @ResponseBody HttpRestfulResponse deleteTrade(@RequestBody Trade trade) {
		tradeRepo.delete(trade);
		HttpRestfulResponse response = new HttpRestfulResponse();
		response.setData(trade);
		response.setStatus(true);
		return response;
	}

}
