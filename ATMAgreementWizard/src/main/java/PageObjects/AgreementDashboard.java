package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgreementDashboard {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AgreementDashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	
	@FindBy(xpath="//div[@class='topbar-right mt5']")
	WebElement addAgreement;
	
	public void click_add_agreement() {
		addAgreement.click();
	}
}
