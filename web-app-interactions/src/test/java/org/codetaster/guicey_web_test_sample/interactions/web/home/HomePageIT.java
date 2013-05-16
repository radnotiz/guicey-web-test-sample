package org.codetaster.guicey_web_test_sample.interactions.web.home;

import com.google.inject.Inject;
import org.codetaster.guicey_web_test_sample.interactions.web.PageITModule;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Guice(modules = PageITModule.class)
public class HomePageIT {
    @Inject
    private HomePage homePage;
    @Inject
    private WebDriver webDriver;


    @BeforeMethod
    public void setUp() throws Exception {
        homePage.open();
    }

    @AfterClass
    public void tearDown() throws Exception {
        homePage.close();
    }

    @Test
    public void open() throws Exception {
        assertThat(webDriver.getCurrentUrl(), containsString("google"));
    }

    @Test
    public void clickSignIn() throws Exception {
        homePage.clickSignIn();
    }
}
