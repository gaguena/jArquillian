/**
 * Project example for Aquillian.
 * gaguena@gmail.com
 */
package com.gaguena;

/**
 * 
 * @author GAbriel Y. Aguena - gaguena@gmail.com
 *
 */
public interface ArquillianJNDI {

	/**
	 * ESse JNDI representa um EJB Externo, apenas uma simulação.
	 * Assim não é necessario ter outro EAR. pois o seu JNDI é diferente: projetoEARExterno .
	 */
	String PRODUCT_PRICE_SERVICE = "java:global/projetoEARExterno/ProductPriceServiceImpl";
}
