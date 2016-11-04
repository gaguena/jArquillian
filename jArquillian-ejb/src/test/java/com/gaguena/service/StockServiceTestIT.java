/**
 * Project jArquillian-ejb
 */
package com.gaguena.service;

import javax.ejb.EJB;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ApplyScriptAfter;
import org.jboss.arquillian.persistence.ApplyScriptBefore;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gaguena.entity.Product;

/**
 * Comments
 * StockServiceTestIT create 18 de set de 2016
 * @author gaguena 
 * 
 */
@RunWith(Arquillian.class)
@ApplyScriptBefore("scripts/stock/INSERT-STOCK.SQL")
@ApplyScriptAfter("scripts/stock/DELETE-STOCK.SQL")
public class StockServiceTestIT extends JArquillianConfigTest{
	
	@EJB
	private StockService stockService;
	
	@Test
	@Transactional
	public void findStockByProductTest(){
		Product product = new Product();
		product.setIdProduct(9999L);
		Long stockSize = stockService.findCountStockBy(product);
		System.out.println(stockSize);
	}
}
