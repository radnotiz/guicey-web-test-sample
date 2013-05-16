package org.codetaster.guicey_web_test_sample.interactions.web.home;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class HomePageTest {

    @Mock
    private WebElement signInButton;
    @Mock
    private WebDriver webDriver;
    @InjectMocks
    private HomePage homePage;


    @DataProvider
    public Object[][] stringProvider() throws Exception {
        return new Object[][]{{"a String"}, {"anOther String"}};
    }

    @BeforeMethod
    public void setUp(Object[] param) throws Exception {
        homePage = new HomePage(webDriver, param.length > 0 ? (String) param[0] : "an Url");
        initMocks(this);
    }

    @Test(dataProvider = "stringProvider")
    public void open(String anUrl) throws Exception {
        homePage.open();
        verify(webDriver).get(anUrl);
    }

    @Test
    public void close() throws Exception {
        homePage.close();
        verify(webDriver).close();
    }

    @Test(dataProvider = "stringProvider")
    public void getUrl(String anUrl) throws Exception {
        assertThat(homePage.getUrl(), is(equalTo(anUrl)));
    }

    @Test
    public void clickSignIn() throws Exception {
        homePage.clickSignIn();
        verify(signInButton).click();
    }

}
