/**
 * Project example for Aquillian.
 * gaguena@gmail.com
 */
package com.gaguena.service;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.gaguena.ArquillianJNDI;
import com.gaguena.entity.Product;
import com.gaguena.entity.ProductPrice;

/**
 * Esse EJB(Service) irá expoer 2 EJB.
 * Uma composição de EJBs.
 * @author GAbriel Y. Aguena - gaguena@gmail.com
 *
 */
@Stateless
@Remote(RemoteExposedService.class)
public class RemoteExposedServiceImpl implements RemoteExposedService{

	
	@EJB
	private ProductService productService;
	
	@EJB(lookup=ArquillianJNDI.PRODUCT_PRICE_SERVICE)
	private ProductPriceService productPriceService;
	
	/* (non-Javadoc)
	 * @see com.gaguena.service.RemoteExposedService#findActivePriceBy(java.lang.Long)
	 */
	@Override
	public ProductPrice findActivePriceBy(Long idProduct) {
		return this.productPriceService.findActivePriceBy(idProduct);
	}

	/* (non-Javadoc)
	 * @see com.gaguena.service.RemoteExposedService#find(java.lang.Long)
	 */
	@Override
	public Product find(Long idProduct) {
		return this.productService.find(idProduct);
	}

}
