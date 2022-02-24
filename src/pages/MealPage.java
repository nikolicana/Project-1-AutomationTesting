package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage{

	public MealPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}
////	eal Page:
//		get metode za sve potrebne elemente
//		metodu koja dodaje jelo u korpu - kao parametar se prosleđuje količina
//		metodu koja jelo dodaje u omiljena jela, klikom na dugme Favorite 

	public WebElement getAddToCartBtn() {
		return driver.findElement(By.xpath("//*[@class='btn btn--primary btn--large js-proceedtoAddInCart ']"));
	}
	public WebElement getQuantityBtn() {
		return driver.findElement(By.xpath("//*[@name='product_qty']"));
	}
	public WebElement getFavouriteBtn() {
		return driver.findElement(By.xpath("//*[@class='favourite  itemfav link']"));
	}
	public void addToCart(String value) {
	this.getQuantityBtn().sendKeys(Keys.chord(Keys.CONTROL, "a"));
	this.getQuantityBtn().sendKeys(value);
	getAddToCartBtn().click();
	
	}
	public void addToFavourite() throws InterruptedException {
		getFavouriteBtn().click();
		Thread.sleep(1000);
	}
	
	
}
