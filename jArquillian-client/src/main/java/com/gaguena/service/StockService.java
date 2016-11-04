package com.gaguena.service;

import java.util.List;

import com.gaguena.entity.Product;
import com.gaguena.entity.Stock;

/**
 * Interface Service for Stock
 * @author gaguena
 *
 */
public interface StockService {

	/**
	 * Method count stock by product
	 * @param product
	 * @return
	 */
	Long findCountStockBy(final Product product);
	
	/**
	 * 
	 * @param produc
	 * @return
	 */
	List<Stock> findStocksBy(final Product produc);
	
	/**
	 * Save All Stocks
	 * Method for 
	 * @param stocks
	 * @return
	 */
	List<Stock> saveAll(final List<Stock> stocks);
}
