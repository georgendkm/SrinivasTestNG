package classwork;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterAnnotationsDemo {
	
	@BeforeClass
	public void bc() {
		System.out.println("In before class");
	}
	
	@AfterClass
	public void ac() {
		System.out.println("In after class");
	}
	
	@BeforeMethod
	public void bm() {
		System.out.println("In before method");
		//Assert.fail();
	}

	@AfterMethod
	public void am() {
		System.out.println("In after method");
	}
	
	@Test(priority=1)
	public void login() {
		System.out.println(" In login");
	}
	
	@Test(priority=3)
	public void search() {
		System.out.println(" In Search");
		Assert.fail();
	}
	
	@Test(priority=5)
	public void createUser() {
		System.out.println(" In createUser");
	}
	

}
