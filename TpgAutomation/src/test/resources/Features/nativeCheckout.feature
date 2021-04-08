Feature: Native Checkouts Feature
	Verify that all Native Checkout Payment Methods are working as per requirement.

@openNativeCheckoutPage
Scenario: Verify Native Checout Page is open
	Given User has launch the chrome browser. 
	Then Native Checout has been opened.
	

@enterChecoutDetails
Scenario: Verify Checkout Details has been entered successfully
	Given User has launch the chrome browser. 
	Then Native Checout has been opened.
	When User Enter details of Checkout inculding Store/Order ID's and Personal details
	Then User clicks Cointue to EasyPay Button
	
@selectPGWandEnterDetails
Scenario: Verify Payment Method has been selected and Details has been entered successfully
	Given User has launch the chrome browser. 
	Then Native Checout has been opened.
	When User Enter details of Checkout inculding Store/Order ID's and Personal details
	Then User clicks Cointue to EasyPay Button
	When User selects the Payment Method.
	Then User place the Order.