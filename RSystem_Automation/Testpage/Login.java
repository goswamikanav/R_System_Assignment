package Testpage;


import org.testng.annotations.Test;

import Base.BaseTest;
import R_System.LoginPage;

public class Login extends BaseTest {
    @Test
    public void ValidCredentialsLogIn() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLoginLink();
        loginPage.enterUsername("Kanav11");
        loginPage.enterPassword("abc123");
        loginPage.clickLoginButton();

        // Handle alert and print message
        String alertText = loginPage.handleAlert();
        System.out.println("Alert Message: " + alertText);
    }
}
