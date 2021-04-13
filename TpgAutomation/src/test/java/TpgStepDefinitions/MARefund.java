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

	@Then("^User place MA Transaction$")
	public void user_place_MA_Transaction() throws Throwable {
		MARefund.placeMATransaction();
	}
	
	@Then("^User clicks on Settlement Screen and then navigates to Settlement Transaction History Screen$")
	public void user_clicks_on_Settlement_Screen_and_then_navigates_to_Settlement_Transaction_History_Screen() throws Throwable {
		MARefund.gotoSettlementScreen();
	}
	
	@Then("^User clicks on Reversal Transaction icon against your MA transaction$")
	public void user_clicks_on_Reversal_Transaction_icon_against_your_MA_transaction() throws Throwable {
		MARefund.reverseTransaction();
	}
	
	@Then("^User selects Reversal Type as full and click OK Button, Settlemet Status should be marked as Reversal_In_Progress$")
	public void user_selects_Reversal_Type_as_full_and_click_OK_Button_Settlemet_Status_should_be_marked_as_Reversal_In_Progress() throws Throwable {
		MARefund.fullResverseTransaction();
	}
	
	@Then("^User selects Reversal Type as Partial and enter amount to be reversed and click OK Button, Settlemet Status should be marked as Reversal_In_Progress$")
	public void user_selects_Reversal_Type_as_Partial_and_enter_amount_to_be_reversed_and_click_OK_Button_Settlemet_Status_should_be_marked_as_Reversal_In_Progress() throws Throwable {
		MARefund.partialResverseTransaction();
	}

}
