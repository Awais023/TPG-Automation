package TpgAutomationCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class loginMerchantfunctionality extends newCheckout{
	
	loginMerchantfunctionality login_;

	@FindBy(how = How.ID, using = "loginForm:email")
	public WebElement merchantEmail;

	@FindBy(how = How.ID, using = "loginForm:password")
	public WebElement merchantPassword;

	@FindBy(how = How.ID, using = "loginForm:j_id793557914_2f4cba4e")
	public WebElement merchantLogin;


	public void launchTPGMerchantPortal() throws Throwable {
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://easypaystg.easypaisa.com.pk/easypay-merchant/faces/pg/site/Login.jsf");
			driver.manage().window().maximize();
			login_ = PageFactory.initElements(driver, loginMerchantfunctionality.class);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void merchantSignUpCredentials() throws Throwable {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			login_.merchantEmail.sendKeys("sadaf.mumtaz@systemsltd.com");
			login_.merchantPassword.sendKeys("System@4321");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void loginToMerchantPortal() throws Throwable {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			login_.merchantLogin.click();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
