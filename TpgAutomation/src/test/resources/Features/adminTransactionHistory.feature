Feature: Admin Portal Transaction History Screen
	Verify that a newly performed transaction is visible in transaction history report.

@viewTranasactionHistory
Scenario: Verify newly performed transaction is visible in transaction history report
	Given User has launch the chrome browser. 
	Then Admin Portal has been opened.
	Then Admin enters credentials of username and password as Merchant
	Then Admin clicks on Go Button, Admin Portal must be opened.
	Then Admin navigates to Transaction History screen and View newly Performed Transaction.
	