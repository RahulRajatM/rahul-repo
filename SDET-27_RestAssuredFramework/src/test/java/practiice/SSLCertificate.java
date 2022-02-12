package practiice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSLCertificate {

	@Test
	public void acceptSSLCert()
	{
		WebDriverManager.chromedriver().setup();

		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setAcceptInsecureCerts(true);

		ChromeOptions option= new ChromeOptions();
		option.merge(dc);
		option.addArguments("--INCOGNITO");
		option.addArguments("--start-maximized");
		WebDriver driver= new ChromeDriver(option);
		driver.get("https://expired.badssl.com/");



	}
}
