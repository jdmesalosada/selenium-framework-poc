package com.jmconsultant.testautomation.seleniumframeworkpoc;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        plugin = {"me.jvt.cucumber.report.PrettyReports:target/cucumber"})
public class CucumberTest {
}
