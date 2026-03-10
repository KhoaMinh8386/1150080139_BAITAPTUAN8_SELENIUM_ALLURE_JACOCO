package dtm.bai2_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @Test(groups = { "smoke", "regression" })
    public void testLoginPageLoad() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Swag Labs", "Login page title is incorrect!");
    }

    @Test(groups = { "regression" })
    public void testLoginButtonDisplayed() {
        boolean isDisplayed = driver.findElement(By.id("login-button")).isDisplayed();
        Assert.assertTrue(isDisplayed, "Login button is not displayed on the page!");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
