/**
 * 
 */
package com.gaguena.service;

import java.util.List;

import com.gaguena.entity.Product;

/**
 * @author gaguena@gmail.com
 *
 */

public interface ProductService {

	/**
	 * Save Product 
	 * @param product
	 * @return
	 */
	public Product save(Product product);
	
	/**
	 * Save Products List
	 * @param products
	 * @return
	 */
	public List<Product> saveAll(List<Product> products);

	/**
	 * Update {@link Product}
	 * @param p
	 * @return
	 */
	public Product merge(Product p);
	
	/**
	 * Search {@link Product} by name
	 * @param name
	 * @return
	 */
	public List<Product> findByName(String name);
	
	/**
	 * Recupera uma lista de produto com like
	 * @param name
	 * @return
	 */
	public List<Product> findProductByLikeName(String name);
	/**
	 * Busca pelo Id
	 * @param idProduct
	 * @return
	 */
	public Product find(Long idProduct);
	
	/**
	 * Recupera todos {@link Product}
	 * @return
	 */
	public List<Product> findAll();
	
	/**
	 * Metodo que ira remover todos {@link Product} em uma lista
	 * @param products
	 */
	public void removeAll(final List<Product> products);
}
