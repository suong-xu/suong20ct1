package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class ChangePasswordScreen {
	// Text field
	public static final String OLD_PASSWORD_TXT_ID 				= "getOldPass";
	public static final String NEW_PASSWORD_TXT_ID 				= "getNewPass";
	public static final String NEW_PASSWORD_CONFIRM_TXT_ID 		= "getReNewPass";
	
	// Button
	public static final String UPDATE_BTN_XPATH					= "//*[@class='btn btn-info btn-save']";
	
	// Error message xpath
	public static final String ERROR_MSG_XPATH 					= "//div[@class='alert alert-danger error-mesage']//ul//li";
	public static final String SUCCESS_MSG_XPATH 				= "//div[@class='alert alert-success success-mesage']//ul//li";
	public static final String UNSUCCESS_MSG_XPATH 				= "//div[@class='alert alert-warning unsuccess-mesage']//ul//li";
	
	// List of message
	public static final String EMPTY_OLD_PASSWORD_MSG 			= "Bạn chưa nhập mật khẩu cũ";
	public static final String EMPTY_NEW_PASSWORD_MSG 			= "Bạn chưa nhập mật khẩu mới";
	public static final String EMPTY_NEW_PASSWORD_CONFIRM_MSG 	= "Bạn cần nhập lại mật khẩu mới";
	public static final String MIN_PASSWORD_MSG 				= "Mật khẩu tối thiểu 8 kí tự";
	public static final String MAX_PASSWORD_MSG 				= "Mật khẩu tối đa 16 kí tự";
	public static final String SAME_OLD_PASSWORD_MSG 			= "Mật khẩu mới giống mật khẩu hiện tại !!";
	public static final String INCORRECT_PASSWORD_MSG 			= "Mật khẩu hiện tại không đúng";
	public static final String UNMATCHING_PASSWORD_MSG 			= "Mật khẩu mới không khớp !!";
	public static final String CHANGE_PASSWORD_SUCCESS_MSG 		= "Đổi mật khẩu thành công. Mời quý khách hàng đăng nhập lại!";

	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.LOGIN_LINK_CLASS), By.xpath(LoginScreen.LOGIN_BTN_XPATH), Constant.WAIT_ELEMENT_EXIST);
			LoginScreen.login(driver, Constant.BASE_EMAIL, Constant.BASE_PASSWORD);
			Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.USERNAME_LINK_XPATH), By.xpath(HomeScreen.CHANGE_PASSWORD_LINK_XPATH), Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.CHANGE_PASSWORD_LINK_XPATH), By.xpath(UPDATE_BTN_XPATH), Constant.WAIT_ELEMENT_EXIST);
		}
		return driver;
	}
	
	public static void changePassword(WebDriver driver, String oldPassword, String newPassword, String newPasswordConfirm, String expectErrMsg) {
		Utilities.inputValueAndValidate(driver, By.id(OLD_PASSWORD_TXT_ID), oldPassword, oldPassword);
		Utilities.inputValueAndValidate(driver, By.id(NEW_PASSWORD_TXT_ID), newPassword, newPassword);
		Utilities.inputValueAndValidate(driver, By.id(NEW_PASSWORD_CONFIRM_TXT_ID), newPasswordConfirm, newPasswordConfirm);
		
		if (expectErrMsg.equals(Constant.EMPTY_STRING)) {
			Utilities.clickObscuredElement(driver, By.xpath(UPDATE_BTN_XPATH), By.xpath(SUCCESS_MSG_XPATH), Constant.WAIT_ELEMENT_EXIST);
			Utilities.assertTextValue(driver, By.xpath(SUCCESS_MSG_XPATH), CHANGE_PASSWORD_SUCCESS_MSG);
		}
		else if (expectErrMsg.equals(SAME_OLD_PASSWORD_MSG) || expectErrMsg.equals(INCORRECT_PASSWORD_MSG) || expectErrMsg.equals(UNMATCHING_PASSWORD_MSG)) {
			Utilities.clickObscuredElement(driver, By.xpath(UPDATE_BTN_XPATH), By.xpath(UNSUCCESS_MSG_XPATH), Constant.WAIT_ELEMENT_EXIST);
			Utilities.assertTextValue(driver, By.xpath(UNSUCCESS_MSG_XPATH), expectErrMsg);
		}
		else {
			Utilities.clickObscuredElement(driver, By.xpath(UPDATE_BTN_XPATH), By.xpath(ERROR_MSG_XPATH), Constant.WAIT_ELEMENT_EXIST);
			Utilities.assertTextValue(driver, By.xpath(ERROR_MSG_XPATH), expectErrMsg);
		}
	}
}
