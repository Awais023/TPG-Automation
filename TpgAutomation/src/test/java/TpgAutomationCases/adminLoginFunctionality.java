package TpgAutomationCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class adminLoginFunctionality extends newCheckout{
	
	adminLoginFunctionality admin_ ;
	
	@FindBy(how = How.ID, using = "j_username")
	public WebElement adminEmail;

	@FindBy(how = How.ID, using = "j_password")
	public WebElement adminPassword;

	@FindBy(how = How.ID, using = "j_id891617949_35250330")
	public WebElement adminLogin;

	
	public static String adminUserEmail_ = "superadmin@easypay.telenor.pk";
	public static String adminUserPassword_ = "system@1234";


	public void launchTPGAdminPortal() throws Throwable {
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://easypaystg.easypaisa.com.pk/easypay-admin/faces/pg/crm/Login.jsf");
			driver.manage().window().maximize();
			admin_ = PageFactory.initElements(driver, adminLoginFunctionality.class);
			test = extent.createTest("TPG Admin Portal").pass(MarkupHelper.createLabel("TPG Admin Portal has been opened Successfully!.",ExtentColor.GREEN));
			test.pass(MarkupHelper.createLabel("Email and Password fields are available for login!.",ExtentColor.GREEN));			

		} catch (Exception e) {
			System.out.println(e);
			test = extent.createTest("TPG Admin Portal").fail(MarkupHelper.createLabel("Admin Portal has not been loaded successfully!.",ExtentColor.RED));
			extent.flush();

		}
	}
	
	public void adminSignUpCredentials() throws Throwable {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String email_ = adminUserEmail_;
			String password_ = adminUserPassword_;
			admin_.adminEmail.sendKeys(email_);
			admin_.adminPassword.sendKeys(password_);
			test = extent.createTest("Enter Admin Credentials").pass(MarkupHelper.createLabel("Email and Password has been entered",ExtentColor.GREEN));

		} catch (Exception e) {
			System.out.println(e);
			test = extent.createTest("TPG Admin Portal").fail(MarkupHelper.createLabel("Incorrect Email or password entered!.",ExtentColor.RED));
			extent.flush();

		}

	}

	public void loginToAdminPortal() throws Throwable {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			admin_.adminLogin.click();
			test = extent.createTest("Admin Login").pass(MarkupHelper.createLabel("User with Email " + adminUserEmail_ + "has been logged in!.",ExtentColor.GREEN));
		} catch (Exception e) {
			System.out.println(e);
			test = extent.createTest("TPG Admin Portal").fail(MarkupHelper.createLabel("User has entered invalid credentails , So user has not been able to logged in!.",ExtentColor.RED));
			extent.flush();

		}

	}
}
