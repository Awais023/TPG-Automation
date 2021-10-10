package TpgStepDefinitions;

import TpgAutomationCases.adminLoginFunctionality;
import cucumber.api.java.en.Then;

public class adminLogin {

	adminLoginFunctionality adminlogin_ = new adminLoginFunctionality();
	
	@Then("^Admin Portal has been opened\\.$")
	public void admin_Portal_has_been_opened() throws Throwable {
		adminlogin_.launchTPGAdminPortal();
	}

	@Then("^Admin enters credentials of username and password as Merchant$")
	public void admin_enters_credentials_of_username_and_password_as_Merchant() throws Throwable {
		adminlogin_.adminSignUpCredentials();
	}

	@Then("^Admin clicks on Go Button, Admin Portal must be opened\\.$")
	public void admin_clicks_on_Go_Button_Admin_Portal_must_be_opened() throws Throwable {
		adminlogin_.loginToAdminPortal();
	}
}
