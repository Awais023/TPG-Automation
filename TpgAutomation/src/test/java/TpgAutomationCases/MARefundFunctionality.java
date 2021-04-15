package TpgAutomationCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MARefundFunctionality extends newCheckout{

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

	@FindBy(how = How.ID, using = "j_id226064049_d79740f:maintable:792:subTable:0:j_id330006442_4b422154")
	public WebElement settlementStatus;

	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Reversal Report')]")
	public WebElement reversalReport;

	@FindBy(how = How.ID, using = "searchReversalForm:j_id226064049_d7974fa")
	public WebElement clickSearchReversalReport;
	
	@FindBy(how = How.XPATH, xpath = "//tbody/tr[@id='j_id226064049_d79740f:maintable:0']/td[@id='j_id226064049_d79740f:maintable:792:j_id330006442_4b4227ce']/a[1]")
	public WebElement clickOpenReversedTransaction;
	

	public void placeMATransaction() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("easypay-iframe");
		WebElement clickMAMethod = wait.until(ExpectedConditions.visibilityOfElementLocated(clickMA));
		clickMAMethod.click();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		checkout_.placeMAOrder.click();
	}
	
	public void gotoSettlementScreen() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MA_Refund = PageFactory.initElements(driver, MARefundFunctionality.class);
		MA_Refund.settlementScreentab.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MA_Refund.settlementTransactionHistorytab.click();
	}
	public void reverseTransaction() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("applicationContent");
		MA_Refund.searchTransactions.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MA_Refund.clickReverseTransIcon.click();
	}

	public void fullResverseTransaction() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MA_Refund.clickYesReverseButton.click();		
		String status = MA_Refund.settlementStatus.getText();
		System.out.println("Transaction status has been marked as "+status);
	}
	
	public void partialResverseTransaction() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MA_Refund.clickPartialReverseButton.click();
		MA_Refund.partialAmount.sendKeys("0.5");
		MA_Refund.clickYesReverseButton.click();		
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
			String status = MA_Refund.settlementStatus.getText();
			System.out.println("Transaction status has been marked as "+status);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}

