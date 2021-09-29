package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement usernameTxtFld;
	
	@FindBy(name="password")
	WebElement passwordTxtFld;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logoutLink;
	
	
	public void setUsername(String uname)
	{
		usernameTxtFld.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		passwordTxtFld.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		loginBtn.click();
	}
	
	public void clickLogout()
	{
		logoutLink.click();
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


