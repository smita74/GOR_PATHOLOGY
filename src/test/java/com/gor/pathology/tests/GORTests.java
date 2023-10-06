package com.gor.pathology.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gor.pathology.pages.DashboardPage;
import com.gor.pathology.pages.LoginPage;

public class GORTests extends BaseIntegration {

	@Test(dataProvider = "loginDataProvider")
	public void doLogin(String tName, String uName, String uPassword) throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		if (tName.equals("Both are valid")) {
			DashboardPage dashboard = login.doLoginWithValidData(uName, uPassword);
			Assert.assertTrue(dashboard.verifyDashboardPage());
			Assert.assertTrue(dashboard.verifyTodo());
			Assert.assertTrue(dashboard.verifyTestCalculator());
		} else {
			login.doLoginWithInValidData(uName, uPassword);
			Assert.assertTrue(login.verifyLoginTitle());
		}
		Thread.sleep(3000);
	}
}
