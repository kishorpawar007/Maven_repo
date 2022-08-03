package maven_package.Conversion_to_maven_project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PBLoginTest extends BaseClass {
	
	Sheet sh;                  //declared globally
	PBLoginPage login;
	PBSignInWithMobNumPage MobNum;
	PBSignInWithPwdPage pwd;
	PBMyAccountPage mypro;
	PBProfilePage profile;
	int TCID;
	
		@BeforeClass
		public void openBrowser() throws EncryptedDocumentException, IOException {
		initializeBrowser();      // mtd from base class which has browser open code.
		
		login = new PBLoginPage(driver);
		MobNum = new PBSignInWithMobNumPage(driver);
		pwd = new PBSignInWithPwdPage(driver);
		mypro = new PBMyAccountPage(driver);
		profile = new PBProfilePage(driver);
		}
		
		@BeforeMethod
		public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException {
		login.clickPBLoginPageSignIn();
		MobNum.setPBSignInWithMobNummobNum(UtilityClass.getPFData("MobNum"));
		MobNum.clickPBSignInWithMobNumPageSignInWithPwd();
		Thread.sleep(2000);
		pwd.setPBSignInWithPwdPagePwd(UtilityClass.getPFData("PWD"));
		Thread.sleep(2000);
		pwd.clickPBSignInWithPwdPageSignIn();
		Thread.sleep(2000);
		}
		
		@Test
		public void verifyUserID() throws InterruptedException, EncryptedDocumentException, IOException {
		TCID=101;
		login.mouseHoverPBLoginPageMyAccount();
	    mypro.clickPBMyAccountPageMyProfile();
	    profile.switchToChildWindow();
        String actProName = profile.getPBProfilPageProfileName();
	 	String expProName = UtilityClass.getTD(1, 3);      //here we have given wrong input(i.e. 2nd value as 2) so test case fail and  @AfterMethod annotation mtd executes and takes Screenshot of failed webpage where test case failed.
	 	Assert.assertEquals(actProName, expProName, "Failed due to expected not equal to actual profile name");
		}
		
		@AfterMethod
		public void logoutFromApp(ITestResult result) throws IOException {
          
			if(result.getStatus()==ITestResult.FAILURE) {
				UtilityClass.captureScreenShot(driver, TCID);
			}
			
		}
		
		@AfterClass
		public void closeBrowser() {
			driver.quit();
		}
	}

