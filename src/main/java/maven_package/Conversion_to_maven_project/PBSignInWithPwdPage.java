package maven_package.Conversion_to_maven_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBSignInWithPwdPage {

	@FindBy(xpath="//input[@type='password']") private WebElement pwd;
	@FindBy(xpath="//a[@class='cl-btn sr-btn-primary']") private WebElement signIn;

	public PBSignInWithPwdPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setPBSignInWithPwdPagePwd(String password) {
		pwd.sendKeys(password);
	}
	
	public void clickPBSignInWithPwdPageSignIn() {
		signIn.click();
	}
}
