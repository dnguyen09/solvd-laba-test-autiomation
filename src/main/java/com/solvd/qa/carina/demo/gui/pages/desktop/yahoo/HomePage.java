package com.solvd.qa.carina.demo.gui.pages.desktop.yahoo;

import com.solvd.qa.carina.demo.gui.components.WeatherItem;
import com.solvd.qa.carina.demo.gui.pages.common.yahoo.HomePageBase;
import com.solvd.qa.carina.demo.gui.pages.common.yahoo.LoginPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends HomePageBase {

    @FindBy(xpath = "//div [@id = 'module-weather']")
    private ExtendedWebElement weatherDiv;

    @Context(dependsOn = "weatherDiv")
    @FindBy(xpath = ".//button[@title = 'View your Locations']")
    private ExtendedWebElement locationButton;

    @Context(dependsOn = "weatherDiv")
    @FindBy(xpath = ".//input[@type = 'text']")
    private ExtendedWebElement seatchTextField;

    @Context(dependsOn = "weatherDiv")
    @FindBy(xpath = ".//li[@id='wf-autocomplete-result-1-0']")
    private ExtendedWebElement autocompletionResult;

    @FindBy(xpath = "//div[contains(@class, \"weather-card-cont\")]")
    private WeatherItem weatherCards;

    @FindBy(xpath = "//a[@id = 'root_2']")
    private ExtendedWebElement newsLink;

    @FindBy(xpath = "//a[@id = 'root_4']")
    private ExtendedWebElement sportLink;

    @FindBy(linkText = "Sign in")
    private ExtendedWebElement loginLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewsPage openNewsPage() {
        newsLink.click();
        return new NewsPage(driver);
    }

    @Override
    public WeatherItem searchCityWeather(String city) {
        locationButton.click();
        seatchTextField.type(city);
        autocompletionResult.hover();
        autocompletionResult.click();
        return weatherCards;
    }

    @Override
    public SportPage openSportPage() {
        sportLink.click();
        return new SportPage(driver);
    }

    @Override
    public LoginPageBase openLoginPage() {
        loginLink.click();
        return new LoginPage(driver);
    }


}
