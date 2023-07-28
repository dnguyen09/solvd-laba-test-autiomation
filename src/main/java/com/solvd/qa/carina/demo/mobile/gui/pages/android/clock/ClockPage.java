package com.solvd.qa.carina.demo.mobile.gui.pages.android.clock;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.clock.ClockPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ClockPageBase.class)
public class ClockPage extends ClockPageBase {

    @FindBy(id = "action_bar_title")
    private ExtendedWebElement title;

    @FindBy(id = "fab")
    private ExtendedWebElement addCityButton;

    @FindBy(id = "open_search_view_edit_text")
    private ExtendedWebElement searchText;

    @FindBy(className = "android.widget.LinearLayout")
    private List<ExtendedWebElement> cities;

    @FindBy(id = "city_name")
    private ExtendedWebElement citytext;

    @ExtendedFindBy(text = "%s")
    private ExtendedWebElement cityText;

    public ClockPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickAddCityButton() {
        addCityButton.click();

    }

    @Override
    public void typeCity(String cityName) {
        searchText.type(cityName);
    }

    @Override
    public void selectCity() {
        if (cities.size() > 0) {
            cities.get(1).click();
        }
    }

    @Override
    public String getCityName() {
        return citytext.getText().toLowerCase();
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public boolean isAddCityButtonActive() {
        return Boolean.parseBoolean(addCityButton.getAttribute("enabled"));
    }

}
