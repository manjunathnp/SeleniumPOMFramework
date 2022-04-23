package com.a1_inetBanking.testBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.a5_inetBanking.utilities.ReadConfig;

public class TestBase {
	ReadConfig readConfig = new ReadConfig();

	public String baseURL = readConfig.getApplicationURL();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();


	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		// WebDriverManager.chromedriver().setup();
		if (br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChroPath());
			// WebDriverManager.chromedriver().setup();


			//Create instance of ChromeOptions Class
			ChromeOptions handlingSSL = new ChromeOptions();
			//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
			handlingSSL.setAcceptInsecureCerts(true);
			//Creating instance of Chrome driver by passing reference of ChromeOptions object
			driver = new ChromeDriver(handlingSSL);



			//driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ReadConfig.IMPLICIT_WAIT_DURATION));
			 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(readConfig.PAGE_LOAD_TIMEOUT));

			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			logger.info("Chrome Browser Launched");
		} else if (br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			logger.info("Firefox Browser Launched");
		} else if (br.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			logger.info("IE Browser Launched");
		}

		driver.get(baseURL);
		logger.info("Navigated to URL");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	// Capture Screenshot
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public String randomestring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
}
