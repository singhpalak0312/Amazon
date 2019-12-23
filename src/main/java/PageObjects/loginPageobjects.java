package PageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author Developer
 *This class contains elements of login Page
 */
public class loginPageobjects {
	public loginPageobjects(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "in.amazon.mShop.android.shopping:id/view_your_wish_list")
	public MobileElement ViewYouewishList;

	@AndroidFindBy(id = "in.amazon.mShop.android.shopping:id/Find_purchase")
	public MobileElement Findreorderpastpurchases;

	@AndroidFindBy(id = "in.amazon.mShop.android.shopping:id/track_your_packages")
	public MobileElement Trackyourpurchases;

	@AndroidFindBy(id = "in.amazon.mShop.android.shopping:id/sign_in_button")
	public MobileElement AlreadyacustomerSignIn;

	@AndroidFindBy(id = "in.amazon.mShop.android.shopping:id/new_user")
	public MobileElement NewtoAmazonCreateaccount;

	@AndroidFindBy(id = "in.amazon.mShop.android.shopping:id/skip_sign_in_button")
	public MobileElement Skipsignin;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[index='8']/android.widget.TextView[index='0']")
	public MobileElement HindiMeinDekhe;

	@AndroidFindBy(id = "ap_email_login")
	public MobileElement LoginTextBox;

	@AndroidFindBy(id = "continue")
	public MobileElement ContinueButton;

	@AndroidFindBy(id = "ap_password")
	public MobileElement PasswordTextBox;

	@AndroidFindBy(id = "signInSubmit")
	public MobileElement LoginButton;
	
	@AndroidFindBy(xpath = "//android.view.View[text='Enter your email or mobile phone number']")
	public MobileElement ErrorEnterMobileNumber;
	
	@AndroidFindBy(xpath = "//android.view.View[text='There was a problem']")
	public MobileElement ErrorThereWasAProblem;
	
	@AndroidFindBy(xpath = "//android.view.View[text='Enter your password']")
	public MobileElement ErrorYourPasswordr;

}
