package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage  {
	
	public LocationPopupPage(WebDriver driver,WebDriverWait wait,JavascriptExecutor js) {
		super(driver, wait, js);
		
	}
	
 public WebElement getHeatherLocation() {
	 return driver.findElement(By.xpath("//*[@class= 'location-selector']//a"));
 }
 public WebElement getCloseButton() {
	 return driver.findElement(By.xpath("//*[@class='close-btn close-btn-white']"));
 }
 public WebElement getKeyword() {
	 return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
 }
 public WebElement getLocationItem(String locationName) {
	 return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	 
 }
 public WebElement getLocationInput() {
	 return driver.findElement(By.xpath("//*[@id='location_id']"));

 }
 public WebElement getSubmit() {
	 return driver.findElement(By.xpath("//*[@name='btn_submit']"));
 }
 public void openLocationDialog() {
	 getHeatherLocation().click();
 }
 public void putLocation(String locationName) throws InterruptedException {
	 getKeyword().click();
	 //getLocationItem(locationName);
	 js.executeScript("arguments[0].value=arguments[1]", getLocationInput(),getLocationItem(locationName).getAttribute("data-value"));
 //arguments[0].value=arguments[1]
	 js.executeScript("arguments[0].click()", getSubmit());
	 Thread.sleep(1000);
	 
 }
 
	
	
}
