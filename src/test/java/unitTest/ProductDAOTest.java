package unitTest;

import org.testng.annotations.*;

import jv5.ass.repository.ProductRepository;
import jv5.ass.service.ProductService;

import static org.testng.Assert.assertEquals;

import java.sql.SQLException;

import org.openqa.selenium.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;

import jv5.ass.entity.Product;
import jv5.ass.DemoApplication;


@SpringBootTest(classes = DemoApplication.class)
public class ProductDAOTest extends AbstractTestNGSpringContextTests {
	
	@Autowired
	private ProductRepository ProductRepo;
	@Autowired
    private ProductService ProductService;
	
	private Product p;
	
	@BeforeTest
	public void beforeTest() {
		
	}
	
	@AfterTest
	public void afterTest() {
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		p = new Product();
	}
	
	@AfterMethod
	public void afterMethod() {
		ProductRepo.delete(p);
	}
	
	@Parameters({ "ten", "gia", "loai", "anh", "expected" })
	@Test
	public void addProduct(@Optional() String ten, @Optional("0") int gia, 
			@Optional() Boolean loai, @Optional() String anh, @Optional("false") Boolean expected) throws Exception{
		p.setTensp(ten);
		p.setLoaisp(loai);
		p.setGia(gia);
		p.setAnh(anh);
		Boolean actual = ProductService.verifySave(p);
		Assert.assertEquals(actual, expected);
	}
	
	//chi nhap ten
	//chi nhap loai
	//chi nhap gia
	//chi nhap anh
	
	//ten + loai
	//ten + gia
	//ten + anh
	//loai + gia
	//loai + anh
	//gia + anh
	
	//ten + loai + gia
	//ten + loai + anh
	//ten + gia + anh
	//loai + gia + anh
	
	//nhap full
	//khong nhap
	
	//kho
	
	

}
