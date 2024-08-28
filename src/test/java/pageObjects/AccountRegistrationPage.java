package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

public AccountRegistrationPage(WebDriver driver) { 
super(driver);
}

@FindBy(xpath="//input[@placeholder='First Name']")
WebElement firstname;

@FindBy(xpath="//input[@placeholder='Last Name']") 
WebElement lastname;                               

@FindBy(xpath="//input[@placeholder='E-Mail']") 
WebElement emailname;                               

@FindBy(xpath="//input[@placeholder='Telephone']")
WebElement telephoneno;

@FindBy(xpath="//input[@placeholder='Password']") 
WebElement password;                               

@FindBy(xpath="//input[@placeholder='Password Confirm']")   
WebElement Confirmpassword;                                

@FindBy(xpath="//input[@name='agree']") 
WebElement checkpolicy;                               

@FindBy(xpath="//input[@value='Continue'][@type='submit']") 
WebElement Continuebtn;                               

@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")  
WebElement msgConfirmation;                                      



public void setfirstname(String fname) {

firstname.sendKeys(fname);
}

 public void setlastname(String lname) {    
                                             
 lastname.sendKeys(lname);                  
 }                                           

 public void emailname(String email) {    
                                             
 emailname.sendKeys(email);                  
 }                                           

public void setTelephno(String phno) {
 telephoneno.sendKeys(phno);
}
 public void setpassword(String pwd) {    
                                            
password.sendKeys(pwd);                  
}                                           

 public void setConfirmpassword(String pwd12) {    
                                           
Confirmpassword.sendKeys(pwd12);                    
}                                          
 
 
 
 
 public void checkingpolicy() {    
                                            
checkpolicy.click();                  
}                                           

public void clickcontinuebtn() {    
 //Continuebtn.click();                                           
 Continuebtn.submit();                 


}                                           

public String getConfirmationmsg() {


try {
	return(msgConfirmation.getText());
} catch (Exception e) {
	// TODO Auto-generated catch block
	return(e.getMessage());
}

}






}
