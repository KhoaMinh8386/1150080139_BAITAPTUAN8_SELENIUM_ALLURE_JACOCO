package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {
    private WebDriver driver;

    @FindBy(id = "userName")
    private WebElement userNameInput;

    @FindBy(id = "userEmail")
    private WebElement userEmailInput;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "output")
    private WebElement outputBox;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Điền thông tin vào form và nhấn Submit.
     */
    public void fillAndSubmit(String name, String email, String address) {
        if (name != null)
            userNameInput.sendKeys(name);
        if (email != null)
            userEmailInput.sendKeys(email);
        if (address != null)
            currentAddressInput.sendKeys(address);

        // Scroll to submit button to avoid being obscured by ads
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                submitButton);
        submitButton.click();
    }

    /**
     * Kiểm tra xem khung output có hiển thị kết quả hay không.
     */
    public boolean isOutputDisplayed() {
        try {
            // Kiểm tra xem phần tử output có chứa text hay không (vì id=output luôn tồn tại
            // nhưng ban đầu có thể chưa hiển thị nội dung)
            return outputBox.isDisplayed() && !outputBox.getText().trim().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
}
