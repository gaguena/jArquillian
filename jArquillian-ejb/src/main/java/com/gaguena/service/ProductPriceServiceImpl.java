/**
 * Project example for Aquillian.
 * gaguena@gmail.com
 */
package com.gaguena.service;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.gaguena.ArquillianJNDI;
import com.gaguena.dao.ProductPriceDAO;
import com.gaguena.entity.ProductPrice;

/**
 * 
 * @author GAbriel Y. Aguena - gaguena@gmail.com
 *
 */
@Stateless(mappedName=ArquillianJNDI.PRODUCT_PRICE_SERVICE)
@Remote(ProductPriceService.class)
public class ProductPriceServiceImpl implements ProductPriceService{

	@EJB
	private ProductPriceDAO productPriceDAO;
	
	/* (non-Javadoc)
	 * @see com.gaguena.service.ProductPriceService#findActivePriceBy(java.lang.Long)
	 */
	@Override
	public ProductPrice findActivePriceBy(Long idProductPrice) {
		return productPriceDAO.find(idProductPrice);
	}

}
