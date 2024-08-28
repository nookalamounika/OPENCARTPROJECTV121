package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {


public HomePage(WebDriver driver) {

super(driver);


}



@FindBy(xpath="//span[normalize-space()='My Account']")
WebElement myaccountlink;

@FindBy(xpath="//a[text()='Register']")
WebElement Registerlink;


@FindBy(xpath="//a[text()='Login']")
WebElement Loginlink;



public void clickmyaccount() {

myaccountlink.click();

}
public void clickRegistration() {

Registerlink.click();
}


public void clickloginlink() {


Loginlink.click();

}







}
