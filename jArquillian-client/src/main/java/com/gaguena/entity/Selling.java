package com.gaguena.entity;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "ID_SELLING_SEQ", sequenceName = "ID_SELLING_SEQ", initialValue = 1, allocationSize = 1)
public class Selling {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SELLING_SEQ")
	private Long idSale;
	
	@Temporal(TemporalType.DATE)
	private Calendar dateSale;
	
	private BigDecimal discount;
	
	@OneToMany(mappedBy="sale")
	private List<ProductSale> productSales;

	public Long getIdSale() {
		return idSale;
	}

	public void setIdSale(Long idSale) {
		this.idSale = idSale;
	}

	public Calendar getDateSale() {
		return dateSale;
	}

	public void setDateSale(Calendar dateSale) {
		this.dateSale = dateSale;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public List<ProductSale> getProductSales() {
		return productSales;
	}

	public void setProductSales(List<ProductSale> productSales) {
		this.productSales = productSales;
	}
	
}
