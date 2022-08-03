package maven_package.Conversion_to_maven_project;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBProfilePage {

	@FindBy(xpath="//div[@class='sc-ckVGcZ kWpXlQ']") private WebElement profileName;
	WebDriver driver1;
	
	public PBProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver1=driver;
	}
	
	public void switchToChildWindow() {
		Set<String> allIds = driver1.getWindowHandles();
		ArrayList<String> ar = new ArrayList<String>(allIds);
		 String cwadd = ar.get(1);
		 driver1.switchTo().window(cwadd);
	}
	
	
	
//	public void verifyPBProfilePageProfileName(String expectedPN) {
//		String actproname = profileName.getText();
//		
//		String expproname = expectedPN;
//		
//		
//		
//		if(actproname.equals(expproname)) {
//			System.out.println("Test case Pass");
//		}
//		
//		else {
//			System.out.println("Test case Fail");
//		}
//	}
	
	public String getPBProfilPageProfileName() {
		String actPN = profileName.getText();
	    return actPN;
	}
}
