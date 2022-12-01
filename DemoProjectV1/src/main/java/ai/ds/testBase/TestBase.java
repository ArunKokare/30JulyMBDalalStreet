package ai.ds.testBase;


import java.time.Duration;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import ai.ds.pageLayer.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	
	 public static WebDriver driver;
	 public static Logger logger;
	 public LoginPage login;
	
	 @BeforeClass
	 public void start()
	 {
		  logger = Logger.getLogger("DalalStreet Auto Framework");
		  PropertyConfigurator.configure("Log4j.properties");
		  logger.info("Framework execution started");
	 }
	 
	 @AfterClass
	 public void end()
	 {
		  logger.info("Framework execution completed");
	 }
	
	@Parameters("browser")
	
	@BeforeMethod
	public void setup(String br) throws InterruptedException	  //String br = "chrome";
	{
		if(br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please provide correct browser");
		}
		
		driver.get("https://www.apps.dalalstreet.ai/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("url lunches ,maximize,and provided waits");

	//-------Object creation-------------------------	
		 login = new LoginPage();
		 logger.info("Object Creation");


	//-------Login steps--------------------
		
		login.enterEmailID("amarwaghmare573@gmail.com");
		login.enterPassword("Test@1234");
		login.clickOnLoginButton();
		Thread.sleep(4000);
		logger.info("Login Successfully");

		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
//		driver.quit();
	}

}
