package TpgAutomationCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class settlementTrxHistry extends newCheckout{
	settlementTrxHistry settlement;
	
	@FindBy(how = How.ID, using = "j_id558318358_27e9fdb4:SETTLEMENTMODULE")
	public WebElement settlementScreentab_;

	@FindBy(how = How.ID, using = "j_id111371225_7ca58090:STTLMNTHISTORY")
	public WebElement settlementTransactionHistorytab_;
	
	@FindBy(how = How.ID, using = "searchSttlmntTransForm:j_id212397515_ca8ec2c")
	public WebElement searchTransactions_;
	
	@FindBy(how = How.XPATH, xpath = "/html/body/div/div[2]/div[5]/div/form/div[2]/table/tbody[1]/tr[1]/td[3]")
	public WebElement SettlementOPS_ID;

	@FindBy(how = How.XPATH, xpath = "/html/body/div/div[2]/div[5]/div/form/div[2]/table/tbody[1]/tr[1]/td[4]")
	public WebElement SettlementOrderID;

	@FindBy(how = How.XPATH, xpath = "/html/body/div/div[2]/div[5]/div/form/div[2]/table/tbody[1]/tr[1]/td[10]")
	public WebElement SettlementTransactionStatus;


	public void gotoSettlementScreen() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			settlement = PageFactory.initElements(driver, settlementTrxHistry.class);
			settlement.settlementScreentab_.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			settlement.settlementTransactionHistorytab_.click();
			test = extent.createTest("TPG Admin Portal").pass(MarkupHelper.createLabel("Settlement Transaction history screen is openeing .",ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel(" Settlement Transaction history screen has been opened Successfully.",ExtentColor.GREEN));		
		} catch (Exception e) {
			System.out.println(e);
			test = extent.createTest("Settlement Screen").fail(MarkupHelper.createLabel("Settlement Transaction history screen ihas not been opened successfully..",ExtentColor.RED));
			extent.flush();
		}
	}

	public void viewSettlementTransactionStatus() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().frame("applicationContent");
			settlement.searchTransactions_.click();	
			String OPS = settlement.SettlementOPS_ID.getText();
			String order_ID = settlement.SettlementOrderID.getText();
			String status_ =  settlement.SettlementTransactionStatus.getText();
			test = extent.createTest("TPG Admin Portal").pass(MarkupHelper.createLabel("Settlement Transaction history screen is searching latest transaction.",ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Settlement Transaction history screen has searched the latest transaction.",ExtentColor.GREEN));			
			test.pass(MarkupHelper.createLabel("OPS ID : "+OPS,ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("ORDER ID : "+order_ID,ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("TRANSACTION STATUS : "+status_,ExtentColor.GREEN));
			extent.flush();
		} catch (Exception e) {
			System.out.println(e);
			test = extent.createTest("Search Trannsaction").fail(MarkupHelper.createLabel(
					"Transaction has not been searched  Successfully and  Reverse Trannsaction icon has not been clicked!.",ExtentColor.RED));
			extent.flush();
		}

	}
}
