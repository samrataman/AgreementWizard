package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgreementsATM {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AgreementsATM(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath="//div[@class=\"tab-title\"]")
	WebElement tabTitle;
	
	@FindBy(id="AgreementData_MasterAccount")
	WebElement customerDropDown;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement nextButton;
	
	@FindBy(xpath="//span[@id=\"awAgreementId\"]")
	WebElement ticketId;
	
	@FindBy(xpath="//div[contains(@class,'col-md-12 form-group admin-form')]//label[2]")
	WebElement ATMType;
	
	@FindBy(xpath="//div[contains(@class,'col-md-12 form-group admin-form')]//label[3]")
	WebElement securityType;
	
	@FindBy(xpath="//div[contains(@class,'col-md-12 form-group admin-form')]//label[4]")
	WebElement ITMType;
	
	@FindBy(xpath="//div[contains(@class,'col-md-12 form-group admin-form')]//label[5]")
	WebElement TCAType;
	
	@FindBy(name="GetAgreementTypeOptionsHierarchyList[0].IsChecked")
	WebElement allInclusiveATM;
	
	@FindBy(name="GetAgreementTypeOptionsHierarchyList[5].IsChecked")
	WebElement remoteViewATM;
	
	@FindBy(name="GetAgreementTypeOptionsHierarchyList[14].IsChecked")
	WebElement hostedServer;
	
	@FindBy(name="GetAgreementTypeOptionsHierarchyList[18].IsChecked")
	WebElement sanSolution;
	
	@FindBy(name="GetAgreementTypeOptionsHierarchyList[22].IsChecked")
	WebElement checkImagingService;
	
	@FindBy(name="GetAgreementTypeOptionsHierarchyList[26].IsChecked")
	WebElement atmPMOnly;
	
	@FindBy(name="GetAgreementTypeOptionsHierarchyList[29].IsChecked")
	WebElement remoteViewConnect;
	
	@FindBy(name="GetAgreementTypeOptionsHierarchyList[30].IsChecked")
	WebElement ncrSoftwareMaintenance;
	
	@FindBy(name="GetAgreementTypeOptionsHierarchyList[31].IsChecked")
	WebElement hyosungSoftwareMaintenance;
	
	@FindBy(name="GetAgreementTypeOptionsHierarchyList[32].IsChecked")
	WebElement eventToVideo;
	
	@FindBy(xpath="//input[@id='Name']")
	WebElement locationSearchField;
	
	@FindBy(xpath="//table[@id=\"tblLocation\"]//tbody//tr//td[1]//input[@type=\"checkbox\"]")
	WebElement locationCheckBox;
	
	@FindBy(xpath="//tr[@class=\"tr-main\"]//td[1]")
	WebElement equipmentInfo;
	
	public int get_equipmentInfo_count() {
		List<WebElement> ei = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@class=\"table\"]//tbody//tr[@class=\"tr-main\"]")));
		return (ei.size()); 
	}
	
	public void search_Location(String loc) {
		locationSearchField.clear();
		locationSearchField.sendKeys(loc);
		locationSearchField.sendKeys(Keys.ENTER);
	}
	
	public void select_location() {
		locationCheckBox.click();
	}
	
	public void select_all_allInclusiveATM() {
		allInclusiveATM.click();
	}
	
	public void select_all_remoteViewATM() {
		remoteViewATM.click();
	}
	
	public void select_all_hostedServer() {
		hostedServer.click();
		System.out.println("hostedServer clicked");
	}
	
	public void select_all_sanSolution() {
		sanSolution.click();
	}
	
	public void select_all_checkImagingService() {
		checkImagingService.click();
	}
	
	public void select_all_atmPMOnly() {
		atmPMOnly.click();
	}
	
	public void select_remoteViewConnect() {
		remoteViewConnect.click();
		System.out.println("remoteViewConnect clicked");
	}
	
	public void select_ncrSoftwareMaintenance() {
		ncrSoftwareMaintenance.click();
		System.out.println("ncrSoftwareMaintenance clicked");
	}
	
	public void select_hyosungSoftwareMaintenance() {
		hyosungSoftwareMaintenance.click();
	}
	
	public void select_eventToVideo() {
		System.out.println("Even to video clicked");
		eventToVideo.click();
	}
	public void select_ATM_agreement() {
		ATMType.click();
	}
	
	public void select_security_type() {
		securityType.click();
	}
	
	public void select_ITM_agreement() {
		ITMType.click();
	}
	
	public void select_TCA_agreement() {
		TCAType.click();
	}
	
	public String get_ticket_id() {
		return ticketId.getText();
	}
	
	public String get_tab_title() {
		return tabTitle.getText();	
	}
	
	public void select_customer(String customer) {
		Select customerDD = new Select(customerDropDown);
		System.out.println("Customer is: "+customer);
		customerDD.selectByVisibleText(customer);
	}
	
	public void click_next() {
		nextButton.click();
	}
	
	
}
