package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainDashboard {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public MainDashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	//Page elements
	@FindBy(xpath="//a[@class=\"accordion-toggle\"]//span[contains(text(),'Support')]")
	WebElement support;
	
	@FindBy(xpath="//a[@href=\"/Support/Dashboard/Dashboard\"]")
	WebElement supportDashboard;
	
	@FindBy(xpath="//a[@title=\"Tickets\"]")
	WebElement supportTicket;
	
	@FindBy(xpath="//span[@title=\"Open Service Orders\"]")
	WebElement openServiceOrder;
	
	@FindBy(xpath="//li[25]")
	WebElement cookSecurityGroup;
	
	@FindBy(xpath="//ul[@class='nav sidebar-menu']/li[13]/a[1]")
	WebElement AgreementDropDown;
	
	@FindBy(xpath="//a[@href=\"/AgreementWizard/Agreement\"]")
	WebElement DashboardAgreement;
	
	public void click_agreement() {
		AgreementDropDown.click();
	}
	
	public void click_Agreement_Dashboard() {
		DashboardAgreement.click();
	}
	
	//Methods to handle page elements
	public void click_support() throws InterruptedException {
		
		Thread.sleep(2000);
		int x1 = cookSecurityGroup.getLocation().getX();
		int y1 = cookSecurityGroup.getLocation().getY();
		
		JavascriptExecutor jss =  (JavascriptExecutor)driver;
		System.out.println("This is before subcontractor");
		jss.executeScript("window.scrollBy(" +x1 +", " +y1 +")");
		System.out.println("This is after subcontractor");
		
		
		Thread.sleep(2000);
		int x = support.getLocation().getX();
		int y = support.getLocation().getY();
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(" +x +", " +y +")");
		
		Thread.sleep(2000);
		
		support.click();
	}
	
	public void click_support_dashboard() throws InterruptedException {
		
		int x = supportDashboard.getLocation().getX();
		int y = supportDashboard.getLocation().getY();
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(" +x +", " +y +")");
		
		Thread.sleep(2000);
		
		supportDashboard.click();
	}
	
	public void click_support_ticket() throws InterruptedException {
		
		int x1 = supportTicket.getLocation().getX();
		int y1 = supportTicket.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x1 +", "+y1 +")");
		
		Thread.sleep(2000);
		supportTicket.click();
	}
	
	
	public void pageVerify(String title) {
		
		title = driver.getTitle();
		
		if(title.equals("Login | Cook Command Center")) 
			System.out.println("Page title is correct");
		}
	
	public void scroll_left_panel() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",openServiceOrder);
	}

}
