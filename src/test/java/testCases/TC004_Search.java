package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;

public class TC004_Search extends BaseClass  {
HomePage hp;
//LoginPage lp;
SearchPage sp;


@Test(groups= {"Master"})
public void searchtheitems() {

HomePage hp = new HomePage(driver);

 hp.enterproductname("iMac");
hp.clickonsearchicon();
 
 sp=new SearchPage(driver);
sp.verifysearchitem("iMac");



}
















}
