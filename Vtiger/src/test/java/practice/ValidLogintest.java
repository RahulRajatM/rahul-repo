package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;

public class ValidLogintest {
	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		String url = fLib.getPropertyValue("url");
		String un=fLib.getPropertyValue("username");
		String pw=fLib.getPropertyValue("password");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverUtility wLib= new WebDriverUtility();
		wLib.waitForPageToLoad(driver);
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.login(un, pw);
	}
}
