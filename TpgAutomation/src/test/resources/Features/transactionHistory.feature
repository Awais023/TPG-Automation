Feature: Transaction History Functionalities 
	Verify that a newly performed transaction is visible in transaction history report
	

@viewAdmiPortalTransactionHistory
Scenario: Verify Transaction is visible
	Given User has launch the chrome browser. 
	Then Admin Portal has been opened. 
	Then Admin enters credentials of username and password as Merchant 
	Then Admin clicks on Go Button, Admin Portal must be opened.
	Then Admin clicks on Manage Merchant Tab and Navigates to Transaction history screen and get the first top transaction.
	
	