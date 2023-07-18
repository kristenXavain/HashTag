package com.pageObjectModel_hashTag;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Join_page {
	public  WebDriver driver;
	
	@FindBy(css = "input[placeholder=\"Enter your name\"]")
	private WebElement Name;

	@FindBy(css = "input[name=\"email\"]")
	private WebElement Email;
	
	@FindBy(xpath  = "//input[@placeholder=\"Enter your phone\"]")
	private WebElement 	phone;
	
	@FindBy(xpath="//input[@id=\"inputFile\"]")
	private WebElement Resume;
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement Decription;
	
	@FindBy(xpath ="//button[contains(text(),'APPLY NOW')]")
	private WebElement joinnow;
	
	@FindBy(xpath ="//p[contains(text(),'something went wrong!')]")
	private WebElement errorMessage;

	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public WebElement getName() {
		return Name;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getResume() {
		return Resume;
	}

	public WebElement getDecription() {
		return Decription;
	}

	public WebElement getJoinnow() {
		return joinnow;
	}
public Join_page(WebDriver driv) {
	driver = driv;
	PageFactory.initElements(driver, this);
	
	
	
	
}
	

}
