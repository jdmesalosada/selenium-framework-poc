package com.jmconsultant.testautomation.seleniumframeworkpoc.tasks;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class NavigateTo {

    @Autowired
    private WebDriver webDriver;

    @Value("${url}")
    private String url;

    /*public void signUpPage(){
        this.webDriver.get("http://demo.automationtesting.in/Register.html");
    }*/
    public void signUpPage(){
        this.webDriver.get(url);
    }
}


