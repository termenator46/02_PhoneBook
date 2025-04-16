package Homework;

import org.testng.Assert;
import org.testng.annotations.Test;
import phoneBook.model.Contact;
import phoneBook.utils.MyDataProvider;

import static Phonebook.core.TestBase.app;

public class Homework1 extends TestDataBese {

    @Test(dataProvider = "RegisteruserCsv", dataProviderClass = MyDataProvider.class)
    public void addCOntactFromDataProviderCsvFileTest(Contact contact) {
        app.getContactHelper().addNewContactPositiveData(contact);

        Assert.assertTrue(app.getContactHelper().isContactAdded(contact.getName()));

    }
}



