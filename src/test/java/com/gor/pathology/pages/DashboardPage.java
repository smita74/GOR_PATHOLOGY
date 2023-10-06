package com.gor.pathology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='title']")
	WebElement title;
	
	@FindBy(xpath = "//div[text()='TODO']")
	WebElement todo;
	
	
	@FindBy(xpath = "//div[text()='Test Cost Calculator']")
	WebElement testCalculator;
	
	public boolean verifyDashboardPage() throws InterruptedException {
		Thread.sleep(1000);
		String actResult = title.getText();
		String expResult = "Dashboard";
		return actResult.equals(expResult);
	}
	
	public boolean verifyTodo() {
		return todo.isDisplayed();
	}
	
	public boolean verifyTestCalculator() {
		return testCalculator.isDisplayed();
	}
}
