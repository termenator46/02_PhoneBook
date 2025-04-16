package phoneBook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import phoneBook.Core.BaseHelper;
import phoneBook.model.Contact;

import java.util.List;

public class ContactHelper extends BaseHelper {
    public final String CONTACT_NAME = "Contact Name";
    public final String CONTACT_LOCATOR = "contact-item_card__2SOIM";
    public final By LOCATOR = By.className(CONTACT_LOCATOR);
    public final By DELETE_Butten = By.xpath("//button[.='Remove']");

    public ContactHelper(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }


    public void AddNewContactPositiveData(String name) {

        click(By.xpath("//a[.='ADD']"));
        type(By.xpath("//input[@placeholder='Name']"), name);
        type(By.xpath("//input[@placeholder='Last Name']"), "Contact Lastname");
        type(By.xpath("//input[@placeholder='Phone']"), "1234567890");
        type(By.xpath("//input[@placeholder='email']"), "portishead@gmail.com");
        type(By.xpath("//input[@placeholder='Address']"), "Germany, Berlin");
        type(By.xpath("//input[@placeholder='description']"), "Some description");
        click(By.xpath("//button[.='Save']"));
    }

    public void addNewContactPositiveData(Contact contact) {
        click(By.xpath("//a[.='ADD']"));
        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDesc());
        click(By.xpath("//button[.='Save']"));
    }

    public void DeleteContact() {
        int contactsBefore = getContactsCount();
        System.out.println("contactsBefore:" + contactsBefore);
        click(By.xpath("//h2[contains(text(),'" + CONTACT_NAME + "')]"));
        click(By.className(CONTACT_LOCATOR));
        wait.until(driver -> getContactsCount() < contactsBefore);
        int contactsAfter = getContactsCount();
        System.out.println("contactsAfter: " + contactsAfter);
        Assert.assertEquals(contactsBefore - 1, contactsAfter);


    }

    public boolean isContactAdded(String textToFind) {
        List<WebElement> contacts = driver.findElements(By.className("contact-item_card__2SOIM"));
        for (WebElement element : contacts) {
            if (element.getText().contains(textToFind))
                return true;
        }
        return false;
    }

    public void addContact() {
        int contactsBefore = getContactsCount();
        System.out.println("Кол-во контактов ДО теста: " + contactsBefore);
        AddNewContactPositiveData(CONTACT_NAME);
        int contactsAfter = getContactsCount();
        System.out.println("Кол-во контактов ПОСЛЕ теста: " + contactsAfter);
        Assert.assertEquals(contactsAfter, contactsBefore + 1);
        Assert.assertTrue(isContactAdded(CONTACT_NAME));

    }

    public int getContactsCount() {
        return driver.findElements(By.className(CONTACT_LOCATOR)).size();
    }
}
