package TpgStepDefinitions;

import cucumber.api.java.en.Given; 
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import TpgAutomationCases.MARefundFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;

public class MARefund {
	
	MARefundFunctionality MARefund = new MARefundFunctionality();
	
	@Then("^User clicks on Reversal Screen$")
	public void user_clicks_on_Reversal_Screen() throws Throwable {
		MARefund.navigateToMerchantPortalReversalScreen();
	}

}
