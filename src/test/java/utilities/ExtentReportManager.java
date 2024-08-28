package utilities;
import java.awt.Desktop;
import java.io.File;                                                     
import java.io.IOException;                                              
import java.text.SimpleDateFormat;                                       
import java.util.Date;
import java.util.List;
import java.net.*;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
//import org.testng.ITestListener;
import org.testng.ITestResult;                                           
//import org.testng.TestListenerAdapter;                                   
                                                                         
import com.aventstack.extentreports.ExtentReports;                       
import com.aventstack.extentreports.ExtentTest;                          
import com.aventstack.extentreports.Status;                              
import com.aventstack.extentreports.markuputils.ExtentColor;             
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;         
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;        
                                                                         
public class ExtentReportManager implements ITestListener {
  public ExtentSparkReporter sparkReporter;                                                                                                                      
  	public ExtentReports extent;                                                                                                                                
  	public ExtentTest test;                                                                                                                                   
  	                                                                                                                                                            
  		                                                                                                                                                           
  	public void onStart(ITestContext testContext)                                                                                                               
  	{                                                                                                                                                           
  		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp                                                             
  		
  		String repName="Test-Report-"+timeStamp+".html";                                                                                                           
  		                                                                                                                                                           
  		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);//specify location of the report                              
  		                                                                         
  		                                                                                                                                                           
  		sparkReporter.config().setDocumentTitle("opencart Automation Report"); // Tile of report    
  		sparkReporter.config().setReportName("opencart Functional Testing"); // name of the report     
  		                                                                                       
  		sparkReporter.config().setTheme(Theme.DARK);                                           
  		
  		extent=new ExtentReports();                                                                                                                                
  		 extent.attachReporter(sparkReporter);                                                                                                                                                         extent.attachReporter(sparkReporter);                                                                                                                       
  		extent.setSystemInfo("Host name","localhost");                                                                                                             
  		extent.setSystemInfo("Application","opencart"); 
  		 extent.setSystemInfo("Operating System",System.getProperty("os.name")); 
  		 extent.setSystemInfo("User Name",System.getProperty("user.name"));  
  		extent.setSystemInfo("Environemnt","QA");                                                                                                                  
  		extent.setSystemInfo("user","mounika");                                                                                                                      
  		                                                                                                                                                           
 String os = testContext.getCurrentXmlTest().getParameter("os");
  extent.setSystemInfo("Operating System", os);	
  	
 String browser = testContext.getCurrentXmlTest().getParameter("browser");        	
  extent.setSystemInfo("Browser", browser);	                        	
  	
  	List<String> includeGroups = testContext.getCurrentXmlTest().getIncludedGroups();      
  	 if(!includeGroups.isEmpty()) {
  	extent.setSystemInfo("Groups", includeGroups.toString());	                       
  	 }
  	
  	}                                                                                                                                                           
  	                                                                                                                                                            
  	public void onTestSuccess(ITestResult result)                                                                                                                   
  	{                                                                                                                                                           
  		test=extent.createTest(result.getTestClass().getName()); // create new entry in th report                                                                                   
  		test.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
  	                           
  	     test.assignCategory(result.getMethod().getGroups());        
  	     test.log(Status.PASS, result.getName()+"got successfully executed");                       
  	 
  	                                                                 
  	
}                                                                                                                                                           
  	                                                                                                                                                            
  	public void onTestFailure(ITestResult result)                                                                                                                   
  	{                                                                                                                                                           
  		test=extent.createTest(result.getTestClass().getName()); // create new entry in th report                                                                                   
  		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted  
  		test.assignCategory(result.getMethod().getGroups());                                                                                                                                                            
  		test.assignCategory(result.getMethod()+"got failed");
  		test.log(Status.FAIL,result.getThrowable().getMessage());
  
  	
  	try {
  	
  	String imgPath=new BaseClass().captureScreen(result.getName());
  	test.addScreenCaptureFromPath(imgPath);
  	}
  	catch(IOException el){
  	el.printStackTrace();
  	
  	}
  	
  	}
  		
                                                                                                                                                            
  	                                                                                                                                                            
  	public void onTestSkipped(ITestResult result)                                                                                                                   
  	{                                                                                                                                                           
  		test=extent.createTest(result.getTestClass().getName()); // create new entry in th report                                                                                   
  		test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));                                                                         
  	    test.assignCategory(result.getMethod().getGroups());        
  	    test.log(Status.SKIP, result.getName()+ "Test skipped");                       
  	    test.log(Status.SKIP, result.getThrowable().getMessage());
  	                                                                
  	
  	
  	}                                                                                                                                                           
  	                                                                                                                                                            
  	public void onFinish(ITestContext testContext)                                                                                                              
  	{                                                                                                                                                           
  		extent.flush();                                                                                                                                            
  	
  	/*String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+"repName";
  		
  	File extentReport = new File(pathOfExtentReport);
  	
  	try {
  	
  	Desktop.getDesktop().browse(extentReport.toURI());
  	}
  	catch(IOException e) {
  	e.printStackTrace();
  	
  	}*/
  	
  //send the report to team by email	
  	
 /* try {	
  	URL url = new URL("C:\\Users\\user\\eclipse-workspace\\OPENCARTPROJECTV121\\reports\\repName");
  	
  	//create the email message
  	
  	ImageHtmlEmail email = new ImageHtmlEmail();
  	
  	email.setDataSourceResolver(new DataSourceUrlResolver(url));
  	email.setHostName("smtp.googleemail.com");
  	email.setSmtpPort(465);
  	email.setAuthenticator(new DefaultAuthenticator("mounikanookala28@gmail.com","password"));
  	email.setSSLOnConnect(true);
  	email.setSubject("Test Results");
  	email.setMsg("Please Find attached Report");
  	email.addTo("mounikanookala18@gmail.com");//receiver
  	email.attach(url, "extent report", "please check report");
  	email.send();//send to email
  }
  	catch(Exception e) {
  	
  	e.printStackTrace();
  	}
  	}
  	  */                                                                                                                                                         
  } 
}