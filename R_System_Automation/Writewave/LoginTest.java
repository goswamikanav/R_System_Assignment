package Writewave;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginTest {
    private WebDriver driver;
    private Writewave.LoginPage loginPage;
	private DashboardPage dashboardPage;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://write-wave-gamma.vercel.app/");
        loginPage = new Writewave.LoginPage(driver);
    }

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
    	loginPage.clickLoginBtn();
    	Thread.sleep(3000);
        loginPage.enterEmail("kanav");
        loginPage.enterPassword("kanav@11");
        Thread.sleep(3000);
        loginPage.clickLogin();
        
        Thread.sleep(6000);
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.getWelcomeMessage().contains("kanav"));
        System.out.println("Login Successfull");
        
        
     
        // Create Post
        dashboardPage.clickCreatePost();
        Thread.sleep(3000);
        CreatePostPage createPostPage = new CreatePostPage(driver);
        createPostPage.enterTitle("My First Test Post");
        Thread.sleep(2000);
        createPostPage.enterContent("This is an automated test post.");
        Thread.sleep(2000);
        createPostPage.uploadfile("C:\\Users\\kanav\\Downloads\\Write Wave_MIndMap.png");
        Thread.sleep(2000);
        createPostPage.clickPublish();
        
        // Verify Post Creation
        Assert.assertTrue(createPostPage.getSuccessMessage().contains("Post published successfully"));
       
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}