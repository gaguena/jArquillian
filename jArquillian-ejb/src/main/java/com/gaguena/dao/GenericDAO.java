/**
 * 
 */
package com.gaguena.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author gaguena@gmail.com
 *
 */

@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class GenericDAO<T, K extends Serializable>{

	@PersistenceContext
	private EntityManager entityManager;

	private Class clazz;

	public GenericDAO(Class clazz) {
		this.clazz = clazz;
	}

	public T save(T t) {
		entityManager.persist(t);
		return t;
	}
	
	public abstract List<T> findAll(List<K> keys);
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removeAll(List<K> keys){
		for(T t : this.findAll(keys)){
			this.entityManager.remove(t);
		}
	}

	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public List<T> findAll(){
		return entityManager.createQuery("Select t from " + clazz.getSimpleName() + " t").getResultList();
	    
	}
	/**
	 * @param idProduct
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public T find(K k) {
		return (T) this.getEntityManager().find(clazz, k);
	}
	
	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager
	 *            the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	public List<T> saveAll(List<T> list){
		for(T t : list){
			entityManager.persist(t);
		}
		return list;
	}
	
	public T merge(T t){
		return this.entityManager.merge(t);
	}
}
