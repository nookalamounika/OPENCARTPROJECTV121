package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


public LoginPage(WebDriver driver) {

super(driver);

}

@FindBy(xpath="//input[@placeholder='E-Mail Address']")
WebElement emailadd;

 @FindBy(xpath="//input[@placeholder='Password']")   
 WebElement passwordd;                                      

@FindBy(xpath="//input[@value='Login'][@type='submit']")
WebElement loginbtn;


public void setemailAdd(String emailAdd) {

emailadd.sendKeys(emailAdd);
}

public void setpassword(String pswd) {    
                                              
passwordd.sendKeys(pswd);                  
}                                             
 public void clickloginbtn() {    
                                               
 loginbtn.click();                 
 }                                             
}
