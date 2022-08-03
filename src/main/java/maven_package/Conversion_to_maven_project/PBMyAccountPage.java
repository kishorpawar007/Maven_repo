package maven_package.Conversion_to_maven_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBMyAccountPage {

	@FindBy(xpath="//span[text()=' My profile ']") private WebElement myProfile;
	
	public PBMyAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickPBMyAccountPageMyProfile() {
		myProfile.click();
	}
}
