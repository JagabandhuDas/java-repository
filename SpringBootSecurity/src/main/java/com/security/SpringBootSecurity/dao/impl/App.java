package com.security.SpringBootSecurity.dao.impl;

import java.util.Date;

import com.security.SpringBootSecurity.dao.IStockDao;
import com.security.SpringBootSecurity.entity.Stock;
import com.security.SpringBootSecurity.entity.StockDetail;


public class App {

	
	public static void StockMain() {
		System.out.println("Hibernate one to one (Annotation)");

		//Session session = HibernateUtil.getSessionFactory().openSession();Hi
		//session.beginTransaction();
		
		IStockDao stockDAO = new StockDaoImpl();
		
		Stock stock = new Stock();

		stock.setStockCode("7052");
		stock.setStockName("PADINI");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("PADINI Holding Malaysia");
		stockDetail.setCompDesc("one stop shopping");
		stockDetail.setRemark("vinci vinci");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		stockDAO.addStock(stock);
		//session.save(stock);
		//session.getTransaction().commit();

		System.out.println("Done");
	}
}