package com.jmconsultant.testautomation.seleniumframeworkpoc.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.jmconsultant.testautomation.seleniumframeworkpoc")
@PropertySource("classpath:/application-${environment:dev}.properties")
public class TestConfig {
}
