package org.codataster.guicey_web_test_sample.interactions.web.home;


import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class HomePage {

    @BindingAnnotation
    @Target({FIELD, PARAMETER, METHOD})
    @Retention(RUNTIME)
    public @interface HomePageUrl {
    }

    private WebDriver webDriver;
    private String url;
    @FindBy(xpath = "//a[contains(@href,'ServiceLogin')]")
    private WebElement signInButton;

    @Inject
    public HomePage(WebDriver webDriver, @HomePageUrl String url) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.url = url;
    }

    public void open() {
        webDriver.get(url);
    }

    public void close() {
        webDriver.close();
    }

    public String getUrl() {
        return url;
    }

    public void clickSignIn() {
        signInButton.click();
    }
}
