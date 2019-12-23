package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class scrolltoElement {
AndroidDriver<AndroidElement> driver;

/*public scrolltoElement() {
	this.driver = driver;
}

public String scrolltoElement(String Text) {
	//driver.findElement(MobileBy
		//	.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\\\"\"+text+\"\\\"))"));
	
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"+Text+\"))"));
	return Text;
}*/

public MobileElement scrollToAnElementByText(AppiumDriver<AndroidElement> driver, String text) {
    return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
            ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
}
}
