package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class TC005_CartTest extends BaseClass {
SearchPage sp;
@Test(groups= {"Master"})
public void verify_cartpage() {

  HomePage hp = new HomePage(driver);  
                                       
   hp.enterproductname("iMac");      
  hp.clickonsearchicon();              
                                       
   sp=new SearchPage(driver);          
 sp.verifysearchitem("iMac");       
  sp.clickonaddtocart();            
  
  Assert.assertEquals(sp.productaddeddsuccess(),true);
 
  
  }   



  
  
  
  }


