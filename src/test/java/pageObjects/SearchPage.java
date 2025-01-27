package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

//constructor
public SearchPage(WebDriver driver) {

super(driver);

}

////input[@placeholder='Search']
 //button[@type='button']


@FindBy(xpath="//input[@value='iMac'][@placeholder='Search']")
WebElement verifysearch;

 //span[@class='hidden-xs hidden-sm hidden-md'][normalize-space()='Add to Cart'][@xpath='1']
@FindBy(xpath="//span[normalize-space()='Add to Cart']")
WebElement addtocart;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement successmsg;

public boolean verifysearchitem(String msg) {

return verifysearch.isDisplayed();

}


public void clickonaddtocart() {

addtocart.click();


}


public boolean productaddeddsuccess() {

return successmsg.isDisplayed();


}

}
