package Phonebook.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import phoneBook.Core.ApplicationManager;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;


public class TestBase {

    public static   ApplicationManager app = new ApplicationManager(System.getProperty("browser", "edge"));
    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeSuite
    public void StartTest(){
        app.init();
    }

    @BeforeMethod
    public void setUp(Method method,Object[]p) {
        logger.info("logger info" + method.getName()+" with data "+ Arrays.asList(p));
        logger.warn("logger info");
        logger.error("logger info");
        logger.debug("logger info");
        app.init();
    }
    @AfterSuite
    public void stopTest(){
        app.stop();
    }

    @AfterMethod(enabled = true)
    public void tearDown(ITestResult result) {
        if (result.isSuccess()) {

            logger.info("PASSED" + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED" + result.getMethod().getMethodName() + "Screenshot" + app.getContactHelper().tekeScreenShost());
        }
        logger.info("=====================================");
        app.stop();
    }
}





