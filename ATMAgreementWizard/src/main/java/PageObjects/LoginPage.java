package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Config.Xls_Reader;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;

	Xls_Reader reader = new Xls_Reader("C:\\Users\\aman.k\\git\\SeleniumTestLocal\\SupportTicket\\ExcelData\\sample.xlsx");
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(id="UserName")
	WebElement usernameTextField;
	
	@FindBy(id="Password")
	WebElement passwordTextField;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	public void enter_userName(String userName) {
		usernameTextField.sendKeys(userName);
	}
	
	public void enter_password(String password) {
		passwordTextField.sendKeys(password);
	}
	
	public void click_login() {
		loginButton.click();
	}
	
	public void fill_login_details(String username,String password) {
		
//		String username, password;
		
		enter_userName(username);
		enter_password(password);
		click_login();
	}
	
public void pageVerify(String title) {
		
	title = driver.getTitle();
	
	if(title.equals("Login | Cook Command Center")) 
		System.out.println("Page title is correct");
	}

}
