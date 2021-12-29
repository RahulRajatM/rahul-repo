package com.crm.autodesk.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * @author Rahul
 *
 */
public class ExcelUtility {
	/**
	 * Used to read data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return String 
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis= new FileInputStream("./data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * Used to write data back to excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public void setExcelData(String sheetName,int rowNum,int cellNum,String value) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis= new FileInputStream("./data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).setCellValue(value);
		FileOutputStream fos= new FileOutputStream("./data/TestData.xlsx");
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}
	/**
	 * Set Excel Data in mutliple rows and columns
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @return String
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public String setExcelValue(String sheetName,int rowNum,int cellNum,String value) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis= new FileInputStream("./data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).setCellValue(value);
		FileOutputStream fos= new FileOutputStream("./data/TestData.xlsx");
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
		return value;
	}
	/**
	 * Used to get the last row number in a excel sheet
	 * @param sheetName
	 * @return int
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis= new FileInputStream("./data/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
}
