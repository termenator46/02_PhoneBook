package Phonebook.test;

import Phonebook.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    @Test
    public void isHomeComponentPresentPositiveTest() {
        Assert.assertTrue(app.getHomepageHelper().isHomeComponentPresent());

    }


}


