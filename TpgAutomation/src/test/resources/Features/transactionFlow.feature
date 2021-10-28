Feature: Transaction Flow of payment methods
	Verify that all Tranactions Flow are working as per requirement.

	
@MAtransactionFlow
Scenario: Verify Payment Method has been selected and Details has been entered successfully
	Given User has launch the chrome browser. 
	Then Native Checout has been opened.
	When User Enter details of Checkout inculding Store/Order ID's and Personal details
	Then User clicks Cointue to EasyPay Button
	When User selects the Payment Method.
	Then User place the Order.
	Then Admin Portal has been opened. 
	Then Admin enters credentials of username and password as Merchant 
	Then Admin clicks on Go Button, Admin Portal must be opened.
	Then Admin clicks on Manage Merchant Tab and Navigates to Transaction history screen and get the first top transaction.
	Then Admin clicks on Manage Merchant Tab and Navigates to Settlement Transaction history screen and get the first top transaction.