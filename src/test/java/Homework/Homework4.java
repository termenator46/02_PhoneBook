package Homework;

import phoneBook.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework4 extends TestDataBese {


    @Test(invocationCount = 1)
    public void LogintoacauuntTest2() {
        clickTOlogin();
//        enterPersonolData("Yujgfmk@gmail.com", "Password@1");

        enterPersonolData(new User()
                .setEmail("Yujgfmk@gmail.com")
                .setPassword("Password@1"));
        clickOnLoginButton();
        Assert.assertTrue(LogoutButtonPresent());



    }

}







