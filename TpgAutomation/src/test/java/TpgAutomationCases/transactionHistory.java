package TpgAutomationCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class transactionHistory extends newCheckout {
	
	transactionHistory trxHistry;
	
	
	@FindBy(how = How.XPATH, xpath = "//*[@id=\"j_id558318358_27e9fdb4:MANAGEMERCHANTACCOUNT\"]")
	public WebElement clickManageMerchant;

	@FindBy(how = How.XPATH, xpath = "//*[@id=\"j_id111371225_7ca58090:TRANSACTIONS\"]")
	public WebElement clickTrxHistory;

	@FindBy(how = How.ID, using = "searchTransHistoryForm:j_id971029204_39e0b132")
	public WebElement searchTrxHistory;

	@FindBy(how = How.XPATH, xpath = "//*[@id=\"transactionHistoryForm:transactionHistoryLazyTable:337853:j_id971029204_39e0b66d\"]")
	public WebElement OPS_ID;

	@FindBy(how = How.XPATH, xpath = "//*[@id=\"transactionHistoryForm:transactionHistoryLazyTable:337853:j_id971029204_39e0b7a7\"]")
	public WebElement orderID;

	@FindBy(how = How.XPATH, xpath = "//*[@id=\"transactionHistoryForm:transactionHistoryLazyTable:337853:status\"]")
	public WebElement transactionStatus;

	public void viewTransactionHistory() throws Throwable {
		try {		
			trxHistry = PageFactory.initElements(driver, transactionHistory.class);
			trxHistry.clickManageMerchant.click();
			trxHistry.clickTrxHistory.click();			
			test = extent.createTest("TPG Admin Portal").pass(MarkupHelper.createLabel("Transaction history screen is openeing .",ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Transaction history screen has been opened Successfully.",ExtentColor.GREEN));			

		} catch (Exception e) {
			System.out.println(e);
			test = extent.createTest("TPG Admin Portal").fail(MarkupHelper.createLabel("Transaction history screen has not been opened Successfully.",ExtentColor.RED));
			extent.flush();

		}
	}
	
	public void viewTransaction() throws Throwable {
		try {		
			driver.switchTo().frame("applicationContent");
			trxHistry.searchTrxHistory.click();
			String OPS = trxHistry.OPS_ID.getText();
			String order_ID = trxHistry.orderID.getText();
			String status_ =  trxHistry.transactionStatus.getText();
			test = extent.createTest("TPG Admin Portal").pass(MarkupHelper.createLabel("Transaction history screen is searching latest transaction.",ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Transaction history screen has searched the latest transaction.",ExtentColor.GREEN));			
			test.pass(MarkupHelper.createLabel("OPS ID : "+OPS,ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("ORDER ID : "+order_ID,ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("TRANSACTION STATUS : "+status_,ExtentColor.GREEN));
			extent.flush();

		} catch (Exception e) {
			System.out.println(e);
			test = extent.createTest("TPG Admin Portal").fail(MarkupHelper.createLabel("Latest Transaction has not been able to searched",ExtentColor.RED));
			extent.flush();

		}
	}
	
}
