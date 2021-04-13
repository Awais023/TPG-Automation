Feature: Merchant Portal Sign Up Page Functionalities 
	Verify that Merchant Portal Sign Up Page is working as per requirement.

	
@MARefundFunctionality 
Scenario: Verify Merchant is able to login 
	Given User has launch the chrome browser. 
	Then Merchant Portal has been opened. 
	Then User enters credentials of username and password as Merchant 
	Then User clicks on Go Button, Merchant Portal must be opened. 
	Then User clicks on Reversal Screen 
	
	
@MAFullyRefundFunctionality 
Scenario: Verify Merchant is able to login 
	Given User has launch the chrome browser. 
	Then Native Checout has been opened. 
	When User Enter details of Checkout inculding Store/Order ID's and Personal details 
	Then User clicks Cointue to EasyPay Button 
	Then User place MA Transaction 
	Then Merchant Portal has been opened. 
	Then User enters credentials of username and password as Merchant 
	Then User clicks on Go Button, Merchant Portal must be opened. 
	Then User clicks on Settlement Screen and then navigates to Settlement Transaction History Screen 
	Then User clicks on Reversal Transaction icon against your MA transaction 
	Then User selects Reversal Type as full and click OK Button, Settlemet Status should be marked as Reversal_In_Progress 
	Then User clicks on Reversal Screen 
	
	
@MAPartiallyRefundFunctionality 
Scenario: Verify Merchant is able to login 
	Given User has launch the chrome browser. 
	Then Native Checout has been opened. 
	When User Enter details of Checkout inculding Store/Order ID's and Personal details 
	Then User clicks Cointue to EasyPay Button 
	Then User place MA Transaction 
	Then Merchant Portal has been opened. 
	Then User enters credentials of username and password as Merchant 
	Then User clicks on Go Button, Merchant Portal must be opened. 
	Then User clicks on Settlement Screen and then navigates to Settlement Transaction History Screen 
	Then User clicks on Reversal Transaction icon against your MA transaction 
	Then User selects Reversal Type as Partial and enter amount to be reversed and click OK Button, Settlemet Status should be marked as Reversal_In_Progress 
	Then User clicks on Reversal Screen 
