package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features={"@target/failedrerun.txt"},
		glue={"com.stepdefinition","com.apphooks"},
		dryRun=false,
		monochrome=true,
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/","rerun:target/failedrerun.txt"
		}

		)

public class ReRunner extends AbstractTestNGCucumberTests {

}
