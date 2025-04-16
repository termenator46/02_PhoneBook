package phoneBook.Core;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class BaseHelper {
    public WebDriverWait wait;
    public WebDriver driver;

    public BaseHelper(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;


    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert().accept();
            return true;
        }
    }

    public String getTextFromAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Текст внутри алерта: `" + alertText + "`");
        return alertText;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        //driver.findElement(locator).click();
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public String tekeScreenShost() {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File screen = new File("screenshots/screen_" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp,screen);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
      return  screen.getAbsolutePath();
    }
}
