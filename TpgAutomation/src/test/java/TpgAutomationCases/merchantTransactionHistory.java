package TpgAutomationCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class merchantTransactionHistory extends newCheckout {
	
	@FindBy(how = How.XPATH, xpath = "//*[@id=\"j_id868571760_179b2e7c:TRANSACTIONS\"]/span")
	public WebElement clickTrxHstry;
	
	merchantTransactionHistory merchantTrx;

	@FindBy(how = How.XPATH, xpath = "//*[@id=\"transactionHistoryForm:transactionHistoryTable:337674:j_id2002390525_775a0199\"]/a")
	public WebElement OPS_ID;

	@FindBy(how = How.XPATH, xpath = "//*[@id=\"transactionHistoryForm:transactionHistoryTable:337674:j_id2002390525_775a00e7\"]")
	public WebElement orderID;

	@FindBy(how = How.XPATH, xpath = "//*[@id=\"transactionHistoryForm:transactionHistoryTable:337674:j_id2002390525_775a033c\"]")
	public WebElement transactionStatus;
	
	@FindBy(how = How.ID, using = "SearchTransHistoryForm:j_id2002390525_775a0796")
	public WebElement searchTrxHstry;
	
	public void gotoTransactionHistoryScreen() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			merchantTrx = PageFactory.initElements(driver, merchantTransactionHistory.class);
			merchantTrx.clickTrxHstry.click();
			test = extent.createTest("TPG Merchant Portal").pass(MarkupHelper.createLabel("Transaction history screen is openeing .",ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Transaction history screen has been opened Successfully.",ExtentColor.GREEN));	
		} catch (Exception e) {
			System.out.println(e);
			test = extent.createTest("TPG Merchant Portal").fail(MarkupHelper.createLabel("Transaction history screen has been opened Successfully.",ExtentColor.RED));
			extent.flush();
		}
	}
	
	public void searchTrxHstry() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().frame("applicationContent");
			merchantTrx.searchTrxHstry.click();			
			String OPS = merchantTrx.OPS_ID.getText();
			String order_ID = merchantTrx.orderID.getText();
			String status_ =  merchantTrx.transactionStatus.getText();
			test = extent.createTest("TPG Merchant Portal").pass(MarkupHelper.createLabel("Transaction history screen is searching latest transaction.",ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Transaction history screen has searched the latest transaction.",ExtentColor.GREEN));			
			test.pass(MarkupHelper.createLabel("OPS ID : "+OPS,ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("ORDER ID : "+order_ID,ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("TRANSACTION STATUS : "+status_,ExtentColor.GREEN));
			extent.flush();
		} catch (Exception e) {
			System.out.println(e);
			test = extent.createTest("Settlement Screen").fail(MarkupHelper.createLabel("Settlement Screen has not  been opened Successfully!.",ExtentColor.RED));
			extent.flush();
		}
	}

}
