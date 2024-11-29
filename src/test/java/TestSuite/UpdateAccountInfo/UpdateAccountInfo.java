package TestSuite.UpdateAccountInfo;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.AccountInfoScreen;

public class UpdateAccountInfo extends Initialization {
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = AccountInfoScreen.openScreen(browser);
	}

	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		Utilities.testID = method.getName();
		Utilities.refreshScreen(driver);
	}

	@Test()
	public void CNTTTK_01_01() throws IOException {
		AccountInfoScreen.updateAccountInfo(driver, Constant.BASE_NAME, Constant.BASE_ADDRESS, Constant.EMPTY_STRING);
	}

	@Test()
	public void CNTTTK_01_02() throws IOException {
		AccountInfoScreen.updateAccountInfo(driver, Constant.EMPTY_STRING, Constant.BASE_ADDRESS, AccountInfoScreen.EMPTY_NAME_MSG);
	}
	
	@Test()
	public void CNTTTK_01_03() throws IOException {
		AccountInfoScreen.updateAccountInfo(driver, Constant.FULL_SPACE_STRING, Constant.BASE_ADDRESS, AccountInfoScreen.EMPTY_NAME_MSG);
	}
	
	@Test()
	public void CNTTTK_01_04() throws IOException {
		AccountInfoScreen.updateAccountInfo(driver, Constant.BASE_NAME1, Constant.BASE_ADDRESS, Constant.EMPTY_STRING);
	}
	
	@Test()
	public void CNTTTK_01_05() throws IOException {
		AccountInfoScreen.updateAccountInfo(driver, Constant.BASE_NAME2, Constant.BASE_ADDRESS, AccountInfoScreen.INVALID_NAME_MSG);
	}
	
	@Test()
	public void CNTTTK_01_06() throws IOException {
		AccountInfoScreen.updateAccountInfo(driver, Constant.BASE_NAME3, Constant.BASE_ADDRESS, AccountInfoScreen.INVALID_NAME_MSG);
	}
	
	@Test()
	public void CNTTTK_01_07() throws IOException {
		AccountInfoScreen.updateAccountInfo(driver, Constant.BASE_NAME, Constant.EMPTY_STRING, AccountInfoScreen.EMPTY_ADDRESS_MSG);
	}
	
	@Test()
	public void CNTTTK_01_08() throws IOException {
		AccountInfoScreen.updateAccountInfo(driver, Constant.BASE_NAME, Constant.FULL_SPACE_STRING, AccountInfoScreen.EMPTY_ADDRESS_MSG);
	}
	
	@Test()
	public void CNTTTK_01_09() throws IOException {
		AccountInfoScreen.updateAccountInfo(driver, Constant.BASE_NAME, Constant.BASE_ADDRESS1, Constant.EMPTY_STRING);
	}
}
