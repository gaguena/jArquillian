/**
 * Project example for Aquillian.
 * gaguena@gmail.com
 */
package com.gaguena.service.exposed;

import javax.ejb.EJB;
import javax.naming.NamingException;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ApplyScriptAfter;
import org.jboss.arquillian.persistence.ApplyScriptBefore;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
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


	/**
	 * Inject RemoteExposedService
	 */
	@EJB
	private RemoteExposedService remoteExposedService;

	/**
	 * @throws NamingException
	 * 
	 */
	@Test
	@ApplyScriptBefore(value = "scripts/price/INSERT_PRODUCT_PRICE.sql")
	@ApplyScriptAfter(value="scripts/price/DELETE_PRODUCT_PRICE.sql")
	public void findActivePriceByTest() throws NamingException {
		ProductPrice price = this.remoteExposedService.findActivePriceBy(1L);
		System.out.println(price);
	}

	/**
	 * 
	 */
	@Before
	public void findProductTest() {
		System.out.println("TESTE");
	}

	@Deployment
	public static WebArchive createDeployment() {
		return JArquillianConfigTest.createDeployment();
	}
}
