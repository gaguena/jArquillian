/**
 * 
 */
package com.gaguena.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author gaguena@gmail.com
 *
 */
@Entity
@SequenceGenerator(name = "ID_STOCK_SEQ", sequenceName = "ID_STOCK_SEQ", initialValue = 1, allocationSize = 1)
public class Stock implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_STOCK_SEQ")
	@Column(name="ID_STOCK")
	private Long idStock;

	@Column(name="STOCK_SIZE")
	private Integer value;

	@Column(name="IN_STOCK")
	@Temporal(TemporalType.DATE)
	private Calendar inStock;
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUCT", referencedColumnName="ID_PRODUCT")
	private Product product;

	/**
	 * @return the idStock
	 */
	public Long getIdStock() {
		return idStock;
	}

	/**
	 * @param idStock the idStock to set
	 */
	public void setIdStock(Long idStock) {
		this.idStock = idStock;
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

	/**
	 * @return the inStock
	 */
	public Calendar getInStock() {
		return inStock;
	}

	/**
	 * @param inStock the inStock to set
	 */
	public void setInStock(Calendar inStock) {
		this.inStock = inStock;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idStock == null) ? 0 : idStock.hashCode());
		result = prime * result + ((inStock == null) ? 0 : inStock.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Stock other = (Stock) obj;
		if (idStock == null) {
			if (other.idStock != null)
				return false;
		} else if (!idStock.equals(other.idStock))
			return false;
		if (inStock == null) {
			if (other.inStock != null)
				return false;
		} else if (!inStock.equals(other.inStock))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
}
