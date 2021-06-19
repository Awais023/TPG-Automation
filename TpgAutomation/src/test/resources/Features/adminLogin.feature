Feature: Admin Portal Sign Up Page Functionalities
	Verify that Admin Portal Sign Up Page is working as per requirement.

@loginAsAdmin
Scenario: Verify Admin is able to login
	Given User has launch the chrome browser. 
	Then Admin Portal has been opened.
	Then Admin enters credentials of username and password as Merchant
	Then Admin clicks on Go Button, Merchant Portal must be opened.