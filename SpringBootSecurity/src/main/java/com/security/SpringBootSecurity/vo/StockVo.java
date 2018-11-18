package com.security.SpringBootSecurity.vo;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.security.SpringBootSecurity.dto.Category;
import com.security.SpringBootSecurity.dto.StockDetail;
import com.security.SpringBootSecurity.dto.StockDto;
import com.security.SpringBootSecurity.entity.Stock;

public class StockVo {
	private Integer stockId;
	private String stockCode;
	private String stockName;
	private StockDetailVo stockDetail;
	private Set<StockDailyRecordVo> stockDailyRecords = new HashSet<StockDailyRecordVo>(0);
	private Set<Category> categories = new HashSet<Category>(0);

	public StockVo() {
	}

	public StockVo(String stockCode, String stockName) {
		this.stockCode = stockCode;
		this.stockName = stockName;
	}

	public StockVo( @JsonProperty(value="code", required=true) String stockCode, 
					@JsonProperty(value="name", required=true) String stockName, 
					@JsonProperty(value="detail", required=true) StockDetailVo stockDetail) {
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

	public StockDetailVo getStockDetail() {
		return stockDetail;
	}

	public void setStockDetail(StockDetailVo stockDetail) {
		this.stockDetail = stockDetail;
	}

	public Set<StockDailyRecordVo> getStockDailyRecords() {
		return stockDailyRecords;
	}

	public void setStockDailyRecords(Set<StockDailyRecordVo> stockDailyRecords) {
		this.stockDailyRecords = stockDailyRecords;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	
	
	public StockDto toStockDto() {
		
		StockDto stockDto = new StockDto();
		stockDto.setStockCode(this.stockCode);
		stockDto.setStockName(this.stockName);
		
		
		
		stockDto.setStockDetail(this.stockDetail.toStockDetailDto());
		return stockDto;
	}
	
}
