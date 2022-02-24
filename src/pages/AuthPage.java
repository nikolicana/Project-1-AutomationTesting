package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage{

	public AuthPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}
	public WebElement getNameButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'after-arrow user-trigger-js user-trigger-active')]"));
	}

	public WebElement getMyAccountButn() {
		return driver.findElement(By.xpath("//*[contains(text(), 'My Account')]"));
	}
	public WebElement getLogoutButton() {
		return driver.findElement(By.xpath("//*[contains(text(), 'Logout')]"));
		
	}
//	public void logOut() {
//		getNameButton().click();
//		getLogoutButton().click();
//		
//	}

	public void logOut() {
		js.executeScript("arguments[0].click();", getLogoutButton());
	}
}
