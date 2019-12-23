package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Framework.launch;

import utilities.scrolltoElement;

public class Purchase extends launch {

	@BeforeTest
	public void startApp() throws IOException {
		capabilities();
	}

	@Test
	public void purchase() throws InterruptedException{

		scrolltoElement scroll = new scrolltoElement();
		scroll.scrollToAnElementByText(driver,
				"Planet Superheroes PVC Peppa Pig Swing with Peppa-Pig and George-Pig Figures Planet Superheroes PVC Peppa Pig Swing with Peppa-Pig and George-Pig Figures ₹ 1,339 11% off")
				.click();
		;
	
		test.log(Status.PASS, "Scrolling to get the required item and clicked on it");
		driver.wait(5000);
		scroll.scrollToAnElementByText(driver,"Add to Cart").click();
		test.log(Status.PASS, "Clicked on  Selected item to  get it added to the cart");
		String Toast = driver.findElementByXPath("//android.widget.Toast").getAttribute("name");
		Assert.assertEquals(Toast, "Added to cart");
		test.log(Status.PASS, "Got toast message added to cart");

	}

}
