package com.stepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.DriverInstance;

import Config.Xls_Reader;
import PageObjects.AgreementDashboard;
import PageObjects.AgreementsATM;
import PageObjects.LoginPage;
import PageObjects.MainDashboard;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAgreementATM {
	
	WebDriver driver;
	WebDriverWait wait;
	LoginPage loginPage;
	MainDashboard dashboardPage;
	AgreementDashboard agreementDashboard;
	AgreementsATM atmAgreement;
	int categoriesCount = 4;
	int locationCount = 4;
	
	
	Xls_Reader reader = new Xls_Reader("C:\\Users\\aman.k\\git\\AgreementWizard\\ATMAgreementWizard\\ExcelData\\sample.xlsx");
	
	static DriverInstance instance;
	{
		instance = DriverInstance.getinstance();
		driver = instance.getDiver();
		wait = instance.getWait();
	}
	
	
	public WebElement visibilityWait(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void verify_title(String title) {
		 Boolean flag =  wait.until(ExpectedConditions.titleIs(title));
		   if(flag == true) {
			   System.out.println("Title matched successfully");
		   }
		   else {
			   System.out.println("Title doesnt matched, Please try again later.");
		   }
	}
	
	
	public WebElement loaderVisibilityWait() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"loader-text\"]")));
	}
	
	public Boolean loaderInvisibilityWait() {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loader-text\"]")));
	}
	
	@Given("user navigates to CSG Login page")
	public void user_navigates_to_CSG_Login_page() {
		driver.manage().window().maximize();
		driver.get("https://qa.cooksecuritygroup.com:9116/");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password_given_below() {
					   
		String username = reader.getCellData("Login", 0, 2);
		String password = reader.getCellData("Login", 1, 2);
			   loginPage = new LoginPage(driver);
			   loginPage.fill_login_details(username, password);    
	}

	@Then("page with title {string} should open")
	public void page_with_title_should_open(String title) {
		   loaderInvisibilityWait();
		   verify_title(title);  
	}
	
	@When("user clicks on Agreement->Dashboard")
	public void user_clicks_on_Agreement_Dashboard() {
	    dashboardPage = new MainDashboard(driver);
	    dashboardPage.click_agreement();
	    dashboardPage.click_Agreement_Dashboard();
	    loaderVisibilityWait();
	}

	@When("user clicks on Add Agreement")
	public void user_clicks_on_Add_Agreement() {
	
		loaderInvisibilityWait();
		agreementDashboard = new AgreementDashboard(driver);
		agreementDashboard.click_add_agreement();
		loaderVisibilityWait();
		
	}

	@Then("page with header {string} should open")
	public void page_with_header_should_open(String header) {
	  
		atmAgreement = new AgreementsATM(driver);
	   loaderInvisibilityWait();
	   String tabTitle = atmAgreement.get_tab_title();
	   
	   System.out.println("Header is: " +tabTitle);
	   if(tabTitle.contains(header)) {
		   System.out.println("Header is correct");
	   }
	   else {
		   System.out.println("You are on wrong tab");
	   }
	}
	
	@When("user select customer from customer Drop down")
	public void user_select_customer_from_customer_Drop_down() {
	      atmAgreement = new AgreementsATM(driver);
	      String customer = reader.getCellData("CreateAgreement", "Customer", 2);
	      atmAgreement.select_customer(customer);
	}

	@When("click on next")
	public void click_on_next() {
		 atmAgreement = new AgreementsATM(driver);
		 atmAgreement.click_next();
		 loaderVisibilityWait();		
	}
	
	@When("user select agreement type")
	public void user_select_agreement_type() throws InterruptedException {
		 loaderInvisibilityWait(); 
		 atmAgreement = new AgreementsATM(driver);
		 String agreementType = reader.getCellData("CreateAgreement", "Agreement Type", 2);
		 if(agreementType.equals("ATM")) {
			 atmAgreement.select_ATM_agreement();
		 }
		 else if(agreementType.equals("Security")) {
			 atmAgreement.select_security_type();
		 }
		 else if(agreementType.equals("ITM")) {
			 atmAgreement.select_ITM_agreement();
		 }
		 else {
			 atmAgreement.select_TCA_agreement();
		 }
		 Thread.sleep(2000);
	}

	@Then("Equipment categories list will be open")
	public void equipment_categories_list_will_be_open() {
		Boolean flag = wait.until(ExpectedConditions.textToBe(By.xpath("//strong[contains(text(),'Select equipment categories of interest')]"),"Select equipment categories of interest"));
		if(flag) {
			System.out.println("Categories list is displayed");
		}
		else {
			System.out.println("Unable to click on any of agreement type");
		}
		
	}
	
	@When("user selects given equipment categories")
	public void user_selects_given_equipment_categories() {
		atmAgreement = new AgreementsATM(driver);
//		String category = reader.getCellData("ATM", "Equipment Category", 2);
//		atmAgreement.select_all_checkImagingService();
		
		int count = 2;
		List<String> categories = new ArrayList<String>();
	    for(int i=1;i<=categoriesCount;i++) {
	    	categories.add(reader.getCellData("ATM", "Equipment Category", count));
	    	count++;
	    }
	    
	    
	    for(String category1: categories) {
	    	System.out.println("Categories are: "+category1);
	    	if(category1.contains("Event to Video")) {
	    		atmAgreement.select_eventToVideo();
	    	}
	    	else if(category1.contains("RemoteView Connect")) {
	    		atmAgreement.select_remoteViewConnect();
	    	}
	    	else if(category1.contains("NCR Software Maintenance")) {
	    		atmAgreement.select_ncrSoftwareMaintenance();
	    	}
	    	else if(category1.contains("Hosted Server Agreement")) {
	    		atmAgreement.select_all_hostedServer();
	    	}
	    	else {
	    		System.out.println("No categories selected");
	    	}
	    }
	}
	
	@When("user search and selects a location")
	public void user_search_and_selects_a_location() throws InterruptedException {
	   
		loaderInvisibilityWait();
		atmAgreement = new AgreementsATM(driver);
		
		int count = 2;
		List<String> locations = new ArrayList<String>();
	    for(int i=1;i<=locationCount;i++) {
	    	locations.add(reader.getCellData("CreateAgreement", "Locations", count));
	    	count++;
	    }
	    
	    for(String location: locations) {
	    	System.out.println("Selected categories are: " +location);
	    	atmAgreement.search_Location(location);
			loaderVisibilityWait();
			loaderInvisibilityWait();
			Thread.sleep(2000);
			atmAgreement.select_location();
	    }
		
	}
	
	@When("user expand each location")
	public void user_expand_each_location() {
		atmAgreement = new AgreementsATM(driver);
		int size = atmAgreement.get_equipmentInfo_count();
		System.out.println("Number of Equipments are: " +size);
		for(int i=0;i<size;i++) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class=\"table\"]//tbody//tr[i+1]//td[1]"))).click();
		}
	}

	@Then("Equipment info will be shown")
	public void equipment_info_will_be_shown() {
	 
	}


}
