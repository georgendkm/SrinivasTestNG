package classwork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnotationDemo {


//	@Test(priority=1, description="Logging into an application")
//	public void testcase1() {
//		System.out.println("In test 1");
//		//
//	}
//	
//	
//	@Test(priority=5, enabled=false)
//	public void testcase2() {
//		Assert.fail();
//		System.out.println("In test 2");
//	}
//	
//	@Test(priority=10, invocationCount=5, 	invocationTimeOut=10000)
//	public void testcase3() throws Exception {
//		System.out.println("In test 3");
//		Thread.sleep(5000);
//	}
//	
//	@Test(priority=15)
//	public void testcase4() {
//		System.out.println("In test 4");
//	}
//	
//	@Test(priority=20, timeOut=3000)
//	public void testcase0() throws Exception {
//		System.out.println("In test 0");
//		Thread.sleep(5000);
//	}
	
	public WebDriver driver;
	public String bname="firefox";
	public String url = "http://automationpractice.com/index.php";
	
	@Test(priority=1)
	public void launchBrowser() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumTraining\\softwares\\driverexes\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\softwares\\driverexes\\chromedriver.exe");
			
		if(bname.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);

	}
	
	@BeforeSuite
	public void bs() {
		System.out.println("In before suite of Test Anno class");
	}
	
	@BeforeTest
	public void bt() {
		System.out.println("In before test of Test Anno class");
	}
	
	@Test(priority=3, dependsOnMethods= {"launchBrowser"})
	public void search() throws Exception {
		String searchXpath = "//input[@name='search_query']";
		String submitXpath = "//button[@class='btn btn-default button-search'][@name='submit_search']";
		driver.findElement(By.xpath(searchXpath)).click();
		driver.findElement(By.xpath(searchXpath)).sendKeys("Winter dresses");
		Thread.sleep(3000);
		driver.findElement(By.xpath(submitXpath)).click();
	}
	
	@Test(priority=5, dependsOnMethods= {"launchBrowser", "search"}, alwaysRun=true)
	public void createUser() {
		System.out.println("crate user");
		Assert.fail();
	}
	
	@Test(priority=7)
	public void signout() {
		System.out.println("sign out");
		
	}

}
