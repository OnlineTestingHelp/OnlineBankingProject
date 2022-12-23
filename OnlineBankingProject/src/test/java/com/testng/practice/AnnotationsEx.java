package com.testng.practice;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AnnotationsEx {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@Test(description = "This is first case",priority = 1, invocationCount = 10, groups ={"Regression","Smoke"})
	public void dtest1() {
		System.out.println("Test Case 1");
	}
	
	@Test(description = "This is second test case", groups ={"Smoke"})
	public void ctest2() {
		System.out.println("Test Case 2");
	}
	
	@Test(description = "This is Third case",priority = 2, groups ={"Sanity"})
	public void btest3() {
		System.out.println("Test Case 3");
		//Assert.assertTrue(false, "Testcase is Failed");
		
		SoftAssert ass = new SoftAssert();
		ass.assertTrue(false, "This test case is failed");
		
		System.out.println("TestCase3::This is after assert");
	}
	
	@Test(description = "This is fourth test case",priority = -1, groups ={"Regression"})
	public void atest4() {
		System.out.println("Test Case 4");
		
		Assert.assertTrue(true, "Testcase is Passed");
		
		System.out.println("Testcase4:: This is after assert");
	}
	
	@Test(description = "This is fifth test case",priority = -1, dependsOnMethods = {"atest4"}, groups ={"Regression"})
	public void atest5() {
		System.out.println("Test Case 5");
		
		Assert.assertTrue(true, "Testcase is Passed");
		
		System.out.println("Testcase4:: This is after assert");
	}

}
