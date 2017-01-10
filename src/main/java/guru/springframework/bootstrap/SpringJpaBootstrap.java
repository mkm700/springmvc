package guru.springframework.bootstrap;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Customer;
import guru.springframework.domain.Product;
import guru.springframework.services.CustomerService;
import guru.springframework.services.ProductService;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private ProductService productService;
	private CustomerService customerService;
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		loadProducts();
		loadCustomers();
	}

	public void loadProducts() {

        Product product1 = new Product();
        product1.setDescription("Product 1 DB");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");

        Product product2 = new Product();
        product2.setDescription("Product 2 DB");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");

        Product product3 = new Product();
        product3.setDescription("Product 3 DB");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");

        Product product4 = new Product();
        product4.setDescription("Product 4 DB");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");

        Product product5 = new Product();
        product5.setDescription("Product 5 DB");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");

        productService.saveOrUpdate(product1);
        productService.saveOrUpdate(product2);
        productService.saveOrUpdate(product3);
        productService.saveOrUpdate(product4);
        productService.saveOrUpdate(product5);
	}
	
	public void loadCustomers(){
        
        Customer customer1 = new Customer();
        customer1.setFirstName("Joe");
        customer1.setLastName("Jennings");
        customer1.setEmail("joe@jennings.com");
        customer1.setPhoneNumber("111-111-1111");
        customer1.setAddress1("123 Main Street");
        customer1.setAddress2("Apt 3");
        customer1.setCity("Chicago");
        customer1.setState("IL");
        customer1.setZip("60606");

        Customer customer2 = new Customer();
        customer2.setFirstName("Judy");
        customer2.setLastName("Jones");
        customer2.setEmail("judy@jones.com");
        customer2.setPhoneNumber("222-222-2222");
        customer2.setAddress1("811 First Street");
        customer2.setCity("St Louis");
        customer2.setState("MO");
        customer2.setZip("63122");
        
        Customer customer3 = new Customer();
        customer3.setFirstName("Jenny");
        customer3.setLastName("Johnson");
        customer3.setEmail("jenny@johnson.com");
        customer3.setPhoneNumber("555-234-8787");
        customer3.setAddress1("10 Fifth Avenue");
        customer3.setCity("Kansas City");
        customer3.setState("MO");
        customer3.setZip("61122");
        
        customerService.saveOrUpdate(customer1);
        customerService.saveOrUpdate(customer2);
        customerService.saveOrUpdate(customer3);
        
	}
}
