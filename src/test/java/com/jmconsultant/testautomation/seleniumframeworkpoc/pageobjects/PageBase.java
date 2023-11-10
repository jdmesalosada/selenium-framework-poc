package com.jmconsultant.testautomation.seleniumframeworkpoc.pageobjects;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class PageBase {

    protected WebDriver webDriver;

    @Autowired
    public PageBase(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
}
