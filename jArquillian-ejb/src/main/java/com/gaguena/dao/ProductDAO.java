/**
 * 
 */
package com.gaguena.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.gaguena.entity.Product;
import com.gaguena.utils.StringUtils;

/**
 * @author gaguena@gmail.com
 *
 */
@Stateless
@LocalBean
@SuppressWarnings("unchecked")
public class ProductDAO extends GenericDAO<Product, Long> {

	/**
	 * construtor que define class para super
	 */
	public ProductDAO() {
		super(Product.class);
	}

	
	/* (non-Javadoc)
	 * @see com.gaguena.dao.GenericDAO#findAll(java.util.List)
	 */
	@Override
	public List<Product> findAll(List<Long> keys) {
		Query createQuery = getEntityManager().createNamedQuery("select.stock.by.keys",Product.class);
		createQuery.setParameter("keys", keys);
		return createQuery.getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.gaguena.dao.ProductDAO#findByName(java.lang.String)
	 */
	public List<Product> findByName(final String name){
		Query createQuery = getEntityManager().createNamedQuery("select.products.by.name", Product.class);
		createQuery.setParameter("PRODUCT_NAME", name);
		return createQuery.getResultList();
	}


	/*
	 * (non-Javadoc)
	 * @see com.gaguena.dao.ProductDAO#findProductByLikeName(java.lang.String)
	 */
	public List<Product> findProductByLikeName(String name) {
		Query createQuery = getEntityManager().createNamedQuery("select.products.like.name", Product.class);
		createQuery.setParameter("PRODUCT_NAME", StringUtils.createParamLike(name));
		return createQuery.getResultList();
	}

}
