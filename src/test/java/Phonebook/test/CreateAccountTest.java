package Phonebook.test;

import Phonebook.core.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTest extends TestBase {
    @Test(invocationCount = 3)
    public void CreateAccountPositiveTest() {
        //? click on //a[.='LOGIN']
        app.driver.findElement(By.xpath("//a[.='LOGIN']")).click();
        //? enter email to By.name('email')
        app.driver.findElement(By.name("email")).click();
        app.driver.findElement(By.name("email")).clear();
        app.driver.findElement(By.name("email")).sendKeys("portishead@gmail.com");
        //? enter password to By.name('password')
        System.out.println("password прошол проверку" + "'email'");
        app.driver.findElement(By.name("password")).click();
        app.driver.findElement(By.name("password")).clear();
        app.driver.findElement(By.name("password")).sendKeys("Password@1");
        //? click on By.name('registration')
        app.driver.findElement(By.name("login")).click();
        // ?assert that button //button[.='Sign Out'] is present
        Assert.assertTrue(app.getHomepageHelper().isElementPresent(By.xpath("//button[.='Sign Out']")));
        Assert.assertTrue(app.getUserHelper().isSignOutButtonPresent());
    }


    @Test(invocationCount = 1)
    public void CreateAccountPositiveTest2() {
        app.getUserHelper().clickOnLoginclick();
        app.getUserHelper().extracted(System.currentTimeMillis() + "_qa@test.com");
        app.getUserHelper().enterpassword("Password@1");
        app.getUserHelper().clickOnragistreshononbuten();
        Assert.assertTrue(app.getUserHelper().isSignOutButtonPresent());
    }


    @Test(invocationCount = 1)
    public void CreateExistedAccountNegativeTest() {
        SoftAssert softAssert = new SoftAssert();
        app.getUserHelper().clickOnLoginclick();
        app.getUserHelper().extracted("jubmb24@gmail.com");
        app.getUserHelper().enterpassword("Password@1");
        app.getUserHelper().clickOnragistreshononbuten();
        softAssert.assertEquals(app.getHomepageHelper().getTextFromAlert(), "User already exist");
        softAssert.assertTrue(app.getHomepageHelper().isAlertPresent());
        softAssert.assertTrue(app.getHomepageHelper().isElementPresent(By.xpath("//div[.='Registration failed with code 409']")));
        softAssert.assertAll();
    }


}

