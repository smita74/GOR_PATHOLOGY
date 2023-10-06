package com.gor.pathology.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestNGReport {
	static ExtentReports extent;

	public static ExtentReports getReportObject() {
		String path = "test-output/GORExtentReport.html";
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		reporter.config().setReportName("Test Automation Report");
		reporter.config().setDocumentTitle("GOR Pathology Lab");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name", "GOR Lab");
		extent.setSystemInfo("User Name", "Smita Kolekar");
		return extent;
	}
}
