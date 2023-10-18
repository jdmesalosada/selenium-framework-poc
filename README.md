# selenium-framework-poc
Example of a mini-framework to execute automated tests using Selenium, Spring, Cucumber.


#### Udemy course

https://www.udemy.com/course/curso-creacion-framework-con-selenium-spring-y-cucumber/?referralCode=B1820570128B89CDF98D

#### Run the tests

`mvn clean test -Denvironment=prod
`

#### Run the tests by tags

`mvn clean test -Denvironment=prod  -Dcucumber.options="--tags '@run'" 
`
