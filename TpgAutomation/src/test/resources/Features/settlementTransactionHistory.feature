Feature: Settlement Transaction History Functionalities 
	Verify that a newly performed transaction is visible in Settlement transaction history report
	
@viewAdmiPortalSettlementTransactionHistory
Scenario: Verify Transaction is visible on Settlement transaction history report
	Given User has launch the chrome browser. 
	Then Admin Portal has been opened. 
	Then Admin enters credentials of username and password as Merchant 
	Then Admin clicks on Go Button, Admin Portal must be opened.
	Then Admin clicks on Manage Merchant Tab and Navigates to Settlement Transaction history screen and get the first top transaction.
	
	