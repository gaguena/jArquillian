/**
 * Project example for Aquillian.
 * gaguena@gmail.com
 */
package com.gaguena.service;

import com.gaguena.entity.Product;
import com.gaguena.entity.ProductPrice;

/**
 * 
 * @author GAbriel Y. Aguena - gaguena@gmail.com
 *
 */
public interface RemoteExposedService {

	/**
	 * 
	 * @param idProduct
	 * @return
	 */
	ProductPrice findActivePriceBy(Long idProduct);
	
	/**
	 * 
	 * @param idProduct
	 * @return
	 */
	Product find(Long idProduct);
}
