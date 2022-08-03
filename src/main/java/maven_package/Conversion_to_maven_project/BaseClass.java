package maven_package.Conversion_to_maven_project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public WebDriver driver;

	public void initializeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kishor.DESKTOP-V5NCMV5\\eclipse-workspace\\26March Selenium\\Browser files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.policybazaar.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
}
