package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderListPage {
	public OrderListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[@class=\"header-menu\"]//a[contains(text(),\"Books\")]")
	private WebElement bookLink;
	
	@FindBy (xpath = "(//input[@value='Add to cart'])[1]")
	private WebElement itemAddToCart;
	
	@FindBy (xpath = "//span[text()='Shopping cart']")
	private WebElement cartLink;
	
	@FindBy(id="termsofservice")
	private WebElement tncCheckBox;
	
	@FindBy(id="checkout")
	private WebElement checkOutButton;
	
	@FindBy (xpath = "(//input[@title='Continue'])[1]")
	private WebElement billingAddContinueButton;
	
	@FindBy (xpath = "(//input[@title='Continue'])[2]")
	private WebElement shippingAddContinueButton ;
	
	@FindBy (xpath = "(//input[@value='Continue'])[3]")
	private WebElement shippingMethodContinueMethod;
	
	@FindBy (xpath = "(//input[@value='Continue'])[4]")
	private WebElement paymentMethodContinueButton;
	
	@FindBy (xpath="(//input[@value='Continue'])[5]")
	private WebElement paymentInfoContinueButton;
	
	@FindBy (xpath = "//input[@value='Confirm']")
	private WebElement confirmButton;
	
	@FindBy(xpath = "(//div[@class='section order-completed']/ul/li)[1]")
	private WebElement orderNoField;

	@FindBy (xpath ="//input[@value='Continue']")
	private WebElement continueShopButton;
	
	@FindBy (xpath = "//a[text()='Orders']")
	private WebElement orderLink;
	
	@FindBy (xpath = "//div[@class='section order-item']/div/strong")
	private List<WebElement> orderNoList;

	public WebElement getBookLink() {
		return bookLink;
	}

	public WebElement getItemAddToCart() {
		return itemAddToCart;
	}

	public WebElement getCartLink() {
		return cartLink;
	}

	public WebElement getTncCheckBox() {
		return tncCheckBox;
	}

	public WebElement getCheckOutButton() {
		return checkOutButton;
	}

	public WebElement getBillingAddContinueButton() {
		return billingAddContinueButton;
	}

	public WebElement getShippingAddContinueButton() {
		return shippingAddContinueButton;
	}

	public WebElement getShippingMethodContinueMethod() {
		return shippingMethodContinueMethod;
	}

	public WebElement getPaymentMethodContinueButton() {
		return paymentMethodContinueButton;
	}

	public WebElement getPaymentInfoContinueButton() {
		return paymentInfoContinueButton;
	}

	public WebElement getConfirmButton() {
		return confirmButton;
	}

	public WebElement getOrderNoField() {
		return orderNoField;
	}

	public WebElement getContinueShopButton() {
		return continueShopButton;
	}

	public WebElement getOrderLink() {
		return orderLink;
	}

	public List<WebElement> getOrderNoList() {
		return orderNoList;
	}
	
}
