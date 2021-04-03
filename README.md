# selenium-framework-poc
Example of a mini-framework to execute automated tests using Selenium, Spring, Cucumber.


#### course

https://www.youtube.com/playlist?list=PLeo6Q1inqlOcHb8suOgHzQ8MFeqgeAQ6Z

#### Run the tests

`mvn clean test -Denvironment=dev
`

#### Run the tests by tags

`mvn clean test -Denvironment=dev  -Dcucumber.options="--tags '@run'"
`
