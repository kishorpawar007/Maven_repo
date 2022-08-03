package maven_package.Conversion_to_maven_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBSignInWithMobNumPage {
	//step1
	@FindBy(xpath="(//input[@type='number'])[2]") private WebElement mobNum;
	@FindBy(xpath="(//a[@class='cl-btn sr-btn-primary-outline central-login-sign-in-with-password-calss'])[2]") private WebElement signInWithPwd;
	
	//step2
	public PBSignInWithMobNumPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//step3
	public void setPBSignInWithMobNummobNum(String mobNumber) {
		mobNum.sendKeys(mobNumber);
	}
	
	public void clickPBSignInWithMobNumPageSignInWithPwd() {
		signInWithPwd.click();
	}
	

}
