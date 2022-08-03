package maven_package.Conversion_to_maven_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBLoginPage {

	//step1: declaring web element as private variable with FindBy annotation.
	@FindBy(xpath="//a[text()='Sign in']") private WebElement SignIn;
	//FindBy annotation does the conversion on getting driver object through page factory class and converts above sentence as:  
	//private WebElement SignIn=driver.findElement(By.xpath("//a[text()='Sign in']"));
	
	@FindBy(xpath="(//a[@class='signed signed-desk'])[1]")private WebElement myAcc;
	
	WebDriver driver1;
	
	//Step 2: Initializing private variable inside constructor
	public PBLoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		driver1 = driver;
	}
	
	//Step 3: Utilization of variable inside public method
	
	public void clickPBLoginPageSignIn() {
		SignIn.click();
	}
	
	public void mouseHoverPBLoginPageMyAccount() {
		Actions act = new Actions(driver1);
		act.moveToElement(myAcc).perform();
		
	}
}
