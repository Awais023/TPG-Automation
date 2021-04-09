package TpgAutomationCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MARefundFunctionality extends newCheckout{

	MARefundFunctionality MA_Refund;
	
	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Reversal Module')]")
	public WebElement reversalScreen;

	public void navigateToMerchantPortalReversalScreen() throws Throwable {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			MA_Refund.reversalScreen.click();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
