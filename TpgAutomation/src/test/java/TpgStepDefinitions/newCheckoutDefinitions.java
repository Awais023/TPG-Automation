package TpgStepDefinitions;

import TpgAutomationCases.newCheckout;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class newCheckoutDefinitions {

	newCheckout checkout = new newCheckout();
	
	@Given("^User has launch the chrome browser\\.$")
	public void user_has_launch_the_chrome_browser() throws Throwable {
		checkout.setExtent();
		checkout.launchBrowser();
	}

	@Then("^Native Checout has been opened\\.$")
	public void native_Checout_has_been_opened() throws Throwable {
		checkout.launchTPGNewCheckout();
	}
	
	@When("^User Enter details of Checkout inculding Store/Order ID's and Personal details$")
	public void user_Enter_details_of_Checkout_inculding_Store_Order_ID_s_and_Personal_details() throws Throwable {
		checkout.enterCheckoutDetails();
	}

	@Then("^User clicks Cointue to EasyPay Button$")
	public void user_clicks_Cointue_to_EasyPay_Button() throws Throwable {
		checkout.clickEasyPayButton();
	}
	
	@When("^User selects the Payment Method\\.$")
	public void user_selects_the_Payment_Method() throws Throwable {
		checkout.selectPaymentMethod();	
	}
	
	@Then("^User place the Order\\.$")
	public void user_place_the_Order() throws Throwable {
		checkout.placeTransaction();
	}
}
