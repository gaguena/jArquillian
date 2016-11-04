/**
 * Project example for Aquillian.
 * gaguena@gmail.com
 */
package com.gaguena.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.gaguena.entity.ProductPrice;

/**
 * 
 * @author GAbriel Y. Aguena - gaguena@gmail.com
 *
 */
@Stateless
@LocalBean
public class ProductPriceDAO extends GenericDAO<ProductPrice, Long>{

	/**
	 * @param clazz
	 */
	public ProductPriceDAO() {
		super(ProductPrice.class);
	}

	/* (non-Javadoc)
	 * @see com.gaguena.dao.GenericDAO#findAll(java.util.List)
	 */
	@Override
	public List<ProductPrice> findAll(List<Long> keys) {
		// TODO Auto-generated method stub
		return null;
	}

}
