Feature: Framework is able to connect to a database

  @database
  Scenario: Able to get and write data in database
    Given Pepito already registered an user
    When he asks for the user
    Then he should get a registered user