package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.ChangePasswordScreen;
import CommonScreen.HomeScreen;
import CommonScreen.LoginScreen;


public class ChangePassword extends Initialization{	
	private String newPassword = Constant.BASE_PASSWORD;
	
	@BeforeClass()
	public void setUpClass() throws Exception{	
		driver = HomeScreen.openScreen(browser);
	}
	
	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception{	
		Utilities.testID = method.getName();
		if (Utilities.checkElementVisible(driver, By.className(HomeScreen.LOGIN_LINK_CLASS))) {
			Utilities.clickObscuredElement(driver, By.className(HomeScreen.LOGIN_LINK_CLASS), By.xpath(LoginScreen.LOGIN_BTN_XPATH), Constant.WAIT_ELEMENT_EXIST);
			LoginScreen.login(driver, Constant.BASE_EMAIL, newPassword);
			Utilities.clickObscuredElement(driver, HomeScreen.USERNAME_LINK_XPATH, HomeScreen.CHANGE_PASSWORD_LINK_XPATH, Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.CHANGE_PASSWORD_LINK_XPATH), By.xpath(ChangePasswordScreen.UPDATE_BTN_XPATH), Constant.WAIT_ELEMENT_EXIST);
			ChangePasswordScreen.changePassword(driver, newPassword, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, Constant.EMPTY_STRING);
			Utilities.clickObscuredElement(driver, By.className(HomeScreen.LOGIN_LINK_CLASS), By.xpath(LoginScreen.LOGIN_BTN_XPATH), Constant.WAIT_ELEMENT_EXIST);
			LoginScreen.login(driver, Constant.BASE_EMAIL, Constant.BASE_PASSWORD);
		}
		Utilities.clickObscuredElement(driver, HomeScreen.USERNAME_LINK_XPATH, HomeScreen.CHANGE_PASSWORD_LINK_XPATH, Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.CHANGE_PASSWORD_LINK_XPATH), By.xpath(ChangePasswordScreen.UPDATE_BTN_XPATH), Constant.WAIT_ELEMENT_EXIST);
	}
		
	@Test()
	public void TC_07_01() throws IOException{
		newPassword = Constant.BASE_PASSWORD2;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, newPassword, newPassword, Constant.EMPTY_STRING);
	}	
	
	@Test()
	public void TC_07_02() throws IOException{
		newPassword = Constant.BASE_PASSWORD2;
		ChangePasswordScreen.changePassword(driver, Constant.EMPTY_STRING, newPassword, newPassword, ChangePasswordScreen.EMPTY_OLD_PASSWORD_MSG);
	}	
	
	@Test()
	public void TC_07_03() throws IOException{
		newPassword = Constant.BASE_PASSWORD2;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD1, newPassword, newPassword, ChangePasswordScreen.MIN_PASSWORD_MSG);
	}
	
	@Test()
	public void TC_07_04() throws IOException{
		newPassword = Constant.BASE_PASSWORD2;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, newPassword, newPassword, Constant.EMPTY_STRING);
	}
	
	@Test()
	public void TC_07_05() throws IOException{
		newPassword = Constant.BASE_PASSWORD3;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, newPassword, newPassword, Constant.EMPTY_STRING);
		Utilities.clickObscuredElement(driver, By.className(HomeScreen.LOGIN_LINK_CLASS), By.xpath(LoginScreen.LOGIN_BTN_XPATH), Constant.WAIT_ELEMENT_EXIST);
		LoginScreen.login(driver, Constant.BASE_EMAIL, newPassword);
		Utilities.clickObscuredElement(driver, HomeScreen.USERNAME_LINK_XPATH, HomeScreen.CHANGE_PASSWORD_LINK_XPATH, Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.CHANGE_PASSWORD_LINK_XPATH), By.xpath(ChangePasswordScreen.UPDATE_BTN_XPATH), Constant.WAIT_ELEMENT_EXIST);
		newPassword = Constant.BASE_PASSWORD2;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD3, newPassword, newPassword, Constant.EMPTY_STRING);
	}
	
	@Test()
	public void TC_07_06() throws IOException{
		newPassword = Constant.BASE_PASSWORD2;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD4, newPassword, newPassword, ChangePasswordScreen.MAX_PASSWORD_MSG);
	}
	
	@Test()
	public void TC_07_07() throws IOException{
		newPassword = Constant.BASE_PASSWORD2;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.EMPTY_STRING, newPassword, ChangePasswordScreen.EMPTY_NEW_PASSWORD_MSG);
	}
	
	@Test()
	public void TC_07_08() throws IOException{
		newPassword = Constant.FULL_SPACE_STRING;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, newPassword, newPassword, Constant.EMPTY_STRING);
	}
	
	@Test()
	public void TC_07_09() throws IOException{
		newPassword = Constant.BASE_PASSWORD1;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, newPassword, Constant.BASE_PASSWORD2, ChangePasswordScreen.MIN_PASSWORD_MSG);
	}
	
	@Test()
	public void TC_07_10() throws IOException{
		newPassword = Constant.BASE_PASSWORD2;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, newPassword, newPassword, Constant.EMPTY_STRING);
	}
	
	@Test()
	public void TC_07_11() throws IOException{
		newPassword = Constant.BASE_PASSWORD3;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, newPassword, newPassword, Constant.EMPTY_STRING);
	}
	
	@Test()
	public void TC_07_12() throws IOException{
		newPassword = Constant.BASE_PASSWORD4;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, newPassword, Constant.BASE_PASSWORD2, ChangePasswordScreen.MAX_PASSWORD_MSG);
	}
	
	@Test()
	public void TC_07_13() throws IOException{
		newPassword = Constant.BASE_PASSWORD2;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, newPassword, Constant.EMPTY_STRING, ChangePasswordScreen.EMPTY_NEW_PASSWORD_CONFIRM_MSG);
	}
	
	@Test()
	public void TC_07_14() throws IOException{
		newPassword = Constant.BASE_PASSWORD1;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD2, newPassword, ChangePasswordScreen.MIN_PASSWORD_MSG);
	}
	
	@Test()
	public void TC_07_15() throws IOException{
		newPassword = Constant.BASE_PASSWORD4;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD2, newPassword, ChangePasswordScreen.MAX_PASSWORD_MSG);
	}
	
	@Test()
	public void TC_07_16() throws IOException{
		newPassword = Constant.BASE_PASSWORD;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, newPassword, newPassword, ChangePasswordScreen.SAME_OLD_PASSWORD_MSG);
	}
	
	@Test()
	public void TC_07_17() throws IOException{
		newPassword = Constant.BASE_PASSWORD;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD2, newPassword, newPassword, ChangePasswordScreen.INCORRECT_PASSWORD_MSG);
	}
	
	@Test()
	public void TC_07_18() throws IOException{
		newPassword = Constant.BASE_PASSWORD2;
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD2, newPassword, Constant.BASE_PASSWORD3, ChangePasswordScreen.UNMATCHING_PASSWORD_MSG);
	}
}