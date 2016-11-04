/**
 * 
 */
package com.gaguena.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author gaguena@gmail.com
 *
 */
@Entity
@SequenceGenerator(name = "ID_PRODUCT_SEQ", sequenceName = "ID_PRODUCT_SEQ", initialValue = 1, allocationSize = 1)
public class Product extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PRODUCT_SEQ")
	@Column(name="ID_PRODUCT")
	private Long idProduct;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="EXPIRATION_DATE")
	@Temporal(TemporalType.DATE)
	private Calendar expiration;

	@OneToMany(mappedBy="product", cascade=CascadeType.PERSIST)
	private List<Stock> stocks;
	
	@OneToMany(mappedBy="product")
	private List<ProductPrice> prices;

	/**
	 * @return the idProduct
	 */
	public Long getIdProduct() {
		return idProduct;
	}

	/**
	 * @param idProduct the idProduct to set
	 */
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the expiration
	 */
	public Calendar getExpiration() {
		return expiration;
	}

	/**
	 * @param expiration the expiration to set
	 */
	public void setExpiration(Calendar expiration) {
		this.expiration = expiration;
	}

	/**
	 * @return the stocks
	 */
	public List<Stock> getStocks() {
		return stocks;
	}

	/**
	 * @param stocks the stocks to set
	 */
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	/**
	 * @return the prices
	 */
	public List<ProductPrice> getPrices() {
		return prices;
	}

	/**
	 * @param prices the prices to set
	 */
	public void setPrices(List<ProductPrice> prices) {
		this.prices = prices;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idProduct == null) ? 0 : idProduct.hashCode());
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (idProduct == null) {
			if (other.idProduct != null)
				return false;
		} else if (!idProduct.equals(other.idProduct))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}

	
}
