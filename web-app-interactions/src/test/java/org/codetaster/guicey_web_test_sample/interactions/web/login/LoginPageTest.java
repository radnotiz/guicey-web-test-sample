package org.codetaster.guicey_web_test_sample.interactions.web.login;

import com.google.inject.Inject;
import org.codetaster.guicey_web_test_sample.TestListener;
import org.testng.annotations.*;

import java.util.logging.Logger;

@Guice
public class LoginPageTest {

    @Inject
    private Logger logger;

    @BeforeSuite
    public void beforeSuite() throws Exception {
        TestListener.list.add("beforeSuite " + logger.toString());
    }

    @BeforeTest
    public void beforeTest() throws Exception {
        TestListener.list.add(" beforeTest");
    }

    @BeforeGroups
    public void beforeGroups() throws Exception {
        TestListener.list.add("beforeGroups");
    }

    @BeforeClass
    public void beforeClass() throws Exception {
        TestListener.list.add("  beforeClass");
    }

    @BeforeMethod
    public void beforeMethod() throws Exception {
        TestListener.list.add("   beforeMethod");
    }

    @Test
    public void test1() throws Exception {
        TestListener.list.add("    test " + logger.toString());
    }

    @Test
    public void test2() throws Exception {
        TestListener.list.add("    test2 " + logger.toString());
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        TestListener.list.add("   afterMethod");
    }

    @AfterClass
    public void afterClass() throws Exception {
        TestListener.list.add("  afterClass");
    }

    @AfterGroups
    public void afterGroups() throws Exception {
        TestListener.list.add("afterGroups");
    }

    @AfterTest
    public void afterTest() throws Exception {
        TestListener.list.add(" afterTest");
    }

    @AfterSuite
    public void afterSuite() throws Exception {
        TestListener.list.add("afterSuite");
    }
}
