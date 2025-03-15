package RepoPage;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private WebDriver driver;

    // Locators
    private By registerLink = By.xpath("//a[normalize-space()='Register']");
    private By usernameField = By.xpath("//input[@placeholder='Username']");
    private By passwordField = By.xpath("//input[@placeholder='Password']");
    private By registerButton = By.xpath("//button[normalize-space()='Register']");

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public String handleAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();
        return alertMessage;
    }
}
