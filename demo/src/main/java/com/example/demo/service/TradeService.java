package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Trade;
import com.example.demo.repository.TradeRepository;


@Service
public class TradeService {
//	
//	@PersistenceContext
//	private EntityManager entityManager;
	
	@Autowired
	private TradeRepository tradeRepository;
	
	public void insert(Trade trade) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(trade);
		entityManager.getTransaction().commit();
		
	
	  }
	
	public List<Trade> tradeByOrder(){
		return tradeRepository.findAllTradeGropByStockName();
	}
	}