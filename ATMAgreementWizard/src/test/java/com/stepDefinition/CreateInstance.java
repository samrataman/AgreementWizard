package com.stepDefinition;

import com.driver.DriverInstance;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.en.Given;

public class CreateInstance {
		
		public static String browserName = null;
	
//	@Given("^Browser is \"([^\"]*)\"$")
//	public void browser_is(String browser){
//	    
//		// Write code here that turns the phrase above into concrete actions
//		
//	    
//	}
	
	@Given("Browsere is {string}")
	public void browsere_is(String browser) {
	    // Write code here that turns the phrase above into concrete actions
		if(browserName == null) {
			DriverInstance.setInstance(browser);
			browserName = browser;
		}
		if(browserName!= null && !browserName.equals(browser)) {
			DriverInstance.setInstance(browser);
			browserName = browser;
		}
	}

	@Before
	public void beforeScenario(Scenario sc) {
		System.out.println(sc.getName());
		System.out.println("Runs before all");
	}
	
	@After
	public void afterScenario(Scenario sc) {
		System.out.println(sc.getStatus());
	}
}
