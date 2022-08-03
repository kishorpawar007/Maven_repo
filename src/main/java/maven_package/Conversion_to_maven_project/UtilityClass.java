package maven_package.Conversion_to_maven_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {

	//Author: Kishor Pawar
	//This method is used to get Test Data from Excel Sheet
	//Need to pass 2 inputs to below mtd i.e. 1. rowIndex, 2. colIndex
	public static String getTD(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\Kishor.DESKTOP-V5NCMV5\\eclipse-workspace\\26March Selenium\\Test Data\\Test data excel Insurance data.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		
		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		return value;
		}
	//Author: Kishor Pawar
	//This method is used to capture screenshot of webpage
	//Need to pass 2 inputs 1. WebDriver object, 2. TCID
	public static void captureScreenShot(WebDriver driver, int TCID) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Kishor.DESKTOP-V5NCMV5\\eclipse-workspace\\26March Selenium\\Screenshots\\TestCaseID"+TCID+".jpg");
        FileHandler.copy(src, dest);	
	}
	
	//Author: Kishor Pawar
	//This method is used to load property file and get data from it.
	//Need to pass one input i.e. key so that we gets its value
	public static String getPFData(String key) throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\Kishor.DESKTOP-V5NCMV5\\eclipse-workspace\\26March Selenium\\propertyFile.properties");
		Properties p = new Properties();
		p.load(file);
		String value = p.getProperty(key);
		return value;
	}
}
