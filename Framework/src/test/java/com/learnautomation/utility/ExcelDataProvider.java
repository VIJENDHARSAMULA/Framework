package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider() {

		File file = new File("./TestData/Data.xlsx");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Not able to read the excel data" + e.getMessage());
		}

	}
	
	
	public String getStringData(int sheetIndex,int rowNum,int colNum) {
		
		return wb.getSheetAt(sheetIndex).getRow(rowNum).getCell(colNum).getStringCellValue();
		
	}
	
	
	public String getStringData(String sheetName,int rowNum,int colNum) {
		
		return wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
		
	}
	
	public  double  getNumericData(String sheetName,int rowNum,int colNum) {
		
		return wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getNumericCellValue();
		
	}
	
	
	

}
