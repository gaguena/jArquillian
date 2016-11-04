package com.gaguena.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductSale {

	@Id
	private Long idProductSale;
	
	@ManyToOne
	@JoinColumn(name="idSale", referencedColumnName="idSale")
	private Selling sale;
	
	@ManyToOne
	@JoinColumn(name="idProduct", referencedColumnName="idProduct")
	private Product product;

	private int productsSize;
	
	public Long getIdProductSale() {
		return idProductSale;
	}

	public void setIdProductSale(Long idProductSale) {
		this.idProductSale = idProductSale;
	}

	public Selling getSale() {
		return sale;
	}

	public void setSale(Selling sale) {
		this.sale = sale;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductsSize() {
		return productsSize;
	}

	public void setProductsSize(int productsSize) {
		this.productsSize = productsSize;
	}
	
}
