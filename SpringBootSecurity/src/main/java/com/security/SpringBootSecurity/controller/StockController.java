package com.security.SpringBootSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.SpringBootSecurity.dto.StockDto;
import com.security.SpringBootSecurity.service.IStockService;
import com.security.SpringBootSecurity.vo.StockVo;

@RestController
@RequestMapping("/api/stock")
public class StockController {
	
	@Autowired
	private IStockService stockService;
	
	@GetMapping("stock/{id}")
	public ResponseEntity<StockDto> getStockById(@PathVariable("id") String id) {
		StockDto employee = stockService.getStockById(id);
		return new ResponseEntity<StockDto>(employee, HttpStatus.OK);
	}
	
	@GetMapping("stocks")
	public ResponseEntity<List<StockDto>> getAllStocks() {
		
		System.out.println("Insideeeee");
		List<StockDto> list = stockService.getAllStocks();
		return new ResponseEntity<List<StockDto>>(list, HttpStatus.OK);
	}
	
	@PostMapping("stock/add")
	public ResponseEntity<Void> addStock(@RequestBody final StockVo stockvo) {
				System.out.println(""+stockvo.toString());
                 stockService.addStock(stockvo.toStockDto());
                /*if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }*/
                HttpHeaders headers = new HttpHeaders();
                //headers.setLocation(builder.path("/employee/{id}").buildAndExpand(employeeVo.getEmpId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("stock/update")
	public ResponseEntity<StockDto> updateStock(@RequestBody StockDto stock) {
		
		stockService.updateStock(stock);
		return new ResponseEntity<StockDto>(stock, HttpStatus.OK);
	}
	
	@DeleteMapping("stock/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") String id) {
		stockService.deleteStock(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	

}
