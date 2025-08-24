package awesomecucumber.utils;

import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {  //Cookies belongs to RestAssured, Cookie belongs to Selenium
    public List<Cookie> convertRestAssuredCookiesToSeleniumCookies(Cookies cookies) {
    /*
    return cookies.asList().stream()
            .map(cookie -> new Cookie.Builder(cookie.getName(), cookie.getValue())
                    .domain(cookie.getDomain())
                    .path(cookie.getPath())
                    .expiresOn(cookie.getExpiryDate())
                    .isSecure(cookie.isSecured())
                    .isHttpOnly(cookie.isHttpOnly())
                    .build())
            .toList();
}

     */

        List<io.restassured.http.Cookie> restAssuredCookies = cookies.asList(); // Convert Cookies to List<Cookie> for rest-assured cookies
        List<Cookie> seleniumCookies = new ArrayList<>(); // Create a new List to hold Selenium Cookies
        for (io.restassured.http.Cookie cookie : restAssuredCookies) { // Iterate through each RestAssured cookie
            seleniumCookies.add(new Cookie( // Create a new Selenium Cookie and add it to the list
                    cookie.getName(),
                    cookie.getValue(),
                    cookie.getDomain(),
                    cookie.getPath(),
                    cookie.getExpiryDate(),
                    cookie.isSecured(),
                    cookie.isHttpOnly(),
                    cookie.getSameSite()
            ));

        }
        return seleniumCookies;
    }
}