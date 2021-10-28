package TpgAutomationCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class loginMerchantfunctionality extends newCheckout {

	loginMerchantfunctionality login_;

	@FindBy(how = How.ID, using = "loginForm:email")
	public WebElement merchantEmail;

	@FindBy(how = How.ID, using = "loginForm:password")
	public WebElement merchantPassword;

	@FindBy(how = How.ID, using = "loginForm:j_id793557914_2f4cba4e")
	public WebElement merchantLogin;

	public static String userEmail_ = "ewptest12@gmail.com";
	public static String userPassword_ = "System@12345";

	public void launchTPGMerchantPortal() throws Throwable {
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://easypaystg.easypaisa.com.pk/easypay-merchant/faces/pg/site/Login.jsf");
			driver.manage().window().maximize();
			login_ = PageFactory.initElements(driver, loginMerchantfunctionality.class);
			test = extent.createTest("TPG Merchant Portal").pass(
					MarkupHelper.createLabel("TPG Merchant Portal has been opened Successfully!.", ExtentColor.GREEN));
			test.pass(
					MarkupHelper.createLabel("Email and Password fields are available for login!.", ExtentColor.GREEN));
		} catch (Exception e) {
			System.out.println(e);
			test = extent.createTest("TPG Merchant Portal").fail(
					MarkupHelper.createLabel("Merchant Portal has not been loaded successfully!.", ExtentColor.RED));
			extent.flush();
		}
	}

	public void merchantSignUpCredentials() throws Throwable {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String email_ = userEmail_;
			String password_ = userPassword_;
			login_.merchantEmail.sendKeys(email_);
			login_.merchantPassword.sendKeys(password_);
			test = extent.createTest("Enter Merchant Credentials")
					.pass(MarkupHelper.createLabel("Email and Password has been entered", ExtentColor.GREEN));
		} catch (Exception e) {
			System.out.println(e);
			test = extent.createTest("Enter Merchant Credentials")
					.fail(MarkupHelper.createLabel("Incorrect Email or password entered!.", ExtentColor.RED));
			extent.flush();
		}

	}

	public void loginToMerchantPortal() throws Throwable {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			login_.merchantLogin.click();
			test = extent.createTest("Merchant Login").pass(MarkupHelper
					.createLabel("Merchant with Email " + userEmail_ + " has been logged in!.", ExtentColor.GREEN));
		} catch (Exception e) {
			System.out.println(e);
			test = extent.createTest("Merchant Login")
					.fail(MarkupHelper.createLabel(
							"User has entered invalid credentails , So user has not been able to logged in!.",
							ExtentColor.RED));
			extent.flush();
		}

	}

}
