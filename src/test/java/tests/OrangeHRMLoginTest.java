package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class OrangeHRMLoginTest {
	
	 @Test
	    public void validLoginTest() {

	        WebDriver driver = new ChromeDriver();
	        driver.get("https://opensource-demo.orangehrmlive.com/");
	        driver.manage().window().maximize();

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Username
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")))
	                .sendKeys("Admin");

	        // Password
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")))
	                .sendKeys("admin123");

	        // Login button
	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//button[@type='submit']"))).click();

	        // Assertion - Dashboard
	        String dashboardText = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6")))
	                .getText();

	        Assert.assertEquals(dashboardText, "Dashboard");

	        driver.quit();

	}

}
