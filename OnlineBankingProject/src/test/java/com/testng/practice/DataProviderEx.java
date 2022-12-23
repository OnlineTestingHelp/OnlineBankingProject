package com.testng.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx {
	
	
	@Test(dataProvider = "addition")
	public void addition(int a, int b, int c) {
		int result = a+b;
		Assert.assertEquals(result, c);
	}
	
	@DataProvider(name="add")
	public Object[][] data(){
		Object[][] obj = {{1,2,3},{4,5,9},{7,8,15},{9,8,17},{1,2,3},{4,5,9},{7,8,15},{9,8,15}};

//		obj[0][0] = 1;
//		obj[0][1] = 2;
//		obj[0][2] = 3;
//				
//		obj[1][0] = 10;
//		obj[1][1] = 20;
//		obj[1][2] = 30;
//		
//		obj[2][0] = 11;
//		obj[2][1] = 22;
//		obj[2][2] = 33;
//		
//		obj[3][0] = 15;
//		obj[3][1] = 25;
//		obj[3][2] = 40;
//		
//		obj[4][0] = 111;
//		obj[4][1] = 222;
//		obj[4][2] = 333;
//		
//		obj[5][0] = 1111;
//		obj[5][1] = 2222;
//		obj[5][2] = 3333;
		
		
		return obj;
		
	}
	
	@DataProvider(name="addition")
	public Object[][] dataRead() throws IOException{
		
		File file = new File("C:\\Users\\Krish Soft\\Desktop\\Excel\\TestData.xlsx");
		
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("Data");
		
		int rows =  sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] obj = new Object[rows-1][cols];
		
		for(int i=1;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				obj[i-1][j] =(int) sheet.getRow(i).getCell(j).getNumericCellValue();
			}
		}
		
		return obj;
		
	}

}
