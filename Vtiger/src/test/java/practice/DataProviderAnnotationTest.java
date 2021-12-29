package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.JavaUtility;

public class DataProviderAnnotationTest {
	@Test
	public void setExcelData() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Object[][] objArr= new Object[5][3];
		JavaUtility jLib= new JavaUtility();
		ExcelUtility eLib= new ExcelUtility();
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<3;j++)
			{
				int num = jLib.getRandomNumber();
				objArr[i][j]=eLib.setExcelValue("Data", i, j, "data"+num);
			}
		}
		System.out.println("Data Added");
	}

	@Test(dataProvider = "getExcelData")
	public void readDataFromDataProvider(String n1, String n2, String n3)
	{
		System.out.println(n1+"==>"+n2+"==>"+n3);
	}	
	@DataProvider
	public Object[][] getExcelData() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Object[][] objArr= new Object[5][3];
		ExcelUtility eLib= new ExcelUtility();
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<3;j++)
			{
				objArr[i][j]=eLib.getExcelData("Data", i, j);
			}
		}
		return objArr;
	}



}
