package phoneBook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import phoneBook.Core.BaseHelper;

public class HomepageHelper extends BaseHelper {

    public HomepageHelper(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }

    public boolean isHomeComponentPresent() {
        return isElementPresent(By.cssSelector("body>div>div:nth-child(2)>div>div>h1"));

    }
}
