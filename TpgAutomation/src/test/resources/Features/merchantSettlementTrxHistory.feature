Feature: Settlement Transaction History Functionalities 
	Verify that a newly performed transaction is visible in Merchant Settlement transaction history report
	
@viewMerchantPortalSettlementTransactionHistory
Scenario: Verify Transaction is visible on Merchant Settlement transaction history report
	Given User has launch the chrome browser. 
	Then Merchant Portal has been opened.
	Then User enters credentials of username and password as Merchant
	Then User clicks on Go Button, Merchant Portal must be opened.
	Then Merchant clicks on Settlement Tab and Navigates to Settlement Transaction history screen and get the first top transaction.
	
	