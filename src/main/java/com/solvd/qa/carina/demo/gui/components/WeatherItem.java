package com.solvd.qa.carina.demo.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WeatherItem extends AbstractUIObject {

    //fields
    @FindBy(xpath = ".//div[@class = 'Fw(600) Fz(12px)']")
    private List<WeatherItem> weatherTemps;

    @FindBy(xpath = ".//span[contains(@class,'C(--inkwell) ')]")
    private ExtendedWebElement highTemperature;

    @FindBy(xpath = "//span[contains(@class,'C(--dolphin) ')]")
    private ExtendedWebElement lowTemperature;

    //constructor
    public WeatherItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    //methods
    public List<WeatherItem> getWeatherTemps() {
        return weatherTemps;
    }

    public String getHighTemp() {
        return highTemperature.getText();
    }

    public String getLowTemp() {
        return lowTemperature.getText();
    }


}
