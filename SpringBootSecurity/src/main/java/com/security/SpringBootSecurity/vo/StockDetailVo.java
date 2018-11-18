package com.security.SpringBootSecurity.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.security.SpringBootSecurity.dto.StockDetail;
import com.security.SpringBootSecurity.entity.Stock;



public class StockDetailVo {

	private Integer stockId;
	private Stock stock;
	private String compName;
	private String compDesc;
	private String remark;
	private Date listedDate;
	
	
	
	public StockDetailVo(@JsonProperty(value="compName") String compName, 
						 @JsonProperty(value="compDesc") String compDesc, 
						 @JsonProperty(value="remark") String remark,
						 @JsonProperty(value="listedDate") Date listedDate) {
		super();
	
		this.compName = compName;
		this.compDesc = compDesc;
		this.remark = remark;
		this.listedDate = listedDate;
	}
	
	public Integer getStockId() {
		return stockId;
	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getCompDesc() {
		return compDesc;
	}
	public void setCompDesc(String compDesc) {
		this.compDesc = compDesc;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getListedDate() {
		return listedDate;
	}
	public void setListedDate(Date listedDate) {
		this.listedDate = listedDate;
	}
	
	public StockDetail toStockDetailDto() {
		StockDetail stockDetail = new StockDetail();
		stockDetail.setStock(this.stock);
		stockDetail.setCompName(this.compName);
		stockDetail.setCompDesc(this.compDesc);
		stockDetail.setRemark(this.remark);
		stockDetail.setListedDate(this.listedDate);
		return stockDetail;
	}
}

