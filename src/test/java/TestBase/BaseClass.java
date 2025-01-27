package TestBase;

import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;//log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
/*reusability.
 *duplicates will remove 
 * 
 * */
  public static WebDriver driver;//2 drives created,1.is base class driver 2. extent report base class another driver....baseclass driver object related drivers are not same,there will be conflict,we need to webdriver also static.                                                                 
 public Logger logger;//log4j step                                                                                   
 public Properties p;                                                                                   
 
  
  
  @BeforeClass(groups={"Sanity","Regression","Master"})                                                                      
  @Parameters({"os","browser"})
  public void setup(String os, String br) throws IOException {                                                             
    
	  //loading config.properties file
  
	FileReader file= new FileReader("C:\\Users\\user\\eclipse-workspace\\OPENCARTPROJECTV121\\src\\test"
			+ "\\resources\\config.properties");  
	  p=new Properties();
	 p.load(file); 
	  
	  
	  logger = LogManager.getLogger(this.getClass());
	  //selenium grid environment
	 /* if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  //capabilities.setPlatform(Platform.WIN11);
	  //capabilities.setBrowserName("chrome");
	 //os 
	 if(os.equalsIgnoreCase("windows")) {
	    capabilities.setPlatform(Platform.WINDOWS);
	 }
	 else if(os.equalsIgnoreCase("mac")) { 
	 capabilities.setPlatform(Platform.MAC); 
	  
	 }
	  
	 else {
	 
	 System.out.println("No matching os");
	 return;
	 }
	 
	 //br 
	 switch(br.toLowerCase()) { 
	  case "chrome":capabilities.setBrowserName("chrome");break;
	 case "edge":capabilities.setBrowserName("edge");break;   
	  case "firefox":capabilities.setBrowserName("firefox");break;   
	  default:System.out.println("No matching os");return;
	  
	 }
	driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities); 
	 
	 }
	 
	 // if(p.getProperty("execution_env").equalsIgnoreCase("local")) {*/
	  switch(br.toLowerCase()) 
	  {
	  case "chrome":driver=new ChromeDriver(); break;
	  case "edge":driver=new EdgeDriver(); break;  
	  case "firefox":driver=new FirefoxDriver(); break;  
	    default:System.out.println("Invalid browser name");return; 
	  }                                                                          
	  
	  driver.manage().deleteAllCookies();                                               
  driver.get(p.getProperty("appURL"));    //https://tutorialsninja.com/demo/";                                   
                                                                                    
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));                
                                                                                    
                                                                                    
  driver.manage().window().maximize();                                              
  }                                                                                 
  @AfterClass(groups={"Sanity","Regression","Master"})                                                                       
  public void tearDown() {                                                          
                                                                                    
  driver.quit();                                                                    
                                                                                    
  }                                                                                 

 public String randomString() {                                           
 String generatedstring=RandomStringUtils.randomAlphabetic(5);            
 return generatedstring;                                                  
                                                                          
 }                                                                        
 public String randomNumber() {                                           
 String generatednumber=RandomStringUtils.randomNumeric(10);              
 return generatednumber;                                                  
                                                                          
 }                                                                        
                                                                          
 public String randomAlphaNumeric() {                                     
                                                                          
 	String generatedstring=RandomStringUtils.randomAlphabetic(3);           
 	String generatednumber=RandomStringUtils.randomNumeric(3);              
 return (generatednumber+""+generatedstring);                             
                                                                          
 }                                                                        

public String captureScreen(String tname)throws IOException{

String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

String targetFilePath= System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_" + timeStamp +".png";
	
		

File targetFile= new File(targetFilePath);

sourceFile.renameTo(targetFile);

return targetFilePath;








}


}
