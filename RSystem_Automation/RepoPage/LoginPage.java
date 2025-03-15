package RepoPage;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By loginLink = By.xpath("//a[normalize-space()='Login']");
    private By usernameField = By.xpath("//input[@placeholder='username']");
    private By passwordField = By.xpath("//input[@placeholder='password']");
    private By loginButton = By.xpath("//button[normalize-space()='Login']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
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
