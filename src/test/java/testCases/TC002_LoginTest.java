package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {
@Test(groups={"Sanity" , "Master"})
public void verify_login() {

logger.info("**********Starting TC002_LoginTest**************");
try {
//homepage
HomePage hp= new HomePage(driver);

hp.clickmyaccount();
hp.clickloginlink();

//login page
LoginPage lp = new LoginPage(driver);
lp.setemailAdd(p.getProperty("email"));
lp.setpassword(p.getProperty("password"));
lp.clickloginbtn();

//my account page
MyAccountPage macc= new MyAccountPage(driver);
boolean targetpage=macc.headerdisplay();

Assert.assertEquals(targetpage, true,"Login failed");
Assert.assertTrue(targetpage);
}
catch(Exception e)
{
Assert.fail();
}
logger.info("********Finished TC002_LoginTest***************");
}














}
