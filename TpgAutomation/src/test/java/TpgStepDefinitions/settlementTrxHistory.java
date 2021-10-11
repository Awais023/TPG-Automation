package TpgStepDefinitions;

import TpgAutomationCases.settlementTrxHistry;
import cucumber.api.java.en.Then;

public class settlementTrxHistory {

	settlementTrxHistry settlement_ = new settlementTrxHistry();
	
	@Then("^Admin clicks on Manage Merchant Tab and Navigates to Settlement Transaction history screen and get the first top transaction\\.$")
	public void admin_clicks_on_Manage_Merchant_Tab_and_Navigates_to_Settlement_Transaction_history_screen_and_get_the_first_top_transaction()
			throws Throwable {
		settlement_.gotoSettlementScreen();
		settlement_.viewSettlementTransactionStatus();
		
	}

}
