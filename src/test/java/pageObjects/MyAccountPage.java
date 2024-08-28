package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

public MyAccountPage(WebDriver driver) {

super(driver);

}

@FindBy(xpath="//h2[text()='My Account']")
WebElement myaccpage;

@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
WebElement logoutlink;


public boolean headerdisplay() {
//myaccpage.getText();
try {
	return(myaccpage.isDisplayed());
} catch (Exception e) {
	// TODO Auto-generated catch block
	return false;
}
}
public void clickonlogoutlink() {

logoutlink.click();
}

}






