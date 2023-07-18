package com.HasgTag_Runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.HashTag_Base.Base;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\hashtag.feature",
glue = "com.HashTag_Step",
monochrome = true , 
plugin = {"pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"html:target/htmlReport.html",
		"json:target/jsonTarget.json",
		"junit:target/junitTarget.xml"})
		

		
public class Runner_1 extends Base {

	public static WebDriver driver;

	@BeforeClass
	public static void Set_up() {

		driver = browserLaunch("chrome");

	}
	@AfterClass
	public static void tearDown() {
	driver.quit();
}
}
