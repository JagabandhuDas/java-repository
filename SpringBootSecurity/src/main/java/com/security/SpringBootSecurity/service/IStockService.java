package com.security.SpringBootSecurity.service;

import java.util.List;

import com.security.SpringBootSecurity.dto.StockDto;

public interface IStockService {

	List<StockDto> getAllStocks();
	StockDto getStockById(String id);
	void addStock(StockDto stock);
	void updateStock(StockDto stock);
	void deleteStock(String id);
	boolean stockExists(String code, String name);
}
