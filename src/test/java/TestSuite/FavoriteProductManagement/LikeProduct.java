package TestSuite.FavoriteProductManagement;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.HomeScreen;

public class LikeProduct extends Initialization {
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = HomeScreen.openScreen(browser);
	}

	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		Utilities.testID = method.getName();
	}
	
	@Test()
	public void QLSPYT_01_01() throws IOException {
		Utilities.mouseHover(driver, HomeScreen.PRODUCT_LINK_XPATH.replace(Constant.INDEX_TEXT, "1"));
		Utilities.clickObscuredElement(driver, HomeScreen.LIKE_BTN_XPATH.replace(Constant.INDEX_TEXT, "1"), HomeScreen.MSG_XPATH, Constant.WAIT_ELEMENT_EXIST);
		Utilities.assertTextValueVisible(driver, By.xpath(HomeScreen.MSG_XPATH), HomeScreen.LIKE_PRODUCT_MSG);
	}

	@Test()
	public void QLSPYT_01_02() throws IOException {
		Utilities.mouseHover(driver, HomeScreen.PRODUCT_LINK_XPATH.replace(Constant.INDEX_TEXT, "1"));
		Utilities.clickObscuredElement(driver, HomeScreen.LIKE_BTN_XPATH.replace(Constant.INDEX_TEXT, "1"), HomeScreen.MSG_XPATH, Constant.WAIT_ELEMENT_EXIST);
		Utilities.assertTextValueVisible(driver, By.xpath(HomeScreen.MSG_XPATH), HomeScreen.LIKE_PRODUCT_INVALID_MSG);
	}
}