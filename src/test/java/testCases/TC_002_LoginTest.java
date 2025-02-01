package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	
	@Test(groups={"Sanity","Master"})
	public void TestLogin() {
		
		logger.info("******* Starting TC_002_LoginTest **********");
		logger.debug("capturing application debug logs....");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email2"));
			lp.setPassword(p.getProperty("password2"));
			lp.clickLogin();
			
			MyAccountPage myAcc = new MyAccountPage(driver);
			boolean targetPage = myAcc.isMyAccountPageExists();
			Assert.assertEquals(targetPage, true, "Login Failed");
			
			
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("******* Finishing TC_002_LoginTest **********");
	}
	
	
	
	
	
	
}
