package TestSuite.FavoriteProductManagement;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Initialization;
import Common.Utilities;
import CommonScreen.LikedProductsScreen;

public class ViewLikedProducts extends Initialization {	
	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception {
		Utilities.testID = method.getName();
	}

	@Test()
	public void QLSPYT_02_01() throws IOException {
		driver = LikedProductsScreen.openScreen(browser);
	}
}
