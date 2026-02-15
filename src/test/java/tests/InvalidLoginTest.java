package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class InvalidLoginTest {
	
	@Test
    public void invalidLoginTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Enter valid username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")))
                .sendKeys("Admin");

        // Enter invalid password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")))
                .sendKeys("wrong123");
        Thread.sleep(3000);

        // Click Login
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']"))).click();
        Thread.sleep(3000);

        // Validate error message
        String errorMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[contains(@class,'alert-content-text')]")))
                .getText();
        Thread.sleep(3000);

        Assert.assertEquals(errorMsg, "Invalid credentials");
        Thread.sleep(3000);

        driver.quit();
    }
}
