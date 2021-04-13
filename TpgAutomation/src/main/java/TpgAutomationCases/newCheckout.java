package TpgAutomationCases;

import java.awt.FlowLayout;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void launchBrowser() throws Throwable {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/awais.sultan/eclipse-workspace/TpgAutomation/chromeDriver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			newCheckout_ = PageFactory.initElements(driver, newCheckout.class);
		} catch (Exception e) {
			System.out.println(e);
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
			newCheckout_.storeID.sendKeys("9517");
			newCheckout_.Amount.sendKeys("100");
			newCheckout_.orderID.sendKeys("test");
			newCheckout_.Email.sendKeys("fsl@gmail.com");
			newCheckout_.phoneNumber.sendKeys("03418780317");
			newCheckout_.encryptedHashRequest.sendKeys(
					"IfCVqgaDn5hKs97fDmsEL4eGHt3vwfGyUsaHvu55dL4s+ATip0wKnyGx3ZD7TcL0gkCB0NaNI6tIXhig+qYhxzRCidkXEepXJiimjANTwq9qAje9Ax0a/bJ2Aersn3EzxEiLoOxd1UvOFwqitOty/H3rTijxcTBNJ2z7kYIoYZA2bdzghGrmSXDpo7/NR3T4tKOltAyk2fXD1xo1asA/dA==");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void clickEasyPayButton() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			newCheckout_.easyPayButton.click();

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
			} else if (paymentMethod.equalsIgnoreCase("OTC")) {
				WebElement clickOTCMethod = wait.until(ExpectedConditions.visibilityOfElementLocated(clickOTC));
				clickOTCMethod.click();

			} else if (paymentMethod.equalsIgnoreCase("CC")) {
				WebElement clickCCMethod = wait.until(ExpectedConditions.visibilityOfElementLocated(clickCC));
				clickCCMethod.click();
				sc = new Scanner(System.in);
				System.out.print("Select CC Payment Type: ");
				paymentType = sc.next();
				if (paymentType.equals("3DS")) {
					newCheckout_.creditCarNumber.sendKeys("5123456789012346");
				} else if (paymentType.equals("Non 3DS")) {
					newCheckout_.creditCarNumber.sendKeys("5111111111111118");
				}
				Select expiryMonth = new Select(driver.findElement(By.xpath(
						"/html/body/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/form/div[1]/div[2]/div/select")));
				expiryMonth.selectByVisibleText("11");
				Select expiryYear = new Select(driver.findElement(By.xpath(
						"/html/body/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/form/div[1]/div[3]/div/select")));
				expiryYear.selectByVisibleText("21");
				newCheckout_.CVV.sendKeys("100");
			} else {
				System.out.print("Payment Method not found\n");
				driver.close();
				Assert.fail("Invalid Payment Method");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void placeTransaction() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (paymentMethod.equalsIgnoreCase("MA")) {
				newCheckout_.placeMAOrder.click();
			} else if (paymentMethod.equalsIgnoreCase("OTC")) {
				newCheckout_.placeOTCOrder.click();
			} else if (paymentMethod.equalsIgnoreCase("CC")) {
				newCheckout_.placeCCOrder.click();
				if (paymentType.equals("3DS")) {
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("insiderForm"));
					WebElement threeDSVerification_ = wait
							.until(ExpectedConditions.visibilityOfElementLocated(threeDSVerification));
					threeDSVerification_.click();
				}
			} else {
				System.out.print("Transaction Failed.\n");
			}
		} catch (Exception e) {
			System.out.println(e);

		}
	}

}
