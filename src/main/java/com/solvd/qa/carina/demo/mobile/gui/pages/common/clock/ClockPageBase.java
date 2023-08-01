package com.solvd.qa.carina.demo.mobile.gui.pages.common.clock;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ClockPageBase extends AbstractPage {

    public ClockPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickAddCityButton();

    public abstract void typeCity(String cityName);

    public abstract void selectCity();

    public abstract boolean isAddCityButtonActive();

    public abstract String getCityName();

    public abstract String getTimeFromClock();

    public abstract String getCurrentTime();

    public abstract String getDateFromClock();

    public abstract String getCurrentDate();


}
