Feature: test the login page
	@smoke
  Scenario: checking for sucessful login
    Given the user is on home page
    When user enter username and password
    And click on submit button
    Then user is able to navigate home page
		