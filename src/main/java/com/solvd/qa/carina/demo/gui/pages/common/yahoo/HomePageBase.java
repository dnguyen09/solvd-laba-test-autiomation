package com.solvd.qa.carina.demo.gui.pages.common.yahoo;

import com.solvd.qa.carina.demo.gui.components.WeatherItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    //constructor
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    //methods
    public abstract NewsPageBase openNewsPage();

    public abstract WeatherItem searchCityWeather(String city);

    public abstract SportPageBase openSportPage();

    public abstract LoginPageBase openLoginPage();
}
