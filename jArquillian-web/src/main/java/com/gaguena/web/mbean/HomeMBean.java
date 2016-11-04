/**
 * 
 */
package com.gaguena.web.mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.gaguena.entity.Product;
import com.gaguena.service.ProductService;

/**
 * ManagedBean for {@link Product}
 * @author gaguena@gmail.com
 *
 */
@ManagedBean
public class HomeMBean {

	/**
	 * Link {@link ProductService}
	 */
	@Inject
	private ProductService productService;
	
	public List<Product> getProducts(){
		return productService.findAll();
	}
}
