package com.gaguena.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.gaguena.entity.Product;
import com.gaguena.entity.Stock;

@LocalBean
@Stateless(mappedName="stockDAO")
@SuppressWarnings("unchecked")
public class StockDAO extends GenericDAO<Stock, Long>  {

	public StockDAO() {
		super(Stock.class);
	}

	@Override
	public List<Stock> findAll(List<Long> keys) {
		Query query = this.getEntityManager().createNamedQuery("select.stock.by.keys", Stock.class);
		query.setParameter("KEYS", keys);
		return query.getResultList();
	}
	
	public List<Stock> findBy(Product product){
		Query query = this.getEntityManager().createNamedQuery("select.sotck.by.product", Stock.class);
		query.setParameter("ID_PRODUCT", product.getIdProduct());
		return  query.getResultList();
	}

	/** 
	 * Method for 
	 * @param product
	 * @return
	 */
	public Long findCountStockBy(Product product) {
		Query query = this.getEntityManager().createNamedQuery("select.count.sotck.by.product", Stock.class);
		query.setParameter("ID_PRODUCT", product.getIdProduct());
		return (Long) query.getSingleResult();
	}

}
