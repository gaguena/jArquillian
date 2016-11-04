/**
 * Project jArquillian-ejb
 */
package com.gaguena.service;

import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import com.gaguena.dao.ProductDAO;
import com.gaguena.dao.ProductPriceDAO;
import com.gaguena.dao.StockDAO;
import com.gaguena.entity.Product;

/**
 * Comments JArquillianConfigTest create 18 de set de 2016
 * 
 * @author gaguena
 * 
 */
public class JArquillianConfigTest {

	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "jArquillian.war")
				.addClasses(StockService.class, StockServiceImpl.class, 
						ProductPriceService.class, ProductPriceServiceImpl.class,
						ProductServiceImpl.class, ProductDAO.class, StockDAO.class,
						RemoteExposedService.class, RemoteExposedServiceImpl.class,
						ProductPriceDAO.class)
				.addPackage(Product.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
	}
	

	
}
