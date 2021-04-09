Feature: Merchant Portal Sign Up Page Functionalities
	Verify that Merchant Portal Sign Up Page is working as per requirement.

	
@MARefundFunctionality
Scenario: Verify Merchant is able to login
	Given User has launch the chrome browser. 
	Then Merchant Portal has been opened.
	Then User enters credentials of username and password as Merchant
	Then User clicks on Go Button, Merchant Portal must be opened.
	Then User clicks on Reversal Screen
	