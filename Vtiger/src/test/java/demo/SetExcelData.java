package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SetExcelData {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {

		// create java object representation of physical file
		FileInputStream fis= new FileInputStream("./data/TestData.xlsx");
		//load file into program
		Workbook wb = WorkbookFactory.create(fis);
		//read data
		wb.getSheet("org").getRow(0).getCell(0).setCellValue("TestNo");
		//create file representation of java Object to write into physical file 
		FileOutputStream fos= new FileOutputStream("./data/TestData.xlsx");
		wb.write(fos);
		wb.close();	
	}
}
