package dtm.bai2_2;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    @BeforeMethod
    public void setup() {
        // Initialize driver for the current thread using DriverFactory.
        // This ensures that parallel execution has isolated browser instances.
        DriverFactory.initDriver("chrome");
        DriverFactory.getDriver().get("https://www.saucedemo.com");
    }

    @Test
    public void testLoginPageTitleParallel() {
        String title = DriverFactory.getDriver().getTitle();
        System.out.println("LoginTest Thread ID: " + Thread.currentThread().getId() + " - Title: " + title);
        Assert.assertEquals(title, "Swag Labs", "Title mismatch in parallel execution!");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
