package freecrm.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import freecrm.com.base.BaseClass;

public class LogInPage extends BaseClass{

	@FindBy(name="email")
	WebElement EmailLogIn;
	@FindBy(name="password")
	WebElement Password;
	@FindBy(xpath="//div[text()='Login']")
	WebElement LogInBtncClick;
	
	public HomePage Login(String Un, String Pass) {
		
		EmailLogIn.sendKeys(Un);
		Password.sendKeys(Pass);
		LogInBtncClick.click();
		
		return new HomePage(); //as log in page returns home page object
	}

	public String LogInTitle() {
		
		 String title1 =  driver.getTitle();
		 return title1;
		 
	}
}
