Feature: Transaction History Functionalities 
	Verify that a newly performed transaction is visible in Merchant transaction history report
	

@viewMerchantPortalTransactionHistory
Scenario: Verify Transaction is visible
	Given User has launch the chrome browser. 
	Then Merchant Portal has been opened.
	Then User enters credentials of username and password as Merchant
	Then User clicks on Go Button, Merchant Portal must be opened.
	Then Merchant clicks on Manage Merchant Tab and Navigates to Transaction history screen and get the first top transaction.
	
	