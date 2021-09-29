package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.inetBanking.testCases.TestBase;

public class ReadConfig 
{
	
	
	Properties prop;
	
	public ReadConfig()
	{
		File src = new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		return prop.getProperty("baseURL"); 
	}

	public String getUsername()
	{
		return prop.getProperty("username");
	}
	
	public String getPassword()
	{
		return prop.getProperty("password");
	}
	
	public String getChroPath()
	{
		return prop.getProperty("chromePath");
	}
	
	public String getFirefoxPath()
	{
		return prop.getProperty("fireFoxPath");
	}
	
	public String getIEPath()
	{
		return prop.getProperty("ieDriverPath");
	}
	
	
	
	public static long IMPLICIT_WAIT_DURATION = 30;
	public static long PAGE_LOAD_TIMEOUT = 60;
	
	
	
	
}
