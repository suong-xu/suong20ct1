package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class AddCategoryScreen {
	public static final String NAME_TXT_ID 				= "name";
	public static final String DESCRIPTION_TXT_ID 		= "description";
	public static final String ADD_BTN_XPATH 			= "//button[contains(text(),'Thêm mới')]";
	
	public static final String MSG_XPATH 				= "//div[@class='swal-modal']//div[@class='swal-text']";
	
	public static final String SUCCESS_MSG 				= "Thêm danh mục thành công";
	public static final String NAME_EMPTY_MSG 			= "Tên danh mục là bắt buộc";
	
	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL_ADMIN);
			LoginAdminScreen.login(driver, Constant.BASE_EMAIL_ADMIN, Constant.BASE_PASSWORD_ADMIN);
			Utilities.clickObscuredElement(driver, HomeAdminScreen.CATEGORY_LINK_XPATH, HomeAdminScreen.ADD_CATEGORY_LINK_XPATH, Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElement(driver, HomeAdminScreen.ADD_CATEGORY_LINK_XPATH, ADD_BTN_XPATH, Constant.WAIT_ELEMENT_EXIST);
		}
		return driver;
	}
	
	public static void addCategory(WebDriver driver, String name, String description, String expectedMsg) throws Exception {
		Utilities.inputValueAndValidate(driver, By.id(NAME_TXT_ID), name, name);
		Utilities.inputValueAndValidate(driver, By.id(DESCRIPTION_TXT_ID), description, description);
		Utilities.clickObscuredElement(driver, ADD_BTN_XPATH, MSG_XPATH, Constant.WAIT_ELEMENT_EXIST);
		Utilities.assertTextValue(driver, By.xpath(MSG_XPATH), expectedMsg);
		Thread.sleep(3000);
	}
}
