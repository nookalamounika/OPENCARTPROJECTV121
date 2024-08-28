package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.Assert;


import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {

@Test(groups={"Regression","Master"})
public void verify_account_registration() {

	logger.info("**************************Starting TC001_AccountRegistrationTest*************************************");
try {
	HomePage hp = new HomePage(driver);
hp.clickmyaccount();

logger.info("********Clicked on MyAccount Link************");

hp.clickRegistration();
logger.info("********Clicked on Registration Link************");
AccountRegistrationPage regpg=new AccountRegistrationPage(driver);

logger.info("********providing customer Details************");

regpg.setfirstname("John");
//random first name
regpg.setfirstname(randomString().toUpperCase());
regpg.setlastname("David");
//random first name                                
regpg.setfirstname(randomString().toUpperCase());  

//regpg.setpassword("912345");
//set password
String password=randomAlphaNumeric();   
regpg.setpassword(password);
regpg.setConfirmpassword(password);

//regpg.setConfirmpassword("912345");
regpg.emailname(randomString()+"@gmail.com");

regpg.setTelephno("9324567889");
//random numbers without giving particular numbers we can excute the program
regpg.setTelephno(randomNumber());  
regpg.checkingpolicy();
regpg.clickcontinuebtn();




logger.info("********Validating Expected message************");

String confmsg=regpg.getConfirmationmsg();
if(confmsg.equals("Your Account Has Been Created!")) {
Assert.assertTrue(true);
}
else {
logger.error("Test failed");  
logger.debug("Debug logs");   
Assert.assertTrue(false);



}

//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
}
catch(Exception e) 
{

Assert.fail();
}
logger.info("***************Finished TC001_AccountRegistrationTest*********************");
}

}












     









