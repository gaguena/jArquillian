/**
 * Project example for Aquillian.
 * gaguena@gmail.com
 */
package com.gaguena.service.exposed;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ApplyScriptAfter;
import org.jboss.arquillian.persistence.ApplyScriptBefore;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gaguena.entity.ProductPrice;
import com.gaguena.service.JArquillianConfigTest;
import com.gaguena.service.RemoteExposedService;

/**
 * 
 * @author GAbriel Y. Aguena - gaguena@gmail.com
 *
 */
@RunWith(Arquillian.class)
public class RemoteExposedServiceTestIT {


	private static final Long PRICE_ID = 1L;
	/**
	 * Inject RemoteExposedService
	 */
	@EJB
	private RemoteExposedService remoteExposedService;

	/**
	 * Teste para recuperar ProductPrice pelo seu Id.
	 */
	@Test
	@ApplyScriptBefore(value = "scripts/price/INSERT_PRODUCT_PRICE.sql")
	@ApplyScriptAfter(value="scripts/price/DELETE_PRODUCT_PRICE.sql")
	public void findActivePriceByTest(){
		ProductPrice price = this.remoteExposedService.findActivePriceBy(PRICE_ID);
		Assert.assertNotNull(price);
		Assert.assertEquals(PRICE_ID, price.getIdProductPrice());
	}


	/**
	 * Deploy for Arquillian.
	 * @return
	 */
	@Deployment
	public static WebArchive createDeployment() {
		return JArquillianConfigTest.createDeployment();
	}
}
