package Phonebook.test;

import Phonebook.core.TestBase;
import phoneBook.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import phoneBook.utils.MyDataProvider;

public class LoginTest extends TestBase {
    @Test
    public void loginExistedUserPositiveTest() {
        app.getUserHelper().login("portishead@gmail.com", "Password@1");
        app.getUserHelper().checkSuccessLogin();
    }

    @Test
    public void loginExistedUserObject1PositiveTest() {
        app.getUserHelper().login(new User()
                .setEmail("portishead@gmail.com")
                .setPassword("Password@1")
        );
        app.getUserHelper().checkSuccessLogin();
    }

    @Test
    public void loginExistedUserObject2PositiveTest() {
        User user = new User();
        user.setEmail("portishead@gmail.com");
        user.setPassword("Password@1");

        app.getUserHelper().login(user);
        app.getUserHelper().checkSuccessLogin();
    }

    @Test
    public void loginWOEmail1NegativeTest() {
        User user = new User();
        user.setPassword("Password@1");
        app.getUserHelper().login(user);
        Assert.assertTrue(app.getContactHelper().isAlertPresent());
    }

    @Test
    public void loginWOEmail2NegativeTest() {
        app.getUserHelper().login(new User()
                .setPassword("Password@1")
        );
        Assert.assertTrue(app.getContactHelper().isAlertPresent());
    }

    @Test
    public void loginWOPasswordNegativeTest() {
        app.getUserHelper().login(new User()
                .setEmail("portishead@gmail.com")
        );
        Assert.assertTrue(app.getContactHelper().isAlertPresent());
    }}


