package org.codataster.guicey_web_test_sample.interactions.web;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static org.codataster.guicey_web_test_sample.interactions.web.home.HomePage.HomePageUrl;

public class PageITModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(String.class).annotatedWith(HomePageUrl.class).toInstance("http://www.google.com");
        bind(WebDriver.class).to(FirefoxDriver.class).in(Singleton.class);
    }
}
