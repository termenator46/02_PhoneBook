package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import phoneBook.model.User;

import java.time.Duration;

public class HomeworkUserRegister {

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

    protected void enerFirstName(String firstName) {
        driver.findElement(By.cssSelector("#FirstName")).click();
        driver.findElement(By.cssSelector("#FirstName")).clear();
        driver.findElement(By.cssSelector("#FirstName")).sendKeys(firstName);
    }

    protected void enterLastName(String LastName) {
        driver.findElement(By.cssSelector("#LastName")).click();
        driver.findElement(By.cssSelector("#LastName")).clear();
        driver.findElement(By.cssSelector("#LastName")).sendKeys(LastName);
    }

    protected void enterEmail(String email) {


        driver.findElement(By.name("Email")).click();
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys(email);
    }


    protected void enterpassword(String password) {
        driver.findElement(By.name("Password")).click();
        driver.findElement(By.name("Password")).click();
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Password")).sendKeys(password);
    }

    protected void enterconnfirmPassowrd(String Confirmpassword) {
        driver.findElement(By.cssSelector("#ConfirmPassword")).clear();
        driver.findElement(By.cssSelector("#ConfirmPassword")).clear();
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(Confirmpassword);

    }

    protected void clicktoRegister() {
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
    }

    protected void buttenRegisster() {
        driver.findElement(By.xpath("//input[@id='register-button']")).click();
    }

    protected boolean LogoutButtonPresent1() {
        return driver.findElements(By.className("ico-logout")).size() > 0;
    }
}


