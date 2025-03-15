package Testpage;

import org.testng.annotations.Test;

import Base.BaseTest;
import R_System.RegisterPage;

public class Register extends BaseTest {
    @Test
    public void ValidCredentialsRegisterPage() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.clickRegisterLink();
        registerPage.enterUsername("Kanav11");
        registerPage.enterPassword("abc123");
        registerPage.clickRegisterButton();
        
        // Handle alert and print message
        String alertText = registerPage.handleAlert();
        System.out.println("Alert Message: " + alertText);
    }
}
