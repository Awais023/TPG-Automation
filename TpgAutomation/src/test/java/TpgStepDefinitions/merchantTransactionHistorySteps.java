package TpgStepDefinitions;

import TpgAutomationCases.merchantTransactionHistory;
import cucumber.api.java.en.Then;

public class merchantTransactionHistorySteps {
	
	merchantTransactionHistory Trx = new merchantTransactionHistory();

	@Then("^Merchant clicks on Manage Merchant Tab and Navigates to Transaction history screen and get the first top transaction\\.$")
	public void merchant_clicks_on_Manage_Merchant_Tab_and_Navigates_to_Transaction_history_screen_and_get_the_first_top_transaction()
			throws Throwable {
		Trx.gotoTransactionHistoryScreen();
		Trx.searchTrxHstry();
	}

}
