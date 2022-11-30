package ai.ds.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import ai.ds.testBase.TestBase;


public class LoginPageTest extends TestBase {
	
	 public String expected_url = "https://www.apps.dalalstreet.ai/dashboard";
	
	@Test
	public void verifyLoginTest() throws InterruptedException
	{
		String actual_url = login.getCURL();
		Thread.sleep(3000);
		Assert.assertEquals(actual_url, expected_url);
		
	}

}
