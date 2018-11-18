package com.security.SpringBootSecurity.dto;

import java.util.HashSet;
import java.util.Set;

import com.security.SpringBootSecurity.dto.Category;
import com.security.SpringBootSecurity.dto.StockDailyRecord;
import com.security.SpringBootSecurity.dto.StockDetail;
import com.security.SpringBootSecurity.entity.Stock;

public class StockDto {
	
	private Integer stockId;
	private String stockCode;
	private String stockName;
	private StockDetail stockDetail;
	private Set<StockDailyRecord> stockDailyRecords = new HashSet<StockDailyRecord>(0);
	private Set<Category> categories = new HashSet<Category>(0);

	public StockDto() {
	}

	public StockDto(String stockCode, String stockName) {
		this.stockCode = stockCode;
		this.stockName = stockName;
	}

	public StockDto(String stockCode, String stockName, StockDetail stockDetail) {
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockDetail = stockDetail;
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public StockDetail getStockDetail() {
		return stockDetail;
	}

	public void setStockDetail(StockDetail stockDetail) {
		this.stockDetail = stockDetail;
	}

	public Set<StockDailyRecord> getStockDailyRecords() {
		return stockDailyRecords;
	}

	public void setStockDailyRecords(Set<StockDailyRecord> stockDailyRecords) {
		this.stockDailyRecords = stockDailyRecords;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	public Stock toStockEntity() {
		Stock stockentity = new Stock();
		stockentity.setStockCode(this.stockCode);
		stockentity.setStockName(this.stockName);
		
		stockentity.setStockDetail(this.stockDetail.toStockEntity());
		return stockentity;
	}
	
	
}
