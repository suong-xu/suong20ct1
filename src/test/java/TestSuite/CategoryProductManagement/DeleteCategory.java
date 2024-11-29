package TestSuite.CategoryProductManagement;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Initialization;
import Common.Utilities;
import CommonScreen.CategoryListScreen;

public class DeleteCategory extends Initialization {
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = CategoryListScreen.openScreen(browser);
	}

	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		Utilities.testID = method.getName();
	}

	@Test()
	public void QLDMSP_03_01() throws Exception {
		CategoryListScreen.deleteCategory(driver, "4", true);
	}
	
	@Test()
	public void QLDMSP_03_02() throws Exception {
		CategoryListScreen.deleteCategory(driver, "1", false);
	}
}
