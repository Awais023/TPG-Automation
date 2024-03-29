package TpgAutomationCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class MARefundFunctionality extends newCheckout {

	MARefundFunctionality MA_Refund;
	newCheckout checkout_;

	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Reversal Module')]")
	public WebElement reversalScreentab;

	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Settlement Module')]")
	public WebElement settlementScreentab;

	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Settlement Transaction History')]")
	public WebElement settlementTransactionHistorytab;

	@FindBy(how = How.XPATH, xpath = "//input[@id='SearchSettlmentForm:j_id2055790156_7a88dfec']")
	public WebElement searchTransactions;

	@FindBy(how = How.XPATH, xpath = "/html[1]/body[1]/div[1]/div[2]/div[6]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[13]/div[1]/a[1]")
	public WebElement clickReverseTransIcon;

	@FindBy(how = How.XPATH, xpath = "/html[1]/body[1]/div[3]/div[3]/div[1]/form[1]/input[2]")
	public WebElement clickYesReverseButton;

	@FindBy(how = How.XPATH, xpath = "/html[1]/body[1]/div[3]/div[3]/div[1]/form[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")
	public WebElement clickPartialReverseButton;

	@FindBy(how = How.ID, using = "j_id2055790156_7a88d6af:inputPartialAmount")
	public WebElement partialAmount;

	@FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div[6]/div/div/form/div[1]/table/tbody[1]/tr[1]/td[10]")
	public WebElement settlementStatus;

	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Reversal Report')]")
	public WebElement reversalReport;

	@FindBy(how = How.ID, using = "searchReversalForm:j_id226064049_d7974fa")
	public WebElement clickSearchReversalReport;

	@FindBy(how = How.XPATH, xpath = "/html/body/div/div[2]/div/div[6]/div/div/form/div/div/div/div[2]/table/tbody[1]/tr[1]/td[7]/a")
	public WebElement clickOpenReversedTransaction;

	@FindBy(how = How.XPATH, xpath = "/html/body/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/div/div[1]/form/button")
	public WebElement placeMAOrder_;

	@FindBy(how = How.XPATH, xpath = "/html/body/div/div[2]/div/div[6]/div/div/form/div/div/div/div[2]/table/tbody[1]/tr[2]/td/table/tbody[1]/tr/td[7]")
	public WebElement reversalStatus;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	public void placeMATransaction() {
		try {
			MA_Refund = PageFactory.initElements(driver, MARefundFunctionality.class);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().frame("easypay-iframe");
			WebElement clickMAMethod = wait.until(ExpectedConditions.visibilityOfElementLocated(clickMA));
			clickMAMethod.click();
			MA_Refund.placeMAOrder_.click();
			Thread.sleep(17000);
			test = extent.createTest("Place MA Transaction")
					.pass(MarkupHelper.createLabel("MA Transaction has been placed Successfully!.", ExtentColor.GREEN));
		} catch (Exception e) {
			System.out.println(e);
			test = extent.createTest("Place MA Transaction").fail(
					MarkupHelper.createLabel("MA Transaction has not been placed Successfully!.", ExtentColor.RED));
			extent.flush();
		}
	}

	public void gotoSettlementScreen() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			MA_Refund = PageFactory.initElements(driver, MARefundFunctionality.class);
			MA_Refund.settlementScreentab.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			MA_Refund.settlementTransactionHistorytab.click();
			test = extent.createTest("Settlement Screen").pass(
					MarkupHelper.createLabel("Settlement Screen has been opened Successfully!.", ExtentColor.GREEN));
		} catch (Exception e) {
			System.out.println(e);
			test = extent.createTest("Settlement Screen").fail(
					MarkupHelper.createLabel("Settlement Screen has not been opened Successfully!.", ExtentColor.RED));
			extent.flush();
		}
	}

	public void reverseTransaction() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().frame("applicationContent");
			MA_Refund.searchTransactions.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			MA_Refund.clickReverseTransIcon.click();
			test = extent.createTest("Search Transaction for Reversal")
					.pass(MarkupHelper.createLabel("Settlement Screen has been searching...", ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Transaction has been searched  Successfully!.", ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Reverse Transaction icon has been clicked!.", ExtentColor.GREEN));
		} catch (Exception e) {
			System.out.println(e);
			test = extent.createTest("Search Transaction for Reversal").fail(MarkupHelper.createLabel(
					"Transaction has not been searched  Successfully and  Reverse Trannsaction icon has not been clicked!.",
					ExtentColor.RED));
			extent.flush();
		}

	}

	public void fullResverseTransaction() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			MA_Refund.clickYesReverseButton.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String status = MA_Refund.settlementStatus.getText();
			System.out.println("Transaction status has been marked as " + status);
			test = extent.createTest("Fully Reverse Transaction ").pass(MarkupHelper.createLabel(
					"Transaction  has been fully reversed Successfully and Status of Transaction has been marked as "
							+ status,
					ExtentColor.GREEN));
		} catch (Exception e) {
			System.out.println(e);
			test = extent.createTest("Fully Reverse Trannsaction").fail(MarkupHelper
					.createLabel("Transaction  has been failed to fully reversed Successfully!.", ExtentColor.RED));
			extent.flush();
		}

	}

	public void partialResverseTransaction() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			MA_Refund.clickPartialReverseButton.click();
			MA_Refund.partialAmount.sendKeys("10");
			MA_Refund.clickYesReverseButton.click();
			String status = MA_Refund.settlementStatus.getText();
			test = extent.createTest("Partially Reverse Transaction ").pass(MarkupHelper.createLabel(
					"Transaction  has been Partially reversed Successfully and Status of Transaction has been marked as "
							+ status,
					ExtentColor.GREEN));
		} catch (Exception e) {
			System.out.println(e);
			test = extent.createTest("Partially Reverse Trannsaction").fail(MarkupHelper
					.createLabel("Transaction  has been failed to partially reversed Successfully!.", ExtentColor.RED));
			extent.flush();
		}

	}

	public void navigateToMerchantPortalReversalScreen() throws Throwable {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().defaultContent();
			MA_Refund.reversalScreentab.click();
			MA_Refund.reversalReport.click();
			driver.switchTo().frame("applicationContent");
			MA_Refund.clickSearchReversalReport.click();
			MA_Refund.clickOpenReversedTransaction.click();
			String status = MA_Refund.reversalStatus.getText();
			System.out.println("Transaction Reversal status has been marked as " + status);
			extent.createTest("Transaction Status on Reversal Report")
					.pass(MarkupHelper.createLabel(
							"Transaction  Status on Reversal Report has been marked Successfully as " + status,
							ExtentColor.GREEN));
			extent.flush();
		} catch (Exception e) {
			System.out.println(e);
			extent.createTest("Transaction Status")
					.fail(MarkupHelper.createLabel("Reversal Failed, no Reversal Status available!.", ExtentColor.RED));
			extent.flush();
		}

	}
}
