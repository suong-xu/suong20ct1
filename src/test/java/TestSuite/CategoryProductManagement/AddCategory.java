package TestSuite.CategoryProductManagement;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.AddCategoryScreen;
import CommonScreen.CategoryListScreen;

public class AddCategory extends Initialization {
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = AddCategoryScreen.openScreen(browser);
	}

	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		Utilities.testID = method.getName();
		if (Utilities.checkElementVisible(driver, By.xpath(CategoryListScreen.ADD_BTN_XPATH))) {
			Utilities.clickObscuredElement(driver, CategoryListScreen.ADD_BTN_XPATH, AddCategoryScreen.ADD_BTN_XPATH, Constant.WAIT_ELEMENT_EXIST);
		}
	}

	@Test()
	public void QLDMSP_01_01() throws Exception {
		AddCategoryScreen.addCategory(driver, Constant.BASE_TEXT, Constant.BASE_TEXT, AddCategoryScreen.SUCCESS_MSG);
	}
	
	@Test()
	public void QLDMSP_01_02() throws Exception {
		AddCategoryScreen.addCategory(driver, Constant.EMPTY_STRING, Constant.BASE_TEXT, AddCategoryScreen.NAME_EMPTY_MSG);
	}
	
	@Test()
	public void QLDMSP_01_03() throws Exception {
		AddCategoryScreen.addCategory(driver, Constant.FULL_SPACE_STRING, Constant.BASE_TEXT, AddCategoryScreen.NAME_EMPTY_MSG);
	}
	
	@Test()
	public void QLDMSP_01_04() throws Exception {
		AddCategoryScreen.addCategory(driver, Constant.BASE_TEXT, Constant.BASE_TEXT, AddCategoryScreen.SUCCESS_MSG);
	}
	
	@Test()
	public void QLDMSP_01_05() throws Exception {
		AddCategoryScreen.addCategory(driver, Constant.BASE_TEXT, Constant.EMPTY_STRING, AddCategoryScreen.SUCCESS_MSG);
	}
	
	@Test()
	public void QLDMSP_01_06() throws Exception {
		AddCategoryScreen.addCategory(driver, Constant.BASE_TEXT, Constant.FULL_SPACE_STRING, AddCategoryScreen.SUCCESS_MSG);
	}
	
	@Test()
	public void QLDMSP_01_07() throws Exception {
		AddCategoryScreen.addCategory(driver, Constant.BASE_TEXT, Constant.BASE_TEXT, AddCategoryScreen.SUCCESS_MSG);
	}
}
