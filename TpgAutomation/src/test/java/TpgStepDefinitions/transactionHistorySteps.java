package TpgStepDefinitions;

import TpgAutomationCases.transactionHistory;
import cucumber.api.java.en.Then;

public class transactionHistorySteps {

	transactionHistory trx = new transactionHistory();
	
	@Then("^Admin clicks on Manage Merchant Tab and Navigates to Transaction history screen and get the first top transaction\\.$")
	public void admin_clicks_on_Manage_Merchant_Tab_and_Navigates_to_Transaction_history_screen_and_get_the_first_top_transaction() throws Throwable {
		trx.viewTransactionHistory();
		trx.viewTransaction();
	}
}
