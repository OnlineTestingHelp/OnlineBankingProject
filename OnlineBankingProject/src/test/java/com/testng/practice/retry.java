package com.testng.practice;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry implements IRetryAnalyzer{
private int retryCount = 1;
private int maxRetryCount = 30;
public boolean retry(ITestResult result)
 {

   if(retryCount < maxRetryCount)
    { 
	   retryCount++; 
	   return true; 
	} 
   return false; 
  } 
} 

