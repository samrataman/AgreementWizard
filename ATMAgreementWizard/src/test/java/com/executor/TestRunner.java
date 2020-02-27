package com.executor;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/CreateTicket.feature",
				 glue = "com.stepDefinition",
//				 tags = "@CSGLogin, @redirectDashboardPikoVms" ,
				 monochrome = true,
				 plugin = {"pretty", "html:target/report.html", "json:target/report.json" }
		)

public class TestRunner {

}

