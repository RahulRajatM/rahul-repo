package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAllExcelData {

	public static void main(String[] args) throws Exception {


		// create java object representation of physical file
		FileInputStream fis= new FileInputStream("./data/TestData.xlsx");
		//load file into program
		Workbook wb = WorkbookFactory.create(fis);
		//get last row and cell num
		int lastRow = wb.getSheet("org").getLastRowNum();
		System.out.println(lastRow);
		//read data
		for(int i=0;i<=lastRow;i++)
		{
			int lastCell = wb.getSheet("org").getRow(i).getLastCellNum();
			for(int j=0;j<lastCell;j++)
			{
				String data = wb.getSheet("org").getRow(i).getCell(j).getStringCellValue();
				System.out.print(data+" ");
			}
			System.out.println();
		}
	}
}
