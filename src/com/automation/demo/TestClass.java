package com.automation.demo;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestClass extends Util {

	public static String userID;
	public static String password = "password";

	@Test(priority = 1)
	public void accountCreation() throws InterruptedException {
		PageObjects pageObjects = PageFactory.initElements(driver, PageObjects.class);

		pageObjects.signIntopbar.click();

		String st = randomIdentifier(); // getting random string for unique account creation.
		userID = st + "." + st + "@gmail.com";

		Thread.sleep(3000);
		pageObjects.email_create.sendKeys(userID);
		pageObjects.email_create.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		pageObjects.CreateAccount.click();

		Thread.sleep(2000);
		pageObjects.Mrradio.click();
		pageObjects.Personalfirstname.clear();
		pageObjects.Personalfirstname.sendKeys(st);
		pageObjects.personallastname.clear();
		pageObjects.personallastname.sendKeys(st);
		pageObjects.personalpassword.sendKeys(password);
		Select day = new Select(pageObjects.personaldate);
		day.selectByValue("1");
		Select month = new Select(pageObjects.personalmonth);
		month.selectByValue("1");
		Select year = new Select(pageObjects.personalyear);
		year.selectByValue("1989");

		pageObjects.Addressfirstname.clear();
		pageObjects.Addressfirstname.sendKeys(st);
		pageObjects.Addresslastname.clear();
		pageObjects.Addresslastname.sendKeys(st);
		pageObjects.Address.sendKeys("123 " + st + " Street");
		pageObjects.city.sendKeys(st + " town");
		Select state = new Select(pageObjects.state);
		state.selectByValue("23");
		pageObjects.Zipcode.sendKeys("11111");
		/*
		 * Country field is auto populated
		 * 
		 * Select country = new Select(pageObjects.country);
		 * country.selectByValue("21");
		 */

		pageObjects.Phone.sendKeys("1111111111");
		pageObjects.aliasreference.sendKeys("myAdd");
		pageObjects.Register.click();

	}

	@Test(priority = 2)
	public void loginValidations() throws InterruptedException {
		PageObjects pageObjects = PageFactory.initElements(driver, PageObjects.class);

		

		// Invalid credentials
		pageObjects.signIntopbar.click();
		Thread.sleep(2000);
		pageObjects.login(userID, "pass");

		if (pageObjects.loginError.isDisplayed()) {
			String errorColor = pageObjects.loginError.getCssValue("background-color");
			String errorText = pageObjects.loginError.getText();
			// System.out.println(errorColor);
			assertTrue(errorColor.equals("rgba(243, 81, 92, 1)"), "BackGround Color Doesn't Match");
			assertTrue(errorText.contains("Invalid password."), "Error Message Doesn't Match");
		} else {
			fail("No error message displayed");
		}

		// success login
		pageObjects.login(userID, password);
		assertTrue(pageObjects.logout.isDisplayed());// No success message. So verifying signout button is available.

		// verify logoff button
		pageObjects.logout.click();
		assertTrue(pageObjects.signIntopbar.isDisplayed());// No logoff message. So verifying SignIn button is
															// available.

	}

	@Test(priority = 3)
	public void activities() throws InterruptedException {
		PageObjects pageObjects = PageFactory.initElements(driver, PageObjects.class);

		// signin
		pageObjects.signIntopbar.click();
		Thread.sleep(2000);
		pageObjects.login(userID, password);

		// search and check the list
		pageObjects.search.sendKeys("casual");
		pageObjects.search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		assertTrue(pageObjects.itemsList.size() == 4, "Results count doesn't match");

		// write a review
		pageObjects.item.click();
		pageObjects.review.click();
		pageObjects.Rating.click();
		pageObjects.title.sendKeys("Review Title");
		pageObjects.comment.sendKeys("Automated Review Comment");
		pageObjects.submit.click();
		if (pageObjects.commentModel.isDisplayed()) {
			assertTrue(pageObjects.commentModel.getText().contains("Your comment has been added"));
		} else {
			fail("Review submit success message did not display.");
		}
		pageObjects.commentModelOK.click();

	}

	@Test(priority = 4)
	public void activities1() throws InterruptedException {
		PageObjects pageObjects = PageFactory.initElements(driver, PageObjects.class);

		// signin
		pageObjects.signIntopbar.click();
		Thread.sleep(2000);
		pageObjects.login(userID, password);

		// search and check the list
		pageObjects.search.sendKeys("casual");
		pageObjects.search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		pageObjects.item.click();
		Thread.sleep(2000);

		// Pinterest
		pageObjects.pinterest.click();
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
			}
		}
		assertTrue(driver.getTitle().contains("Pinterest"));
		driver.close(); // closing child window
		driver.switchTo().window(parentWindow); // cntrl to parent window

		// Google+
		pageObjects.gmail.click();
		Set<String> handles1 = driver.getWindowHandles();
		for (String windowHandle : handles1) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
			}
		}
		assertTrue(driver.getTitle().contains("Google"));
		driver.close(); // closing child window
		driver.switchTo().window(parentWindow); // cntrl to parent window

		// facebook
		pageObjects.facebook.click();
		Set<String> handles2 = driver.getWindowHandles();
		for (String windowHandle : handles2) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
			}
		}
		assertTrue(driver.getTitle().contains("Facebook"));
		driver.close(); // closing child window
		driver.switchTo().window(parentWindow); // cntrl to parent window

	}

	@Test(priority = 5)
	public void shoppingCart() throws InterruptedException {
		PageObjects pageObjects = PageFactory.initElements(driver, PageObjects.class);

		// signin
		pageObjects.signIntopbar.click();
		Thread.sleep(2000);
		pageObjects.login(userID, password);

		// adding to cart
		pageObjects.search.sendKeys("casual");
		pageObjects.search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		pageObjects.firstItem.click();
		Thread.sleep(2000);
		pageObjects.addToCart.click();
		pageObjects.continueShopping.click();

		pageObjects.search.sendKeys("t-shirts");
		pageObjects.search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		pageObjects.firstItem.click();
		Thread.sleep(2000);
		pageObjects.addToCart.click();
		pageObjects.continueShopping.click();

		pageObjects.search.sendKeys("summer");
		pageObjects.search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		pageObjects.firstItem.click();
		Thread.sleep(2000);
		pageObjects.addToCart.click();
		pageObjects.proceed.click();

		pageObjects.proceedToCheckout.click();
		pageObjects.processAddress.click();

		pageObjects.acceptTerms.click();
		pageObjects.processCarrier.click();
		pageObjects.payByWire.click();
		pageObjects.iConfirmOrder.click();

		assertTrue(pageObjects.orderConfirmMessage.getText().contains("Your order on My Store is complete."));

	}

}
