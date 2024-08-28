package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

/*Data is valid-login success-test pass-logout
 * Data is valid --login failed--test fail
 * 
 * Data is Invalid-login success-test fail-logout 
 *  Data is Invalid --login failed--test pass     
 * 
 * 
 * 
 * 
 * 
 * 
 * */


public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven")//getting data provider from different classes so we ude dataproviderclass
public void verify_loginDDT(String email,String pwd,String exp) {

logger.info("***************Starting the TC003_LoginDDT*************************");
		
		
		
		
try {		
		//homepage                                                   
HomePage hp= new HomePage(driver);                           
                                                             
hp.clickmyaccount();                                         
hp.clickloginlink();                                         
                                                             
//login page                                                 
LoginPage lp = new LoginPage(driver);                        
lp.setemailAdd(email);                      
lp.setpassword(pwd);                   
lp.clickloginbtn();                                          
                                                             
//my account page                                            
MyAccountPage macc= new MyAccountPage(driver);               
boolean targetpage=macc.headerdisplay();                     

if(exp.equalsIgnoreCase("Valid")) {

if(targetpage==true) {
macc.clickonlogoutlink();
	
	Assert.assertTrue(true);

}
else {
Assert.assertTrue(false);

}
}

if(exp.equalsIgnoreCase("Invalid")) {      
                                         
if(targetpage==true) {                   
macc.clickonlogoutlink();                
	                                     
	Assert.assertTrue(false);             
                                         
}                                        
else {                                   
Assert.assertTrue(true);                
                                         
}                                        
}                                        
}catch(Exception e) {
Assert.fail();

	
}	
	
logger.info("***************Finished the TC003_LoginDDT*************************");   

}
}