package phoneBook.Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import phoneBook.fw.ContactHelper;
import phoneBook.fw.HomepageHelper;
import phoneBook.fw.UserHelper;

import java.time.Duration;

public class ApplicationManager  {
    public WebDriverWait wait;
    public WebDriver driver;
    ContactHelper contactHelper;
    HomepageHelper homepageHelper;
    UserHelper userHelper;
    private final String browser;

    public ApplicationManager( String browser) {
        this.browser = browser;
    }


    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public HomepageHelper getHomepageHelper() {
        return homepageHelper;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public void init() {
//        driver = new ChromeDriver();
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("chrome_headless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }  else {
            //driver = new ChromeDriver();
            throw new IllegalArgumentException("❌ Некорректный браузер: " + browser + ". Доступные варианты: chrome, firefox, edge, safari.");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.get("https://telranedu.web.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));


        contactHelper = new ContactHelper(driver,wait);
        homepageHelper = new HomepageHelper(driver,wait);
        userHelper = new UserHelper(driver,wait);
    }



    public void stop() {
        System.out.println("@AfterMethod");
        driver.quit();
    }



}