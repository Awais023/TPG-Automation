package TpgStepDefinitions;

import TpgAutomationCases.loginMerchantfunctionality;
import cucumber.api.java.en.Then;

public class merchantLogin {
	
	loginMerchantfunctionality loginMerchant_ = new loginMerchantfunctionality();

	@Then("^Merchant Portal has been opened\\.$")
	public void merchant_Portal_has_been_opened() throws Throwable {
		loginMerchant_.launchTPGMerchantPortal();
	}

	@Then("^User enters credentials of username and password as Merchant$")
	public void user_enters_credentials_of_username_and_password_as_Merchant() throws Throwable {
	//	loginMerchant_.merchantSignUpCredentials();
	}

	@Then("^User clicks on Go Button, Merchant Portal must be opened\\.$")
	public void user_clicks_on_Go_Button_Merchant_Portal_must_be_opened() throws Throwable {
		//loginMerchant_.loginToMerchantPortal();
	}
}
