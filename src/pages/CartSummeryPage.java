package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummeryPage extends BasicPage {

	public CartSummeryPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}
	
	public WebElement getClearAllBtn() {
		return driver.findElement(By.xpath("//*[@class='btn btn--third  btn--small no-radius']"));
	}

	
	public void emptyCart() {
		getClearAllBtn().click();
	}
	
}
