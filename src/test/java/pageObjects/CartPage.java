package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

public CartPage(WebDriver driver) {
super(driver);
}
@FindBy(xpath="//input[@name='quantity[221388]'][1]")        
WebElement quantity;                                         
                                                             
                                                             
@FindBy(xpath="//a[text()='Checkout']")                      
WebElement checkout;                                         
                                                             
public void enterquantity() {                                
                                                             
quantity.sendKeys("2");                                      
                                                             
}                                                            
                                                             
public void clickoncheckout() {                              
                                                             
                                                             
checkout.click();                                            
                                                             
}                                                            
                                                             }
