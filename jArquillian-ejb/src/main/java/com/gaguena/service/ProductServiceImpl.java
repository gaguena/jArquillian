/**
 * 
 */
package com.gaguena.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.gaguena.dao.ProductDAO;
import com.gaguena.dao.StockDAO;
import com.gaguena.entity.Product;

/**
 * @author gaguena@gmail.com
 *
 */
@Stateless(name="productBean")
@Remote(ProductService.class)
public class ProductServiceImpl implements ProductService{

	@EJB
	private ProductDAO productDAO;
	
	@EJB
	private StockDAO stockDAO;
	
	/* (non-Javadoc)
	 * @see com.gaguena.service.ProductService#save(com.gaguena.entity.Product)
	 */
	@Override
	public Product save(Product product) {
		return this.productDAO.save(product);
	}

	/* (non-Javadoc)
	 * @see com.gaguena.service.ProductService#find(java.lang.Long)
	 */
	@Override
	public Product find(Long idProduct) {
		return this.productDAO.find(idProduct);
	}

	/* (non-Javadoc)
	 * @see com.gaguena.service.ProductService#findAll()
	 */
	@Override
	public List<Product> findAll() {
		return this.productDAO.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.gaguena.service.ProductService#removeAll(java.util.List)
	 */
	@Override
	public void removeAll(List<Product> products) {
		List<Long> keys = new ArrayList<Long>();
		for(Product p : products)
			keys.add(p.getIdProduct());
		
		this.productDAO.removeAll(keys);
		
	}
	
	/* (non-Javadoc)
	 * @see com.gaguena.service.ProductService#saveAll(java.util.List)
	 */
	@Override
	public List<Product> saveAll(List<Product> products) {
		 return this.productDAO.saveAll(products);
	}
	
	/* (non-Javadoc)
	 * @see com.gaguena.service.ProductService#findByName(java.lang.String)
	 */
	@Override
	public List<Product> findByName(String name) {
		return this.productDAO.findByName(name);
	}

	/* (non-Javadoc)
	 * @see com.gaguena.service.ProductService#merge(com.gaguena.entity.Product)
	 */
	@Override
	public Product merge(Product p) {
		return this.productDAO.merge(p);
	}
	/* (non-Javadoc)
	 * @see com.gaguena.service.ProductService#findProductByLikeName(java.lang.String)
	 */
	@Override
	public List<Product> findProductByLikeName(String name) {
		return this.productDAO.findProductByLikeName(name);
	}
	
}
