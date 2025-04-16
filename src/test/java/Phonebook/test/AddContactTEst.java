package Phonebook.test;

import Phonebook.core.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import phoneBook.model.Contact;
import phoneBook.model.User;
import phoneBook.utils.MyDataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AddContactTEst extends TestBase {


    private final String CONTACT_NAME = "Contact Name";

    @BeforeMethod
    public void precondition() {
        if (!app.getUserHelper().isLoginLinkPresent()) {
            app.getUserHelper().clickOnSignOutButton();

        }
        app.getUserHelper().login("jubmb24@gmail.com", "Password@1");
        app.getUserHelper().checkSuccessLogin();
    }

    @Test
    public void addContactPositiveTest() {

        int contactsBefore = app.getContactHelper().getContactsCount();
        System.out.println("Кол-во контактов ДО теста: " + contactsBefore);

        app.getContactHelper().AddNewContactPositiveData(CONTACT_NAME);

        int contactsAfter = app.getContactHelper().getContactsCount();
        System.out.println("Кол-во контактов ПОСЛЕ теста: " + contactsAfter);
        Assert.assertEquals(contactsAfter, contactsBefore + 1);
        Assert.assertTrue(app.getContactHelper().isContactAdded(CONTACT_NAME));

    }


    public int getContactsCount() {
        return app.driver.findElements(By.className("contact-item_card__2SOIM")).size();
    }

    @Test
    public void DeleteContactNegativeTest() {

        int contactsBefore = getContactsCount();
        System.out.println("Кол-во контактов ДО теста: " + contactsBefore);

        app.getContactHelper().AddNewContactPositiveData(CONTACT_NAME);

        int contactsAfter = getContactsCount();
        System.out.println("Кол-во контактов ПОСЛЕ теста: " + contactsAfter);
        Assert.assertEquals(contactsBefore, contactsAfter - 1);
        Assert.assertTrue(app.getContactHelper().isContactAdded(CONTACT_NAME));
        app.getContactHelper().click(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]"));
        app.getContactHelper().click(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/button[2]"));
        Assert.assertEquals(contactsBefore - 1, contactsAfter);

    }

    @Test
    public void addContactWoDescTest() {

        int contactsBefore = getContactsCount();
        System.out.println("Кол-во контактов ДО теста: " + contactsBefore);
        app.getContactHelper().AddNewContactPositiveData(CONTACT_NAME);
        int contactsAfter = getContactsCount();
        System.out.println("Кол-во контактов ПОСЛЕ теста: " + contactsAfter);
        app.getContactHelper().addNewContactPositiveData(new Contact()
                .setName(CONTACT_NAME)
                .setLastName("Test Last Name")
                .setPhone("1234567890")
                .setEmail("portishead@gmail.com")
                .setAddress("Germany, Berlin")
        );


    }

    @Test(dataProvider = "addNewContact", dataProviderClass = MyDataProvider.class)
    public void addCOntactFromDataProviderTest(String name, String lastname, String phone, String email, String
            address, String description) {
        app.getContactHelper().addNewContactPositiveData(new Contact()
                .setName(name)
                .setLastName(lastname)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDesc(description));
        Assert.assertTrue(app.getContactHelper().isContactAdded(name));

    }

    @Test(dataProvider = "addNewContactFroundCsv", dataProviderClass = MyDataProvider.class)
    public void addCOntactFromDataProviderCsvFileTest(Contact contact) {
        app.getContactHelper().addNewContactPositiveData(contact);

        Assert.assertTrue(app.getContactHelper().isContactAdded(contact.getName()));

    }}












