package org.mutualDrug.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(features="src/test/resources",
glue="org.mutualDrug.stepDefinitions",
dryRun=false,
plugin= {"pretty","html:target/mutualDrugTestReports.html"},
monochrome=true)
public class TestRunner {


}