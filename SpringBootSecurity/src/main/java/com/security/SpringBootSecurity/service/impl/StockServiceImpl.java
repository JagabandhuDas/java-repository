package com.security.SpringBootSecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.SpringBootSecurity.dao.IStockDao;
import com.security.SpringBootSecurity.dto.StockDto;
import com.security.SpringBootSecurity.service.IStockService;

@Service
public class StockServiceImpl implements IStockService{

	@Autowired
	private IStockDao stockDao;
	
	@Override
	public List<StockDto> getAllStocks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockDto getStockById(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addStock(StockDto stock) {
		// TODO Auto-generated method stub
		stockDao.addStock(stock.toStockEntity());
		
	}

	@Override
	public void updateStock(StockDto stock) {
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
