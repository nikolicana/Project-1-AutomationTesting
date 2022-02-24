package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {
	
	
	
	@Test(priority=1)
	public void EditProfile() throws InterruptedException {
		driver.navigate().to(super.baseUrl+"/guest-user/login-form");
		lppp.getCloseButton().click();
		lp.logIn(super.username, super.password);
		Assert.assertTrue(nsp.getTextMessage().contains("Successfull"),
				"[ERROR] Login message did not appear.");
		driver.navigate().to(super.baseUrl+"/member/profile");
		
		String firstName= "Jhon";
		String lastName= "Malkovich";
		String address="New Street";
		String phoneNumber="225486513";
		String zipCode="75024";
		String country="United States";
		String state="Arkansas";
		String city="Benton";
		
		pp.personalInformationInput(firstName, lastName, address, phoneNumber, zipCode, country, state, city);
		Assert.assertTrue(nsp.getTextMessage().contains("Setup"),
				"Setup message did not appear.");
	    nsp.waitMessageToDisappear();
		ap.logOut();
		Assert.assertTrue(nsp.getTextMessage().contains("Logout Successfull!"),
				"Logout message did not appear.");
	}
	@Test(priority=2)
	public void ChangeProfileImage() throws InterruptedException {
		driver.navigate().to(baseUrl+"/guest-user/login-form");
		lppp.getCloseButton().click();
		lp.logIn(super.username, super.password);
		Assert.assertTrue(nsp.getTextMessage().contains("Successfull"),
				"[ERROR] Login message did not appear.");
		driver.navigate().to(super.baseUrl+"/member/profile");
		pp.uploadPhoto("img/25.jpg");
	
		Assert.assertTrue(
		nsp.getTextMessage().contains("Profile Image Uploaded Successfully"),"Image upload message did not appear.");

		pp.removePhoto();
		Assert.assertTrue(nsp.getTextMessage().contains("Deleted"),"Image remove message did not appear.");

		nsp.waitMessageToDisappear();
		ap.logOut();
		Assert.assertTrue(nsp.getTextMessage().contains("Logout Successfull!"),"Logout message did not appear.");
		
	}
	

}
