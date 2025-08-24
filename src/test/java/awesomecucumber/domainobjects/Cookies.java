package awesomecucumber.domainobjects;

import awesomecucumber.context.TestContext;
import awesomecucumber.utils.CookieUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class Cookies extends io.restassured.http.Cookies {
    //add cookie to selenium webdriver using driver.manage().addCookie(cookie)
    private io.restassured.http.Cookies cookies;

    public io.restassured.http.Cookies getCookies() {
        return cookies;
    }

    public void setCookies(io.restassured.http.Cookies cookies) {
        this.cookies = cookies;
    }

    public void injectCookiesToBrowser(WebDriver driver){
List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        for(Cookie cookie: seleniumCookies){
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh();

    }

}
