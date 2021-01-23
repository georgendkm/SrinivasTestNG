package classwork;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupingDemo {
	
	@BeforeGroups("sanity")
	public void bg() {
		System.out.println("before group sanity");
	}
	@BeforeGroups("regression")
	public void bg2() {
		System.out.println("before group regression");
	}
	
	@AfterGroups({"regression", "sanity"})
	public void ag() {
		System.out.println("after group regresion");
	}
	
	
	@Test(priority=1, groups = { "sanity", "regression"})
	public void launch() {
		System.out.println("Launch Browswer");
	}
	
	@Test(priority=2, groups = { "sanity"})
	public void search() {
		System.out.println("search dresses");
	}
	
	@Test(priority=3, groups = { "regression"})
	public void createUser() {
		System.out.println("Create user");
	}
	
	@Test(priority=4, groups = { "regression"})
	public void removeUser() {
		System.out.println("Remove an existing user");
	}

	@Test(priority=5, groups = { "sanity", "regression"})
	public void addItem() {
		System.out.println("add ite to shopping cart");
	}
	
	@Test(priority=6, groups = { "sanity", "regression"})
	public void checkout() {
		System.out.println("checkout items");
	}
	
	@Test(priority=7, groups = { "sanity", "regression"})
	public void logoutAndClose() {
		System.out.println("Logout and close");
	}
	
	
	@Test(priority=8)
	public void tc8() {
		System.out.println("tc8");
	}
}
