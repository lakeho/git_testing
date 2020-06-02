package autotest;

import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class loginTest {
	
	public String baseUrl = "http://localhost:8080/login";
	String driverPath = "E:\\FPoly\\geckodriver.exe";
	public WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		System.out.println("launching firefox browser"); 
	    System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("closing firefox browser"); 
		driver.close();
		System.out.println("firefox browser closed"); 
	}
	
    @Test
    public void test1() {
    	driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[1]")).sendKeys("as");
    	driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[2]")).sendKeys("1345");
    	driver.findElement(By.xpath("//*[@id=\"logbtn\"]")).click();
    	String expectMessage = "Incorrect username!";
    	String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p[1]")).getText();
    	Assert.assertEquals(actualMessage, expectMessage);
    }
    
    @Test
    public void test2() {
    	driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[1]")).sendKeys("laketa");
    	driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[2]")).sendKeys("1345");
    	driver.findElement(By.xpath("//*[@id=\"logbtn\"]")).click();
    	String expectMessage = "Incorrect passwords!";
    	String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p[1]")).getText();
    	Assert.assertEquals(actualMessage, expectMessage);
    }
    
    @Test
    public void test3() {
    	driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[1]")).sendKeys("");
    	driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[2]")).sendKeys("");
    	driver.findElement(By.xpath("//*[@id=\"logbtn\"]")).click();
    	String expectMessage = "Both username and password must be filled";
    	String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p[1]")).getText();
    	Assert.assertEquals(actualMessage, expectMessage);
    }
    
    @Test
    public void test4() {
    	driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[1]")).sendKeys("anhht");
    	driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[2]")).sendKeys("");
    	driver.findElement(By.xpath("//*[@id=\"logbtn\"]")).click();
    	String expectMessage = "Both username and password must be filled";
    	String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p[1]")).getText();
    	Assert.assertEquals(actualMessage, expectMessage);
    }
    
    @Test
    public void test5() {
    	driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[1]")).sendKeys("");
    	driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[2]")).sendKeys("123456");
    	driver.findElement(By.xpath("//*[@id=\"logbtn\"]")).click();
    	String expectMessage = "Both username and password must be filled";
    	String actualMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/p[1]")).getText();
    	Assert.assertEquals(actualMessage, expectMessage);
    }
    
    @Test
    public void test6() {
    	driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[1]")).sendKeys("anhht");
    	driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/input[2]")).sendKeys("123456");
    	driver.findElement(By.xpath("//*[@id=\"logbtn\"]")).click();
    }
}
