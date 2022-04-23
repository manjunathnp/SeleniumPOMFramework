package com.a3_inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.a1_inetBanking.testBase.TestBase;
import com.a2_inetBanking.pageObjects.LoginPage;

public class TC_001_LoginTest extends TestBase
{
	@Test
	public void loginTest() throws IOException
	{	
		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickLogin();
		logger.info("Clicked on Login Button");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("TC_LoginTest_001 PASSED");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("TC_LoginTest_001 FAILED");
		}
			
	}
	
}



















