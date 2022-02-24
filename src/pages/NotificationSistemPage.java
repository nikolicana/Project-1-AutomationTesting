package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage{

	public NotificationSistemPage(WebDriver driver,  WebDriverWait wait, JavascriptExecutor js ) {
		super(driver, wait, js);
		
	}
	
	public WebElement getMessage() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}
	
    public String getTextMessage() {
    	return getMessage().getText();
    }
    
    public void waitMessageToDisappear() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.attributeToBe(By.xpath("//*[contains(@class, 'system_message')]"),"style","display: none;"));
	}
	
}
