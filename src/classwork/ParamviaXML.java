package classwork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamviaXML {
	
	public WebDriver driver;
	String bname = "Firefox";
	String url = "http://automationpractice.com/index.php";
	
	@BeforeClass
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
	
	@Parameters({ "search_string", "user_email"})
	@Test(priority=1)
	public void search(String sstr, String user_email) throws Exception {
		String searchXpath = "//input[@name='search_query']";
		String submitXpath = "//button[@class='btn btn-default button-search'][@name='submit_search']";
		driver.findElement(By.xpath(searchXpath)).click();
		driver.findElement(By.xpath(searchXpath)).sendKeys(sstr);
		Thread.sleep(3000);
		driver.findElement(By.xpath(submitXpath)).click();
		System.out.println(user_email);
	}
	
	
	
	@Test(priority=3)
	public void close() throws Exception {
		Thread.sleep(5000);
		System.out.println("closing browser");
		driver.quit();
	}

}
