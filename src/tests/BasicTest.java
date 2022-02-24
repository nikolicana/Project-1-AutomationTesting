package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AuthPage;
import pages.CartSummeryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;



public abstract class BasicTest {
	protected WebDriver driver;
	protected String baseUrl="http://demo.yo-meals.com";
	protected String password="12345678a";
	protected String username="customer@dummyid.com";
	protected LocationPopupPage lppp;
	protected JavascriptExecutor js;
	protected WebDriverWait wait;
	protected LoginPage lp;
	protected ProfilePage pp;
	protected AuthPage ap;
	protected MealPage mp;
	protected NotificationSistemPage nsp;
	protected CartSummeryPage csp;
	protected SoftAssert sf;
		
	
	@BeforeMethod

	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		lppp = new LocationPopupPage(driver, wait, js);
		lp = new LoginPage(driver, wait, js);
		pp = new ProfilePage(driver, wait, js);
		ap = new AuthPage(driver, wait, js);
		mp = new MealPage(driver, wait, js);
		nsp = new NotificationSistemPage(driver, wait, js);
		csp = new CartSummeryPage(driver, wait, js);
		sf = new SoftAssert();

	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus())
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;

				File source = ts.getScreenshotAs(OutputType.FILE);
				String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
				FileHandler.copy(source, new File("./Screenshots/" + timestamp + ".png"));
				System.out.println("Screenshot taken");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}

		driver.quit();
	}
}
