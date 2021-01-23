package classwork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AssertsDemo {
	
	public WebDriver driver;
	String bname = "Firefox";
	String url = "http://automationpractice.com/index.php";
	
	@Test(priority=0)
	public void launchBrowser() throws Exception {
		System.setProperty("webdriver.gecko.driver", ".\\browsers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
			
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
		// Adding assert for Url
		String curl = driver.getCurrentUrl();
		Assert.assertEquals(url, curl, "Urls not matched");
		System.out.println("Urls are matched");
		
		String actTitle=driver.getTitle();
		String expTitle = "MyStore";
		//Assert.assertTrue(actTitle.equalsIgnoreCase(expTitle), "Title mismatch");
		Assert.assertEquals(actTitle, expTitle, "Title mismatch");
		System.out.println("Title matched");
				
	}
	
	@Test(priority=1)
	public void search() throws Exception {
		String searchXpath = "//input[@name='search_query']";
		String submitXpath = "//button[@class='btn btn-default button-search'][@name='submit_search']";
		driver.findElement(By.xpath(searchXpath)).click();
		driver.findElement(By.xpath(searchXpath)).sendKeys("Summer dresses");
		Thread.sleep(3000);
		driver.findElement(By.xpath(submitXpath)).click();
		Thread.sleep(5000);
		boolean dFlag ;
		try {
		 dFlag = driver.findElement(By.xpath("//h1/span[contains(.,'Summer dresses')]")).isDisplayed();
		} catch(Exception e) {
			dFlag = false;
		}
		Assert.assertTrue(dFlag, "Failed to display results");
		System.out.println("Results found");
	}
	
	@Test(priority=2)
	public void create() throws Exception {
		System.out.println("in create");
	}
	@Test(priority=3)
	public void close() throws Exception {
		Thread.sleep(5000);
		System.out.println("closing browser");
		driver.quit();
	}

}
