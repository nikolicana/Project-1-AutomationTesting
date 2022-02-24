package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{

	public LoginPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}

	public WebElement getUsername() {
		return driver.findElement(By.xpath("//*[@name='username']"));
	}
	public WebElement getPassword() {
		return driver.findElement(By.xpath("//*[@name='password']"));
	}
	public WebElement getRememberMeButton() {
		return driver.findElement(By.xpath("//*[@name='remember_me']"));
	}
	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}
	public WebElement getLoginButtonMainPage() {
	return driver.findElement(By.xpath("//*[@class='filled']"));
	}
	
	
	public void logIn(String username, String password) throws InterruptedException {
		getUsername().click();
		getUsername().clear();
		
		getPassword().click();
		getPassword().clear();
		
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginButton().click();
		Thread.sleep(1000);	
	}

	
}
