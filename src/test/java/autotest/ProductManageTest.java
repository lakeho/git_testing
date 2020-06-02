package autotest;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class ProductManageTest {
	public String baseUrl = "http://localhost:8080/adminLogin";
	String driverPath = "E:\\FPoly\\geckodriver.exe";
	public WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		System.out.println("launching firefox browser"); 
	    System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[1]")).sendKeys("admin");
    	driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[2]")).sendKeys("admin");
    	driver.findElement(By.xpath("//*[@id=\"logbtn\"]")).click();
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("closing firefox browser"); 
		driver.close();
		System.out.println("firefox browser closed"); 
	}
	
	//trung ten sp; all filled
	@Test(priority=0)
	public void test1() {
		WebElement addButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[1]"));
		addButton.click();
		String expected = "This product has already existed!";
		String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
		Assert.assertEquals(actual, expected);
	}
	
	//null ten/add
	@Test(priority=1)
	public void test2() {
		WebElement nameText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[1]"));
		nameText.clear();
		WebElement addButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[1]"));
		addButton.click();
		String expected = "Product name and price must be filled";
		String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
		Assert.assertEquals(actual, expected);
	}
	
	//null gia/add
	@Test(priority=2)
	public void test3() {
		WebElement priceText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[4]"));
		priceText.clear();
		WebElement addButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[1]"));
		addButton.click();
		String expected = "Product name and price must be filled";
		String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
		Assert.assertEquals(actual, expected);
	}
	
	//null anh/add
	@Test(priority=3)
	public void test4() {
		WebElement imgText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[5]"));
		imgText.clear();
		WebElement addButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[1]"));
		addButton.click();
		String expected = "This product has already existed!";
		String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
		Assert.assertEquals(actual, expected);
	}
	
	//null anh & gia/add
		@Test(priority=4)
		public void test5() {
			WebElement imgText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[5]"));
			WebElement priceText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[4]"));
			imgText.clear();
			priceText.clear();
			WebElement addButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[1]"));
			addButton.click();
			String expected = "Product name and price must be filled";
			String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
			Assert.assertEquals(actual, expected);
		}
		
		//null anh & ten/add
		@Test(priority=6)
		public void test7() {
			WebElement imgText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[5]"));
			WebElement nameText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[1]"));
			imgText.clear();
			nameText.clear();
			WebElement addButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[1]"));
			addButton.click();
			String expected = "Product name and price must be filled";
			String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
			Assert.assertEquals(actual, expected);
		}
		
		//null gia & ten/add
		@Test(priority=7)
		public void test8() {
			WebElement priceText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[4]"));
			WebElement nameText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[1]"));
			priceText.clear();
			nameText.clear();
			WebElement addButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[1]"));
			addButton.click();
			String expected = "Product name and price must be filled";
			String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
			Assert.assertEquals(actual, expected);
		}
		
		//null all/update
		@Test(priority=8)
		public void test9() {
			WebElement imgText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[5]"));
			WebElement priceText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[4]"));
			WebElement nameText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[1]"));
			imgText.clear();
			priceText.clear();
			nameText.clear();
			WebElement addButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[1]"));
			addButton.click();
			String expected = "Product name and price must be filled";
			String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
			Assert.assertEquals(actual, expected);
		}
		
		//gia la so am
		@Test(priority=9)
		public void test10() {
			WebElement priceText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[4]"));
			priceText.clear();
			priceText.sendKeys("-120000");
			WebElement addButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[1]"));
			addButton.click();
			String expected = "Do you even know what price is..?";
			String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
			Assert.assertEquals(actual, expected);
		}
		
		//gia co ky tu dac biet hoac chu
		@Test(priority=10)
		public void test11() {
			WebElement priceText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[4]"));
			priceText.clear();
			priceText.sendKeys("12o@000");
			WebElement addButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[1]"));
			addButton.click();
			String expected = "Do you even know what price is..?";
			String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
			Assert.assertEquals(actual, expected);
		}
		//-------------------------------------------------------------------------------
		
		//null ten/update
		@Test(priority=11)
		public void test12() {
			WebElement nameText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[1]"));
			nameText.clear();
			WebElement updateButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[2]"));
			updateButton.click();
			String expected = "Product name and price must be filled";
			String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
			Assert.assertEquals(actual, expected);
		}
		
		//null gia/update
		@Test(priority=12)
		public void test13() {
			WebElement priceText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[4]"));
			priceText.clear();
			WebElement updateButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[2]"));
			updateButton.click();
			String expected = "Product name and price must be filled";
			String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
			Assert.assertEquals(actual, expected);
		}
		
		//null anh/udpdate
		@Test(priority=13)
		public void test14() {
			WebElement imgText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[5]"));
			imgText.clear();
			WebElement updateButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[2]"));
			updateButton.click();
			String expected = "";
			String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
			Assert.assertEquals(actual, expected);
		}
		
		//null anh & gia/update
			@Test(priority=14)
			public void test15() {
				WebElement imgText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[5]"));
				WebElement priceText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[4]"));
				imgText.clear();
				priceText.clear();
				WebElement updateButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[2]"));
				updateButton.click();
				String expected = "Product name and price must be filled";
				String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
				Assert.assertEquals(actual, expected);
			}
			
			//null anh & ten/update
			@Test(priority=16)
			public void test17() {
				WebElement imgText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[5]"));
				WebElement nameText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[1]"));
				imgText.clear();
				nameText.clear();
				WebElement updateButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[2]"));
				updateButton.click();
				String expected = "Product name and price must be filled";
				String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
				Assert.assertEquals(actual, expected);
			}
			
			//null gia & ten/up
			@Test(priority=17)
			public void test18() {
				WebElement priceText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[4]"));
				WebElement nameText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[1]"));
				priceText.clear();
				nameText.clear();
				WebElement updateButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[2]"));
				updateButton.click();
				String expected = "Product name and price must be filled";
				String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
				Assert.assertEquals(actual, expected);
			}
			
			//null all
			@Test(priority=18)
			public void test19() {
				WebElement imgText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[5]"));
				WebElement priceText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[4]"));
				WebElement nameText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[1]"));
				imgText.clear();
				priceText.clear();
				nameText.clear();
				WebElement updateButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[2]"));
				updateButton.click();
				String expected = "Product name and price must be filled";
				String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
				Assert.assertEquals(actual, expected);
			}
			
			//gia la so am
			@Test(priority=19)
			public void test20() {
				WebElement priceText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[4]"));
				priceText.clear();
				priceText.sendKeys("-120000");
				WebElement updateButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[2]"));
				updateButton.click();
				String expected = "Do you even know what price is..?";
				String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
				Assert.assertEquals(actual, expected);
			}
			
			//gia co ky tu dac biet hoac chu
			@Test(priority=20)
			public void test21() {
				WebElement priceText = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input[4]"));
				priceText.clear();
				priceText.sendKeys("12o@000");
				WebElement updateButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/button[2]"));
				updateButton.click();
				String expected = "Do you even know what price is..?";
				String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/p")).getText();
				Assert.assertEquals(actual, expected);
			}
}
