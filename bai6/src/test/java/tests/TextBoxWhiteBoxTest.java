package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TextBoxPage;

import java.time.Duration;

public class TextBoxWhiteBoxTest {
    private WebDriver driver;
    private TextBoxPage textBoxPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Headless mode can be added here if needed
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/text-box");
        textBoxPage = new TextBoxPage(driver);
    }

    @Test(description = "1. Valid input -> output hiển thị")
    public void testValidInput() {
        textBoxPage.fillAndSubmit("Nguyen Van A", "test@example.com", "Hanoi, Vietnam");
        Assert.assertTrue(textBoxPage.isOutputDisplayed(), "Output should be displayed for valid input");
    }

    @Test(description = "2. Empty name")
    public void testEmptyName() {
        textBoxPage.fillAndSubmit("", "test@example.com", "Hanoi");
        Assert.assertTrue(textBoxPage.isOutputDisplayed(),
                "Output should still be displayed if name is empty but email is valid");
    }

    @Test(description = "3. Email sai định dạng")
    public void testInvalidEmail() {
        textBoxPage.fillAndSubmit("Nguyen Van A", "test#example.com", "Hanoi");
        // Website này thường không hiển thị output box nếu email sai định dạng (có viền
        // đỏ)
        Assert.assertFalse(textBoxPage.isOutputDisplayed(), "Output should not be displayed for invalid email format");
    }

    @Test(description = "4. Name chỉ có space")
    public void testNameWithSpaces() {
        textBoxPage.fillAndSubmit("   ", "test@example.com", "Hanoi");
        Assert.assertTrue(textBoxPage.isOutputDisplayed(), "Output should be displayed even if name is just spaces");
    }

    @Test(description = "5. Name có ký tự đặc biệt")
    public void testNameWithSpecialChars() {
        textBoxPage.fillAndSubmit("A @#$%^&*", "test@example.com", "Hanoi");
        Assert.assertTrue(textBoxPage.isOutputDisplayed(),
                "Output should be displayed for name with special characters");
    }

    @Test(description = "6. Email empty")
    public void testEmptyEmail() {
        textBoxPage.fillAndSubmit("Nguyen Van A", "", "Hanoi");
        Assert.assertTrue(textBoxPage.isOutputDisplayed(), "Output should be displayed if email is empty");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
