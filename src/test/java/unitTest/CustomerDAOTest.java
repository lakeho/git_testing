package unitTest;

import org.testng.annotations.*;

import jv5.ass.repository.CustomerRepository;
import jv5.ass.repository.ProductRepository;
import jv5.ass.service.CustomerService;
import jv5.ass.service.ProductService;

import static org.testng.Assert.assertEquals;

import java.sql.SQLException;

import org.openqa.selenium.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;

import jv5.ass.entity.Customer;
import jv5.ass.DemoApplication;

@SpringBootTest(classes = DemoApplication.class)
public class CustomerDAOTest extends AbstractTestNGSpringContextTests {
  
	@Autowired
	private CustomerRepository CustomerRepo;
	@Autowired
	private CustomerService CustomerService;
	
	private Customer c;
	
	@BeforeMethod
	public void newCustomer() {
		c = new Customer();
	}
	
	@AfterMethod
	public void delCustomer() {
		CustomerRepo.delete(c);
	}
	
	@Parameters({ "ten", "user", "pass", "sex", "tel", "addr", "expected" })
	@Test
	public void addCustomer( @Optional() String ten, @Optional() String user, @Optional() String pass, 
			@Optional("true") Boolean sex, @Optional() String tel, @Optional() String addr, @Optional("false") Boolean expected ) {
		c.setTenkh(ten);
		c.setUsername(user);
		c.setPass(pass);
		c.setSex(sex);
		c.setTel(tel);
		c.setAdd(addr);
		Boolean actual = CustomerService.BSave(c);
		Assert.assertEquals(actual, expected);
	}
	
}
