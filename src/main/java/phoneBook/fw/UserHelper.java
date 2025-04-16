package phoneBook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import phoneBook.Core.BaseHelper;
import phoneBook.model.User;

public class UserHelper extends BaseHelper {


    public UserHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

    public void clickOnragistreshononbuten() {
        driver.findElement(By.name("registration")).click();
    }

    public void clickOnLoginclick() {
        click(By.xpath("//a[.='LOGIN']"));
    }

    public void login(String email, String password) {
        clickOnLoginclick();
        type(By.name("email"), email);
        type(By.name("password"), password);
        click(By.name("login"));
        checkSuccessLogin();
    }

    public void login(User user) {
        clickOnLoginclick();
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
        click(By.name("login"));
    }

    public void checkSuccessLogin() {
        Assert.assertTrue(isSignOutButtonPresent());
    }

    public void enterpassword(String tringpassword) {
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(tringpassword);
    }

    public void extracted(String enteremail) {
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(enteremail);
    }


    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[.='LOGIN']"));
    }


    public void clickOnSignOutButton() {
        click(By.xpath("//button[.='Sign Out']"));
    }}



