package Homework;
import phoneBook.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestDataBese {


    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/register");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }
    protected void enterthepassword(String password) {
        driver.findElement(By.name("Password")).click();
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Password")).sendKeys(password);
    }
    protected void enterEmail(String email) {
        driver.findElement(By.name("Email")).click();
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys(email);
    }
    protected void clickTOlogin() {
        driver.findElement(By.xpath("//a[normalize-space(text())='Log in']")).click();
    }
    protected void clickOnLoginButton() {
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
    }

    protected boolean LogoutButtonPresent() {
        return driver.findElements (By.className("ico-logout")).size() >0;
    }

    protected void enterPersonolData(String email, String password) {
        enterEmail(email);
        enterthepassword(password);
    }
    protected void enterPersonolData(User user) {
        enterEmail(user.getEmail());
        enterthepassword(user.getPassword());
    }
}







