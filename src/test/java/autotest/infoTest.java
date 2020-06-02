package autotest;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class infoTest {
	public String baseUrl = "http://localhost:8080/login";
	String driverPath = "E:\\FPoly\\geckodriver.exe";
	public WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		System.out.println("launching firefox browser"); 
	    System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[1]")).sendKeys("laketa");
    	driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[2]")).sendKeys("123456");
    	driver.findElement(By.xpath("//*[@id=\"logbtn\"]")).click();
    	driver.findElement(By.xpath("/html/body/div/div[1]/div/a[2]")).click();
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("closing firefox browser"); 
		driver.close();
		System.out.println("firefox browser closed"); 
	}
	
	//null all
	@Test(priority = 0)
	public void test1() {
		WebElement name = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[2]"));
		name.clear();
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "All textboxes must be filled!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	//name null
	@Test(priority = 1)
	public void test2() {
		WebElement name = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[2]"));
		name.clear();
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "All textboxes must be filled!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	//user null
	@Test(priority = 2)
	public void test3() {
		WebElement user = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[5]"));
		user.clear();
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "All textboxes must be filled!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	//tel null
	@Test(priority = 3)
	public void test4() {
		WebElement tel = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[7]"));
		tel.clear();
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "All textboxes must be filled!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	//addr null
	@Test(priority = 4)
	public void test5() {
		WebElement addr = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[8]"));
		addr.clear();
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "All textboxes must be filled!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	//name & user null
	@Test(priority = 5)
	public void test6() {
		WebElement name = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[2]"));
    	WebElement user = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[5]"));
		name.clear();
		user.clear();
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "All textboxes must be filled!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	
	//name & tel null
	@Test(priority = 6)
	public void test7() {
		WebElement name = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[2]"));
		WebElement tel = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[7]"));
		name.clear();
		tel.clear();
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "All textboxes must be filled!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	
	//name & addr null
	@Test(priority = 7)
	public void test8() {
		WebElement name = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[2]"));
		WebElement addr = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[8]"));
		name.clear();
		addr.clear();
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "All textboxes must be filled!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	
	//user & tel null
	@Test(priority = 8)
	public void test9() {
		WebElement user = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[5]"));
		WebElement tel = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[7]"));
		user.clear();
		tel.clear();
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "All textboxes must be filled!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	
	//user & addr null
	@Test(priority = 9)
	public void test10() {
		WebElement user = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[5]"));
		WebElement addr = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[8]"));
		user.clear();
		addr.clear();
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "All textboxes must be filled!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	
	//tel & addr null
	@Test(priority = 10)
	public void test11() {
		WebElement tel = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[7]"));
		WebElement addr = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[8]"));
		tel.clear();
		addr.clear();
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "All textboxes must be filled!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	//addr not null
	@Test(priority = 11)
	public void test12() {
		WebElement name = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[2]"));
		WebElement user = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[5]"));
		WebElement tel = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[7]"));
		tel.clear();
		user.clear();
		name.clear();
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "All textboxes must be filled!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	//name not null
	@Test(priority = 12)
	public void test13() {
		WebElement addr = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[8]"));
		WebElement user = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[5]"));
		WebElement tel = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[7]"));
		tel.clear();
		user.clear();
		addr.clear();
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "All textboxes must be filled!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	//user not null
	@Test(priority = 13)
	public void test14() {
		WebElement addr = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[8]"));
		WebElement name = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[2]"));
		WebElement tel = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[7]"));
		tel.clear();
		name.clear();
		addr.clear();
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "All textboxes must be filled!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	//tel not null
	@Test(priority = 14)
	public void test15() {
		WebElement addr = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[8]"));
		WebElement name = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[2]"));
		WebElement user = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[5]"));
		user.clear();
		name.clear();
		addr.clear();
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "All textboxes must be filled!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	//all not null
	@Test(priority = 15)
	public void test16() {
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	//user<6
	@Test(priority = 16)
	public void test17() {
		WebElement user = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[5]"));
		user.clear();
		user.sendKeys("a");
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "Username must have at least 6 characters!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	//user > 6
	@Test(priority = 17)
	public void test18() {
		WebElement user = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[5]"));
		user.clear();
		user.sendKeys("lakeho123");
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	//user = 6
	@Test(priority = 18)
	public void test19() {
		WebElement user = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[5]"));
		user.clear();
		user.sendKeys("laketa");
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	//phone<10
	@Test(priority = 19)
	public void test20() {
		WebElement tel = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[7]"));
		tel.clear();
		tel.sendKeys("123");
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "Số điện thoại không đúng định dạng!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	//phone>11
	@Test(priority = 20)
	public void test21() {
		WebElement tel = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[7]"));
		tel.clear();
		tel.sendKeys("098765432121");
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "Số điện thoại không đúng định dạng!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	//phone khg bat dau bang 0
	@Test(priority = 21)
	public void test22() {
		WebElement tel = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[7]"));
		tel.clear();
		tel.sendKeys("1234567890");
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "Số điện thoại không đúng định dạng!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	//phone chua ky tu khong phai so
	@Test(priority = 22)
	public void test23() {
		WebElement tel = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[7]"));
		tel.clear();
		tel.sendKeys("01234o6789");
		WebElement button = driver.findElement(By.id("nut"));
		button.click();
		String expectedMessage = "Số điện thoại không đúng định dạng!";
		String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
}
