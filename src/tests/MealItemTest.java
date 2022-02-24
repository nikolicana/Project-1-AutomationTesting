package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.asserts.SoftAssert;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MealItemTest extends BasicTest{
	
	@Test(priority = 1)
	public void addMealToCart() throws InterruptedException {
		driver.navigate().to(super.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		lppp.getCloseButton().click();
		mp.addToCart("4");
		Assert.assertTrue(nsp.getTextMessage().contains("Errors"), "Location error message did not appear.");
		nsp.waitMessageToDisappear();
		lppp.getHeatherLocation().click();
		lppp.putLocation("City Center - Albany");
		mp.addToCart("4");
		Assert.assertTrue(nsp.getTextMessage().contains("Added"), "Added to cart message did not appear.");

	}

	@Test(priority = 2)
	public void addMealToFavourite() throws InterruptedException {
		driver.navigate().to(super.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		lppp.getCloseButton().click();
		mp.addToFavourite();
		Assert.assertTrue(nsp.getTextMessage().contains("Please"), "Login error message did not appear.");
		Thread.sleep(2000);
		lp.getLoginButtonMainPage().click();
		lp.logIn(super.username, super.password);

		driver.navigate().to(super.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(2000);
		driver.navigate().refresh();
		mp.addToFavourite();
		Assert.assertTrue(nsp.getTextMessage().contains("added"), "Added to favourite message did not appear.");
		
	}

	@Test(priority = 3)
	public void clearTest() throws InterruptedException, IOException {
		driver.navigate().to(baseUrl + "/meals");
		lppp.putLocation("City Center - Albany");

		File file = new File("./data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meals");
		DataFormatter formatter = new DataFormatter();
		for (int i = 1; i < 5; i++) {
			String url = formatter.formatCellValue(sheet.getRow(1).getCell(0));
			driver.navigate().to(url);
			mp.addToCart("i");
			sf.assertTrue(nsp.getTextMessage().contains("Added"), "Message did not appear.");
		}

		sf.assertAll();

		csp.emptyCart();
		Assert.assertTrue(nsp.getTextMessage().contains("removed"),"Meals removed from the cart message did not appear.");
	}

}
