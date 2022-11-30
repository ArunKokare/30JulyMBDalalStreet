package ai.ds.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import ai.ds.testBase.TestBase;

public class UtilClass extends TestBase {
	
	public UtilClass()
	{
		PageFactory.initElements(driver, this);
	}
	
	//screenshot
	public static  void takeScreenShot(String filename) 
	{
		 
		try
		{
			String path = "D:\\Git Repository\\30JulyMBDalalStreet\\DemoProjectV1\\screenshot\\";
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			File des = new File(path+filename+".png");
			FileHandler.copy(src, des);
			
		} 
		catch (IOException e) 
		{
			System.out.println("IO Exception - file not found");
			e.printStackTrace();
		}
		
	}

}
