package com.security.SpringBootSecurity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.security.SpringBootSecurity.dao.IStockDao;
import com.security.SpringBootSecurity.entity.Stock;


@Repository
@Transactional
public class StockDaoImpl implements IStockDao{
	
	@PersistenceContext
	EntityManager entityManager;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> getAllStocks() {
		// TODO Auto-generated method stub
		
		String hql = "FROM Stock";
		return (List<Stock>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Stock getStockById(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addStock(Stock stock) {
		// TODO Auto-generated method stub
		System.out.println("Saving stock data");
		entityManager.persist(stock);
		
	}

	@Override
	public void updateStock(Stock stock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStock(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean stockExists(String code, String name) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
