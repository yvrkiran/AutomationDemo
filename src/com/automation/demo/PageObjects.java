package com.automation.demo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class PageObjects extends Util {
	WebDriver driver;

	// Constructor
	public PageObjects(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(className = "login")
	public WebElement signIntopbar;

	@FindBy(id = "email_create")
	public WebElement email_create;

	@FindBy(id = "SubmitCreate")
	public WebElement CreateAccount;

	@FindBy(id = "email")
	public WebElement Emailsignin;

	@FindBy(id = "passwd")
	public WebElement Password;

	@FindBy(id = "SubmitLogin")
	public WebElement signin;

	@FindBy(className = "logout")
	public WebElement logout;

	@FindBy(xpath = "//*[@id=\"center_column\"]/div[contains(@class, 'alert-danger')]")
	public WebElement loginError;

	// Account creation page
	@FindBy(id = "id_gender1")
	public WebElement Mrradio;

	@FindBy(id = "uniform-id_gender2")
	public WebElement Mrsradio;

	@FindBy(id = "customer_firstname")
	public WebElement Personalfirstname;

	@FindBy(id = "customer_lastname")
	public WebElement personallastname;

	@FindBy(id = "email")
	public WebElement personalEmail;

	@FindBy(id = "passwd")
	public WebElement personalpassword;

	@FindBy(id = "days")
	public WebElement personaldate;

	@FindBy(id = "months")
	public WebElement personalmonth;

	@FindBy(id = "years")
	public WebElement personalyear;

	@FindBy(id = "firstname")
	public WebElement Addressfirstname;

	@FindBy(id = "lastname")
	public WebElement Addresslastname;

	@FindBy(id = "address1")
	public WebElement Address;

	@FindBy(id = "city")
	public WebElement city;

	@FindBy(id = "id_state")
	public WebElement state;

	@FindBy(id = "postcode")
	public WebElement Zipcode;

	@FindBy(id = "id_country")
	public WebElement country;

	@FindBy(id = "phone_mobile")
	public WebElement Phone;

	@FindBy(id = "alias")
	public WebElement aliasreference;

	@FindBy(id = "submitAccount")
	public WebElement Register;

	@FindBy(id = "search_query_top")
	public WebElement search;

	// tops order page
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	public WebElement topwomen;

	@FindBys({ @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li") })
	public List<WebElement> itemsList;

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[3]/div/div[1]")
	public WebElement item;

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]")
	public WebElement firstItem;

	// write a review page
	@FindBy(xpath = "//*[@id=\"product_comments_block_extra\"]/ul/li/a")
	public WebElement review;

	@FindBy(id = "comment_title")
	public WebElement title;

	@FindBy(id = "content")
	public WebElement comment;

	@FindBy(xpath = "//*[@id=\"criterions_list\"]/li/div[1]/div[4]/a")
	public WebElement Rating;

	@FindBy(id = "submitNewMessage")
	public WebElement submit;

	@FindBy(className = "fancybox-inner")
	public WebElement commentModel;

	@FindBy(xpath = "//button[@type='submit' and @value='true']")
	public WebElement commentModelOK;

	@FindBy(xpath = "//button[@class='btn btn-default btn-pinterest']")
	public WebElement pinterest;

	// pinterest login page
	@FindBy(className = "tBJ dyH iFc yTZ erh tg7 mWe")
	public WebElement pinterestlogin;

	// Back to review page
	@FindBy(xpath = "//button[@class='btn btn-default btn-google-plus']")
	public WebElement gmail;

	@FindBy(xpath = "//button[@class='btn btn-default btn-facebook']")
	public WebElement facebook;

	@FindBy(xpath = "//button[@name ='Submit']")
	public WebElement addToCart;

	@FindBy(xpath = "//span[@title='Continue shopping']")
	public WebElement continueShopping;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	public WebElement proceed;

	@FindBy(xpath = "//*[@id=\"center_column\"]//a[@title='Proceed to checkout']")
	public WebElement proceedToCheckout;

	@FindBy(name = "processAddress")
	public WebElement processAddress;

	@FindBy(id = "cgv")
	public WebElement acceptTerms;

	@FindBy(name = "processCarrier")
	public WebElement processCarrier;

	@FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]//a[@title='Pay by bank wire']")
	public WebElement payByWire;

	@FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
	public WebElement iConfirmOrder;

	@FindBy(className = "box")
	public WebElement orderConfirmMessage;

	public void login(String userid, String pass) {
		Emailsignin.clear();
		Emailsignin.sendKeys(userid);
		Password.clear();
		Password.sendKeys(pass);
		signin.click();
	}

}
