package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features={"D:\\CucumberFW\\CucumberArtifact\\src\\test\\resource\\features"},
		glue={"com.stepdefinition","com.apphooks"},
		dryRun=false,
		monochrome=true,
//		tags="not @Skip",
		plugin= {
//				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/","rerun:target/failedrerun.txt"
		}

		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
