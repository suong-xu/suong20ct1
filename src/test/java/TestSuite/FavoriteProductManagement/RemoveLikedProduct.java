package TestSuite.FavoriteProductManagement;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Initialization;
import Common.Utilities;
import CommonScreen.LikedProductsScreen;
import CommonScreen.LoginScreen;
import CommonScreen.OrderedProductsScreen;

public class RemoveLikedProduct extends Initialization {	
	@BeforeClass()
	public void setUpClass() throws Exception {
		driver = LikedProductsScreen.openScreen(browser);
	}
	
	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		Utilities.testID = method.getName();
	}

	@Test()
	public void QLSPYT_03_01() throws IOException, InterruptedException {
		LikedProductsScreen.removeProduct(driver, "1", false);
	}
	
	@Test()
	public void QLSPYT_03_02() throws IOException, InterruptedException {
		LikedProductsScreen.removeProduct(driver, "1", true);
	}
}
