/**
 * Project jArquillian-client
 */
package com.gaguena.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



/**
 * Comments
 * ProductPrice create 02/11/2016
 * @author gaguena 
 * 
 */
@Entity
@Table(name="PRODUCT_PRICE")
@SequenceGenerator(name = "PRODUCT_PRICE_SEQ", sequenceName = "PRODUCT_PRICE_SEQ", initialValue = 1, allocationSize = 1)
public class ProductPrice extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_PRICE_SEQ")
	@Column(name="ID_PRODUCT_PRICE")
	private Long idProductPrice;
	
	@Column(name="PRICE_VALUE")
	private BigDecimal priceValue;
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUCT", referencedColumnName="ID_PRODUCT")
	private Product product;

	@Enumerated(EnumType.STRING)
	private ProductStatusEnum status;
	
	public Long getIdProductPrice() {
		return idProductPrice;
	}

	public void setIdProductPrice(Long idProductPrice) {
		this.idProductPrice = idProductPrice;
	}

	public BigDecimal getPriceValue() {
		return priceValue;
	}

	public void setPriceValue(BigDecimal priceValue) {
		this.priceValue = priceValue;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ProductStatusEnum status) {
		this.status = status;
	}
	
}
