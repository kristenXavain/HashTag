package com.HashTag_Step;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.HasgTag_Runner.Runner_1;
import com.HashTag_Base.Base;
import com.pageObjectModel_hashTag.Join_page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends Base {

	public static WebDriver driver = Runner_1.driver;

	Join_page jp = new Join_page(driver);

	Actions ac = new Actions(driver);

	@Given("user Launch The Application By Using The Url")
	public void user_launch_the_application_by_using_the_url() {
		get("https://www.hashtag-ca.com/careers/apply?jobCode=QAE001");
		maximize();
	
	}

	@When("user Enters The UserName in The Name Field")
	public void user_enters_the_user_name_in_the_name_field() {
		sendKeys(jp.getName(), "Ronald");
	}

	@When("user Enters The EmailId Of The User in the Email Field")
	public void user_enters_the_email_id_of_the_user_in_the_email_field() {
		sendKeys(jp.getEmail(), "dlanorsemaj14@gmail.com");
	}

	@When("user Enters The Phone Number In The Phone Number Field and It Must be only Integer")
	public void user_enters_the_phone_number_in_the_phone_number_field_and_it_must_be_only_integer() {
		sendKeys(jp.getPhone(), "6380077825");
	}

	@When("user Clicks The Choose File Option For Uploading Resume and File Folder Will Open")
	public void user_clicks_the_choose_file_option_for_uploading_resume_and_file_folder_will_open()
			throws InterruptedException {

		Thread.sleep(5000);

		actions(jp.getResume(), "moveToElement");

		actions(jp.getResume(), "click");

		Thread.sleep(10000);

	}

	@When("user Selects Some file")
	public void user_selects_some_file() throws AWTException, InterruptedException {
		Robot r = new Robot();

		StringSelection stvariable = new StringSelection("Ronald CV");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stvariable, null);

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}
	@When("user Can Give Their Description In the Description Field")
	public void user_can_give_their_description_in_the_description_field() {
		String s = "Enthusiastic and highly skilled technical and testing professional with overall 4 years of experience in the IT industry. To work in an ambitious environment where I can efficiently deliver my technical knowledge, problem-solving skills, and interpersonal skills to enrich the organization. Currently looking for a new opportunity to work with an innovative company in a progressive and challenging environment.";

		sendKeys(jp.getDecription(), s);
	}

	@Then("user Clicks The Apply Now button and It Will Navigate To The Apply Now Page")
	public void user_clicks_the_apply_now_button_and_it_will_navigate_to_the_apply_now_page()
			throws InterruptedException, IOException {

		Thread.sleep(2000);
		ScrollByAxis(0,500);
		ScrollAndClick(jp.getJoinnow());
		WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.textToBePresentInElement(jp.getErrorMessage(),"something went wrong! please try again later"));
        takesScreenShot("ErrorMessage");
		
		

	}

}
