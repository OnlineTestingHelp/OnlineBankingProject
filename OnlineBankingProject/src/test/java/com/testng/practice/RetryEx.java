package com.testng.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryEx {
	
		int i=1;

		@Test(retryAnalyzer = retry.class)
		public void test() {
			
			if(i<=20) {
				i=i+1;
				Assert.fail();
			}else {
				Assert.assertTrue(true);
			}
			
		}

	}
