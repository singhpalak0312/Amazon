package Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

/**
 * @author Developer
 *This Class is to start connection with device and application
 */


public class launch extends ExtentReportCreation{

	public static AndroidDriver<AndroidElement> driver;
	
	public static AppiumDriverLocalService service;

	public AppiumDriverLocalService startServer() {
		boolean flag = checkIfServerIsRunning(4723);
		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}

	public AndroidDriver<AndroidElement> capabilities() throws IOException {
		DesiredCapabilities cap = new DesiredCapabilities();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Developer\\eclipse-workspace\\Amazon\\src\\main\\java\\Framework\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
	
		//File f = new File("src");
		// File fs = new File(f,"Amazon_shopping.apk");
		String DeviceName = (String) prop.get("device1");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName);
		//cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		cap.setCapability("appActivity", "com.amazon.mShop.android.home.HomeActivity");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
		cap.setCapability("newCommandTimeout", 100000);

		cap.setCapability("--session-override", true);
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

	}

	public static String getScreenshot(String s) throws IOException {
		/**
		 * @author Developer
		 *This method is to take screen shot
		 */
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshots/" + s + ".png";
		File destfile = new File(destination);
		FileUtils.copyFile(srcfile, destfile);
		return destination;
	}
	
	public static boolean checkIfServerIsRunning(int port) {
		boolean IsServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			IsServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return IsServerRunning;
	}

}
