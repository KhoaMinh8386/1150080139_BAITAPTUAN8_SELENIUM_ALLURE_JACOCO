package dtm.bai2_2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest {

    @BeforeMethod
    public void setup() {
        // Initialize driver for the current thread
        DriverFactory.initDriver("chrome");
        DriverFactory.getDriver().get("https://www.saucedemo.com");
    }

    @Test
    public void testLoginLogoPresenceParallel() {
        boolean isLogoPresent = DriverFactory.getDriver().findElement(By.className("login_logo")).isDisplayed();
        System.out
                .println("CartTest Thread ID: " + Thread.currentThread().getId() + " - Logo Present: " + isLogoPresent);
        Assert.assertTrue(isLogoPresent, "Login logo not found in parallel execution!");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
