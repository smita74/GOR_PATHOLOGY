package com.gor.pathology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement pass;
	
	@FindBy(className  = "MuiButton-containedPrimary")
	WebElement loginBtn;
	
	public void enterEmail(String uName) {
		email.clear();
		email.sendKeys(uName);
	}
	
	public void enterPass(String uPass) {
		pass.clear();
		pass.sendKeys(uPass);
	}
	
	public void clickOnLogin() {
		loginBtn.click();
	}
	
	public boolean verifyLoginTitle() {
		String actResult = driver.getTitle();
		String expResult = "GOR Pathology Web Portal";
		return actResult.equals(expResult);
	}
	
	public DashboardPage doLoginWithValidData(String uName, String uPass) {
		enterEmail(uName);
		enterPass(uPass);
		clickOnLogin();
		return new DashboardPage(driver);
	}
	
	public void doLoginWithInValidData(String uName, String uPass) {
		enterEmail(uName);
		enterPass(uPass);
		clickOnLogin();
	}
}
