package TpgStepDefinitions;

import TpgAutomationCases.merchantSettlementTrxHstry;
import cucumber.api.java.en.Then;

public class merchantSettlementTrxHistrySteps {
	
	merchantSettlementTrxHstry Trx = new merchantSettlementTrxHstry();

	@Then("^Merchant clicks on Settlement Tab and Navigates to Settlement Transaction history screen and get the first top transaction\\.$")
	public void merchant_clicks_on_Settlement_Tab_and_Navigates_to_Settlement_Transaction_history_screen_and_get_the_first_top_transaction() throws Throwable {
		Trx.gotoSettlementScreen();
		Trx.viewSettlementTransactionStatus();
	}

}
