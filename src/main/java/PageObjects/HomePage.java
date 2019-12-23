package PageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author Developer
 *This class contains elements of Home Page
 */
public class HomePage {
	
	public HomePage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	@AndroidFindBy(id= "in.amazon.mShop.android.shopping:id/search_edit_text")
	public MobileElement SearchEditBox;
	
	@AndroidFindBy(id ="in.amazon.mShop.android.shopping:id/web_home_shop_by_department_label")
	public MobileElement ShopByCategory;
	
	
	
	
}
