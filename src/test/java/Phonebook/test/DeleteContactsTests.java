package Phonebook.test;

import Phonebook.core.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactsTests extends TestBase {


    @BeforeMethod
    public void precondishon() {
        if  (!app.getUserHelper().isLoginLinkPresent()){
            app.getUserHelper().clickOnSignOutButton();

    }
        app.getUserHelper().login("jubmb24@gmail.com", "Password@1");
        app.getUserHelper().checkSuccessLogin();
        app.getContactHelper().addContact();
        app.getContactHelper().addContact();
 }




    @Test
    public void DleteContact1() {
        app.getContactHelper().DeleteContact();


    }

    @Test
    public void deleteAllContactsTest() {
        while (hasContact()) {
            int contactsBefore = app.getContactHelper().getContactsCount();
            System.out.println("contactsBefore:" + contactsBefore);
            app.getContactHelper().click(app.getContactHelper().LOCATOR);
            app.getContactHelper().click(app.getContactHelper().DELETE_Butten);
            app.wait.until(driver -> app.getContactHelper().getContactsCount() <contactsBefore);

        }

        if (!hasContact()){
            System.out.println("все контакти удалент"+ app.getContactHelper().getContactsCount());
        }

        Assert.assertEquals(app.getContactHelper().getContactsCount(),0,"не вск ктонтакти удаллись"+ app.getContactHelper().getContactsCount());
    }
    private boolean hasContact(){
        return  app.getContactHelper().isElementPresent(By.className(app.getContactHelper().CONTACT_LOCATOR));
    }
}


