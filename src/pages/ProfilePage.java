package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}
	public WebElement getFirstNameInput() {
		return driver.findElement(By.name("user_first_name"));	
	}
	public WebElement getLastNameInput() {
		return driver.findElement(By.name("user_last_name"));
	}
	public WebElement getAddressInput() {
		return driver.findElement(By.name("user_address"));
	}
	public WebElement getPhoneInput() {
		return driver.findElement(By.name("user_phone"));
	}
	public WebElement getZipCode() {
		return driver.findElement(By.name("user_zip"));
	}
	public void selectCountry(String country) {
		Select dropdownCountry = new Select(driver.findElement(By.id("user_country_id")));
		dropdownCountry.selectByVisibleText(country);
	}

	public void selectState(String state) {
		Select dropdownState = new Select(driver.findElement(By.id("user_state_id")));
		dropdownState.selectByVisibleText(state);
	}

	public void selectCity(String city) {
		Select dropdownCity = new Select(driver.findElement(By.id("user_city")));
		dropdownCity.selectByVisibleText(city);
	}

	public WebElement getPersonalInfoSaveButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'col-lg-12 col-md-12 col-sm-12 col-lg-12 align--right')]//input"));
	}
	public WebElement getUploadBtn() {
		return driver.findElement(By.xpath("//a[@class='upload uploadFile-Js']/i"));
	}
	public WebElement getRemoveBtn() {
		return driver.findElement(By.xpath("//a[@class='remove']/i"));
	}
	public void changeProfilePicture (String imgPath) {
		js.executeScript("arguments[0].click();", this.getUploadBtn());
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(imgPath);
	}

	public void deleteProfilePicture () {
		js.executeScript("arguments[0].click();", this.getRemoveBtn());
	}

	
	public void uploadPhoto(String imgPath) throws InterruptedException {
		File profilePhoto = new File(imgPath);
		js.executeScript("arguments[0].click();", getUploadBtn());
		WebElement profilePhotoUpload = driver.findElement(By.name("file"));
		profilePhotoUpload.sendKeys(profilePhoto.getAbsolutePath());
		Thread.sleep(3000);
	}

	public void removePhoto() {
		js.executeScript("arguments[0].click();", getRemoveBtn());
	}
	

	public void personalInformationInput(String firstName, String lastName, String adress, String phoneNumber,
			String zipCode, String country, String state, String city) throws InterruptedException {
		
		getFirstNameInput().clear();
		getLastNameInput().clear();
		getAddressInput().clear();
		getPhoneInput().clear();
		getFirstNameInput().sendKeys(firstName);
		getLastNameInput().sendKeys(lastName);
		getAddressInput().sendKeys(adress);
		getPhoneInput().sendKeys(phoneNumber);
		Thread.sleep(2000);
		getZipCode().sendKeys(zipCode);
		selectCountry(country);
		Thread.sleep(2000);
		selectState(state);
		selectCity(city);
		js.executeScript("arguments[0].click();", getPersonalInfoSaveButton());
	}
}
	