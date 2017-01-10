package guru.springframework.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.domain.Customer;
import guru.springframework.domain.DomainObject;

@Service
@Profile("map")
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {
	
	@Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Customer getById(Integer id) {
        return (Customer) super.getById(id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return (Customer) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
	
	protected void loadDomainObjects(){
        domainMap = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
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
        customer2.setId(2);
        customer2.setFirstName("Judy");
        customer2.setLastName("Jones");
        customer2.setEmail("judy@jones.com");
        customer2.setPhoneNumber("222-222-2222");
        customer2.setAddress1("811 First Street");
        customer2.setCity("St Louis");
        customer2.setState("MO");
        customer2.setZip("63122");
        
        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Jenny");
        customer3.setLastName("Johnson");
        customer3.setEmail("jenny@johnson.com");
        customer3.setPhoneNumber("555-234-8787");
        customer3.setAddress1("10 Fifth Avenue");
        customer3.setCity("Kansas City");
        customer3.setState("MO");
        customer3.setZip("61122");
        
        domainMap.put(1, customer1);
        domainMap.put(2, customer2);
        domainMap.put(3, customer3);
        
	}

}
