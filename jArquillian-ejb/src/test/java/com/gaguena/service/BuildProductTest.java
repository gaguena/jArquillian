/**
 * 
 */
package com.gaguena.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.gaguena.entity.Product;

/**
 * @author gaguena@gmail.com
 *
 */
public class BuildProductTest {

	private List<Product> products;
	
	private Product product;
	
	
	/**
	 * Cria Entity {@link Product}
	 * @return
	 */
	private Product creteProduct(){
		return new Product();
	}
	
	private List<Product> createList(){
		return new ArrayList<Product>();
	}
	/**
	 * Cria {@link Product} Simples
	 * @return
	 */
	public static Product buildProduct(){
		BuildProductTest buildProductTest = new BuildProductTest();
		buildProductTest.product =  buildProductTest.creteProduct();
		buildProductTest.product.setProductName("Carne de Ouro");
		buildProductTest.product.setExpiration(Calendar.getInstance());
		
		return buildProductTest.product;
	}
	
	public static List<Product> buildList(){
		
		BuildProductTest buildProductTest = new BuildProductTest();
		buildProductTest.products = buildProductTest.createList();
		
		buildProductTest.product = buildProductTest.creteProduct();
		buildProductTest.product.setProductName("Café");
		buildProductTest.product.setExpiration(Calendar.getInstance());
		buildProductTest.products.add(buildProductTest.product);
		
		buildProductTest.product = buildProductTest.creteProduct();
		buildProductTest.product.setProductName("Ervilha");
		buildProductTest.product.setExpiration(Calendar.getInstance());
		buildProductTest.products.add(buildProductTest.product);
		
		buildProductTest.product = buildProductTest.creteProduct();
		buildProductTest.product.setProductName("Creme de leite");
		buildProductTest.product.setExpiration(Calendar.getInstance());
		buildProductTest.products.add(buildProductTest.product);

		buildProductTest.product = buildProductTest.creteProduct();
		buildProductTest.product.setProductName("Carne de Ouro");
		buildProductTest.product.setExpiration(Calendar.getInstance());
		buildProductTest.products.add(buildProductTest.product);
		
		buildProductTest.product = buildProductTest.creteProduct();
		buildProductTest.product.setProductName("Pão de forma");
		buildProductTest.product.setExpiration(Calendar.getInstance());
		buildProductTest.products.add(buildProductTest.product);
		
		
		return buildProductTest.products;
	}
}
