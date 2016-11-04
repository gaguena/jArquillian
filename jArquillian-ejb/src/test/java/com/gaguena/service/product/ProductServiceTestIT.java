/**
 * 
 */
package com.gaguena.service.product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.ApplyScriptAfter;
import org.jboss.arquillian.persistence.ApplyScriptBefore;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gaguena.entity.Product;
import com.gaguena.entity.Stock;
import com.gaguena.service.JArquillianConfigTest;
import com.gaguena.service.ProductService;
import com.gaguena.util.DateUtil;

/**
 * @author gaguena@gmail.com
 *
 */
@RunWith(Arquillian.class)
public class ProductServiceTestIT {

	@Inject
	UserTransaction utx;

	@EJB
	private ProductService productService;

	/**
	 * Mandatory
	 * 
	 * Significa que sempre que o cliente for chamar o método, ele já deve estar
	 * em uma transação. Nesse caso, o método será executado dentro dessa mesma
	 * transação. Caso o cliente chame o método fora de uma transação, um erro
	 * será lançado e o código do método não será executado.
	 */
	public void findProductTransactionTest() {

	}

	@Deployment
	public static WebArchive createDeployment() {
		return JArquillianConfigTest.createDeployment();
	}

	/**
	 * Recupera Uma Lista de produto, pelo name. Antes o produto é inserido na
	 * base pelo script. O Produto será removido pelo script alvo.
	 */
	@Test
	@Transactional(TransactionMode.COMMIT)
	@ApplyScriptBefore("scripts/product/INSERT-INTO-PRODUCT.sql")
	@ApplyScriptAfter("scripts/product/DELETE-PRODUCT-AND-STOCK-ALL.sql")
	public void findProductsByLikeNameTest() {
		List<Product> products = productService.findProductByLikeName("Cal");
		Assert.assertNotNull(products);
		// Intera e altera nos produtos
		// comparando o name e trocando a data.
		for (Product p : products) {
			Calendar validadeOld = p.getExpiration();
			p.setExpiration(DateUtil.getCalendar(4));
			productService.merge(p);
			Assert.assertNotEquals(validadeOld, p.getExpiration());
		}

		List<Product> productsAll = productService.findAll();
		for (Product p : productsAll) {
			p.setStocks(new ArrayList<Stock>());
			Stock stock = new Stock();
			stock.setInStock(Calendar.getInstance());
			stock.setValue(100);
			stock.setProduct(p);
			p.getStocks().add(stock);
			productService.merge(p);

			Product productSearch = productService.find(p.getIdProduct());
			Assert.assertNotNull(productSearch.getStocks());
		}
	}

}
