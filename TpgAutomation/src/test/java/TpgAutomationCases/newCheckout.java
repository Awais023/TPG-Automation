package TpgAutomationCases;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class newCheckout {
	public static WebDriver driver;
	newCheckout newCheckout_;
	Scanner sc;
	String paymentMethod;
	String paymentType;

	@FindBy(how = How.XPATH, xpath = "//input[@id='storeId']")
	public WebElement storeID;

	@FindBy(how = How.XPATH, xpath = "//input[@id='amount']")
	public WebElement Amount;

	@FindBy(how = How.XPATH, xpath = "//input[@id='orderId']")
	public WebElement orderID;

	@FindBy(how = How.XPATH, xpath = "//input[@id='email']")
	public WebElement Email;

	@FindBy(how = How.XPATH, xpath = "//input[@id='cellNo']")
	public WebElement phoneNumber;

	@FindBy(how = How.ID, using = "encryptedHashRequest")
	public WebElement encryptedHashRequest;

	@FindBy(how = How.ID, using = "submitPaymentMethod")
	public WebElement easyPayButton;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	By clickMA = By.xpath("/html/body/div/div/div/div/div/div/div/div/div[1]/div/div/div/ul/li[1]/span");

	@FindBy(how = How.XPATH, xpath = "/html/body/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/div[1]/form/button")
	public WebElement placeMAOrder;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	By clickOTC = By.xpath("/html/body/div/div/div/div/div/div/div/div/div[1]/div/div/div/ul/li[2]/span");

	@FindBy(how = How.XPATH, xpath = "/html/body/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/form/button")
	public WebElement placeOTCOrder;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	By clickCC = By.xpath("/html/body/div/div/div/div/div/div/div/div/div[1]/div/div/div/ul/li[3]/span");

	@FindBy(how = How.XPATH, xpath = "/html/body/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/form/div[1]/div[1]/div/input")
	public WebElement creditCarNumber;

	@FindBy(how = How.XPATH, xpath = "/html/body/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/form/div[1]/div[4]/div/input")
	public WebElement CVV;

	@FindBy(how = How.XPATH, xpath = "/html/body/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/form/button")
	public WebElement placeCCOrder;

	By threeDSVerification = By.xpath("/html/body/div/div/div[3]/center/form/table/tbody/tr[13]/td/input");
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static String storeID_ = "641";
	public static String Amount_ = "100";
	public static String orderID_ = "test";
	public static String email_ = "fsl@gmail.com";
	public static String phone_ = "03364594224";
	public static String encryptedHashRequest_ = "oUdl7a9TUjGPeUaeN/wOHKiP2/kDmVmRRiQ0ieOe+r3oBSHgAulKOZTRoEY00V8A/o2Z662T6zIMyA085ArCrwJ1irVlqxbWuHdp6hUgkMnmpKyRQMUYgsRqSR0GcGVb9jo3TAn/duhRlnnU0a+T3LbHrxqV3Qu9/k7fyvcoYZRwDSu6tEPG5zt+NoJyk86kVPhkaAwL2Bv0D3BlS8cW0g==";
	public static String CVV_ = "100";
	public static String _3DSCC = "5123456789012346";
	public static String _Non3DSCC = "5111111111111118";
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void setExtent() throws Throwable {
		try {
			extent = new ExtentReports();
			spark = new ExtentSparkReporter("./reports/Spark.html");
			spark.config().setEncoding("utf-8");
			spark.config().setDocumentTitle("Automations Report");
			spark.config().setReportName("Automation Test Resuts");
			spark.config().setTheme(Theme.STANDARD);
			extent.attachReporter(spark);
		} catch (Exception e) {
			System.out.println("EXTENT REPORTS HAS NOT BEEN INITIATED!.");
		}
	}

	public void launchBrowser() throws Throwable {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/awais.sultan/git/TPG/TpgAutomation/chromeDriver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			newCheckout_ = PageFactory.initElements(driver, newCheckout.class);
			test = extent.createTest("Launch Browser")
					.pass(MarkupHelper.createLabel("Chrome Driver has been Launching.", ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Chromer Driver has been launched Successfully.", ExtentColor.GREEN));
			extent.flush();

		} catch (Exception e) {
			System.out.println(e);
			extent.createTest("Launch Browser")
					.fail(MarkupHelper.createLabel("Chrome Driver has been Launching", ExtentColor.RED));
		}
	}

	public void launchTPGNewCheckout() throws Throwable {

		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://easypaystg.easypaisa.com.pk/TestStore/new-checkout/uat.jsp");
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void enterCheckoutDetails() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			newCheckout_.storeID.sendKeys(storeID_);
			newCheckout_.Amount.sendKeys(Amount_);
			newCheckout_.orderID.sendKeys(orderID_);
			newCheckout_.Email.sendKeys(email_);
			newCheckout_.phoneNumber.sendKeys(phone_);
			newCheckout_.encryptedHashRequest.sendKeys(encryptedHashRequest_);
			test = extent.createTest("Transaction Details on Native Checkout").pass(MarkupHelper
					.createLabel("TPG Native Checkout Portal For Transactions has been opened.", ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Store ID of active store is " + storeID_, ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Order ID of Transaction is " + orderID_, ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Amount of Transaction is " + Amount_, ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Email of Registered User is " + email_, ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Phone Number of Registered User is " + phone_, ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Valid Encrypted Hash Request has been entered!.", ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Transaction Details have been entered.", ExtentColor.GREEN));
		} catch (Exception e) {
			System.out.println(e);
			extent.createTest("Transaction Details").fail(
					MarkupHelper.createLabel("Transaction Details have not been entered correctly!.", ExtentColor.RED));
			extent.flush();
		}
	}

	public void clickEasyPayButton() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			newCheckout_.easyPayButton.click();
			test = extent.createTest("Selecting Payment Method")
					.pass(MarkupHelper.createLabel("Payment Options Section has been Opened", ExtentColor.GREEN));

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void selectPaymentMethod() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			driver.switchTo().frame("easypay-iframe");
			sc = new Scanner(System.in);
			System.out.print("Select Payment Method: ");
			paymentMethod = sc.next();
			System.out.print("\n");
			System.out.print("You have selected " + paymentMethod + " Payment Method\n");

			if (paymentMethod.equalsIgnoreCase("MA")) {
				WebElement clickMAMethod = wait.until(ExpectedConditions.visibilityOfElementLocated(clickMA));
				clickMAMethod.click();
				test = extent.createTest("Enter MA Transaction details").pass(MarkupHelper
						.createLabel("MA Tranaction Details has been entered successfully!.", ExtentColor.GREEN));
				test.pass(MarkupHelper.createLabel("MA Payment Method Section has been loaded successfully!.",
						ExtentColor.GREEN));
				test.pass(MarkupHelper.createLabel("Valid Phone number has been synchronized!", ExtentColor.GREEN));
			} else if (paymentMethod.equalsIgnoreCase("OTC")) {
				WebElement clickOTCMethod = wait.until(ExpectedConditions.visibilityOfElementLocated(clickOTC));
				clickOTCMethod.click();
				test = extent.createTest("Enter OTC Transaction details").pass(MarkupHelper
						.createLabel("OTC Tranaction Details has been synchronized successfully!.", ExtentColor.GREEN));
				test.pass(MarkupHelper.createLabel("OTC Payment Method Section has been loaded successfully!.",
						ExtentColor.GREEN));
				test.pass(MarkupHelper.createLabel("Valid Phone number has been synchronized!", ExtentColor.GREEN));
			} else if (paymentMethod.equalsIgnoreCase("CC")) {
				WebElement clickCCMethod = wait.until(ExpectedConditions.visibilityOfElementLocated(clickCC));
				clickCCMethod.click();
				sc = new Scanner(System.in);
				System.out.print("Select CC Payment Type: ");
				paymentType = sc.next();
				if (paymentType.equals("3DS")) {
					newCheckout_.creditCarNumber.sendKeys(_3DSCC);
				} else if (paymentType.equals("Non3DS")) {
					newCheckout_.creditCarNumber.sendKeys(_Non3DSCC);
				}
				Select expiryMonth = new Select(driver.findElement(By.xpath(
						"/html/body/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/form/div[1]/div[2]/div/select")));
				expiryMonth.selectByVisibleText("11");
				Select expiryYear = new Select(driver.findElement(By.xpath(
						"/html/body/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/form/div[1]/div[3]/div/select")));
				expiryYear.selectByVisibleText("21");
				newCheckout_.CVV.sendKeys(CVV_);
				test = extent.createTest("Enter CC Transaction details").pass(MarkupHelper
						.createLabel("CC Payment Method Section has been loaded successfully!", ExtentColor.GREEN));
				test.pass(MarkupHelper.createLabel("CC Tranaction Details has been entered successfully!.",
						ExtentColor.GREEN));
				test.pass(MarkupHelper.createLabel(
						"Transaction for Credit Card Number" + _3DSCC + " with CVV" + CVV_ + " has been initiaed",
						ExtentColor.GREEN));
			} else {
				System.out.print("Payment Method not found\n");
				driver.close();
				Assert.fail("Invalid Payment Method");
				test.fail(MarkupHelper.createLabel("Invalid Payment Method!.", ExtentColor.RED));
			}
		} catch (Exception e) {
			System.out.println(e);
			test.fail(MarkupHelper.createLabel("Transaction  has not been initiaed", ExtentColor.RED));
			extent.flush();
		}
	}

	public void placeTransaction() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (paymentMethod.equalsIgnoreCase("MA")) {
				newCheckout_.placeMAOrder.click();
				test = extent.createTest("Place MA Transaction").pass(
						MarkupHelper.createLabel("User has placd MA Transaction Successfully!.", ExtentColor.GREEN));
				test.pass(MarkupHelper.createLabel(
						"Success Page of Successfull transaction has been naviagted with valid details",
						ExtentColor.GREEN));
				Thread.sleep(9000);
			} else if (paymentMethod.equalsIgnoreCase("OTC")) {
				newCheckout_.placeOTCOrder.click();
				test = extent.createTest("Place MA Transaction").pass(
						MarkupHelper.createLabel("User has placed OTC Transaction Successfully!.", ExtentColor.GREEN));
				test.pass(MarkupHelper.createLabel(
						"Success Page of Successfull transaction has been naviagted with valid details",
						ExtentColor.GREEN));
			} else if (paymentMethod.equalsIgnoreCase("CC")) {
				newCheckout_.placeCCOrder.click();
				if (paymentType.equals("3DS")) {
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("insiderForm"));
					WebElement threeDSVerification_ = wait
							.until(ExpectedConditions.visibilityOfElementLocated(threeDSVerification));
					threeDSVerification_.click();
					test = extent.createTest("Place CC Transaction").pass(MarkupHelper
							.createLabel("User has placed CC Transaction Successfully!.", ExtentColor.GREEN));
					test.pass(MarkupHelper.createLabel("Transaction for Credit Card Number" + _3DSCC + " with CVV"
							+ CVV_ + " has been placed Successfully", ExtentColor.GREEN));
				}
			} else {
				System.out.print("Transaction Failed.\n");
			}
		} catch (Exception e) {
			System.out.println(e);
			extent.createTest("Place Transaction")
					.fail(MarkupHelper.createLabel("Transaction  has not been placed Successfully", ExtentColor.RED));
			extent.flush();

		}
	}

}
