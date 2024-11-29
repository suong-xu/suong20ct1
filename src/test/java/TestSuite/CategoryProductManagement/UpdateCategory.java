package TestSuite.CategoryProductManagement;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.UpdateCategoryScreen;
import CommonScreen.CategoryListScreen;

public class UpdateCategory extends Initialization {
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = UpdateCategoryScreen.openScreen(browser);
	}

	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		Utilities.testID = method.getName();
		if (Utilities.checkElementVisible(driver, By.xpath(CategoryListScreen.ADD_BTN_XPATH))) {
			Utilities.clickObscuredElement(driver, CategoryListScreen.UPDATE_BTN_XPATH.replace(Constant.INDEX_TEXT, "1"), UpdateCategoryScreen.UPDATE_BTN_XPATH, Constant.WAIT_ELEMENT_EXIST);
		}
	}

	@Test()
	public void QLDMSP_02_01() throws Exception {
		UpdateCategoryScreen.updateCategory(driver, Constant.BASE_TEXT, Constant.BASE_TEXT, UpdateCategoryScreen.SUCCESS_MSG);
	}
	
	@Test()
	public void QLDMSP_02_02() throws Exception {
		UpdateCategoryScreen.updateCategory(driver, Constant.EMPTY_STRING, Constant.BASE_TEXT, UpdateCategoryScreen.NAME_EMPTY_MSG);
	}
	
	@Test()
	public void QLDMSP_02_03() throws Exception {
		UpdateCategoryScreen.updateCategory(driver, Constant.FULL_SPACE_STRING, Constant.BASE_TEXT, UpdateCategoryScreen.NAME_EMPTY_MSG);
	}
	
	@Test()
	public void QLDMSP_02_04() throws Exception {
		UpdateCategoryScreen.updateCategory(driver, Constant.BASE_TEXT, Constant.BASE_TEXT, UpdateCategoryScreen.SUCCESS_MSG);
	}
	
	@Test()
	public void QLDMSP_02_05() throws Exception {
		UpdateCategoryScreen.updateCategory(driver, Constant.BASE_TEXT, Constant.EMPTY_STRING, UpdateCategoryScreen.SUCCESS_MSG);
	}
	
	@Test()
	public void QLDMSP_02_06() throws Exception {
		UpdateCategoryScreen.updateCategory(driver, Constant.BASE_TEXT, Constant.FULL_SPACE_STRING, UpdateCategoryScreen.SUCCESS_MSG);
	}
	
	@Test()
	public void QLDMSP_02_07() throws Exception {
		UpdateCategoryScreen.updateCategory(driver, Constant.BASE_TEXT, Constant.BASE_TEXT, UpdateCategoryScreen.SUCCESS_MSG);
	}
}
