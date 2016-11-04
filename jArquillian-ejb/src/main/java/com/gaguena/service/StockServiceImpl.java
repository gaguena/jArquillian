package com.gaguena.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.gaguena.dao.StockDAO;
import com.gaguena.entity.Product;
import com.gaguena.entity.Stock;

/**
 * 
 * Class StockServiceImpl, implement {@link StockService}
 * StockServiceImpl create 18 de set de 2016
 * @author gaguena 
 *
 */
@Remote
@Stateless(mappedName="stockService")
public class StockServiceImpl implements StockService{

	@EJB
	private StockDAO stockDAO;
	
	/* (non-Javadoc)
	 * @see com.gaguena.service.StockService#findCountStockBy(com.gaguena.entity.Product)
	 */
	@Override
	public Long findCountStockBy(final Product product) {
		return this.stockDAO.findCountStockBy(product);
	}

	/* (non-Javadoc)
	 * @see com.gaguena.service.StockService#findStocksBy(com.gaguena.entity.Product)
	 */
	@Override
	public List<Stock> findStocksBy(Product product) {
		return this.stockDAO.findBy(product);
	}

	/* (non-Javadoc)
	 * @see com.gaguena.service.StockService#saveAll(java.util.List)
	 */
	@Override
	public List<Stock> saveAll(final List<Stock> stocks) {
		return this.stockDAO.saveAll(stocks);
	}
}
