package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class LikedProductsScreen {
	public static final String LIKED_PRODUCTS_TBL_CLASS			= "data-table";
	public static final String RECORD_PRODUCTS_XPATH			= "//tbody/tr";
	
	public static final String REMOVE_BTN_XPATH					= "(//*[@class='btn-remove btn-remove-wishlist'])[INDEX]";
	public static final String CANCEL_BTN_XPATH					= "//button[@class='swal-button swal-button--cancel']";
	public static final String OK_BTN_XPATH						= "//button[@class='swal-button swal-button--confirm swal-button--danger']";
	
	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.clickObscuredElement(driver, By.className(HomeScreen.LOGIN_LINK_CLASS),
					By.xpath(LoginScreen.LOGIN_BTN_XPATH), Constant.WAIT_ELEMENT_EXIST);
			LoginScreen.login(driver, Constant.BASE_EMAIL, Constant.BASE_PASSWORD);
			Utilities.clickObscuredElement(driver, HomeScreen.USERNAME_LINK_XPATH, HomeScreen.LIKED_PRODUCTS_LINK_XPATH,
					Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.LIKED_PRODUCTS_LINK_XPATH),
					By.className(LIKED_PRODUCTS_TBL_CLASS), Constant.WAIT_ELEMENT_EXIST);
		}
		return driver;
	}
	
	public static void removeProduct(WebDriver driver, String index, boolean isOK) throws InterruptedException {
		int recordBefore = Utilities.getXpathCount(driver, RECORD_PRODUCTS_XPATH);
		Utilities.clickObscuredElement(driver, REMOVE_BTN_XPATH.replace(Constant.INDEX_TEXT, index), CANCEL_BTN_XPATH, Constant.WAIT_ELEMENT_EXIST);
		if (isOK) {
			Utilities.click(driver, By.xpath(OK_BTN_XPATH));
			Thread.sleep(1000);
			int recordAfter = Utilities.getXpathCount(driver, RECORD_PRODUCTS_XPATH);
			Utilities.assertString(Integer.toString(recordBefore - 1), Integer.toString(recordAfter));
		}
		else {
			Utilities.click(driver, By.xpath(CANCEL_BTN_XPATH));
			Thread.sleep(1000);
			int recordAfter = Utilities.getXpathCount(driver, RECORD_PRODUCTS_XPATH);
			Utilities.assertString(Integer.toString(recordBefore), Integer.toString(recordAfter));
		}
	}
}
