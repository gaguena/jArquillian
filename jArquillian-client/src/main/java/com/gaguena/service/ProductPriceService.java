/**
 * Project example for Aquillian.
 * gaguena@gmail.com
 */
package com.gaguena.service;

import com.gaguena.entity.ProductPrice;

/**
 * 
 * @author GAbriel Y. Aguena - gaguena@gmail.com
 *
 */
public interface ProductPriceService {

	/**
	 * Recupera o ultimo Price ativo do producto. 
	 * @param idProduct
	 * @return
	 */
	ProductPrice findActivePriceBy(final Long idProductPrice);
}
