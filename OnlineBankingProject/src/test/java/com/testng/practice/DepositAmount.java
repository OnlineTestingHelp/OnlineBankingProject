package com.testng.practice;

import org.testng.annotations.Test;

public class DepositAmount {

	
	@Test
	public void test() {
		String amount = "101000.00";
		
		//String[] am = amount.split(".");
		
		int value = Double.valueOf(amount).intValue();;
		System.out.println(value);
	}
}
