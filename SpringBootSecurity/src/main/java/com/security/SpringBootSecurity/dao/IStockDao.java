package com.security.SpringBootSecurity.dao;

import java.util.List;

import com.security.SpringBootSecurity.entity.Stock;



public interface IStockDao {
	
	List<Stock> getAllStocks();
	Stock getStockById(String empId);
	void addStock(Stock stock);
	void updateStock(Stock stock);
	void deleteStock(String id);
	boolean stockExists(String code, String name);

}
