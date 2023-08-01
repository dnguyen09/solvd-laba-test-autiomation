package com.solvd.qa.carina.demo.mobile.gui.pages.common.clock;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SettingPageBase extends AbstractPage {


    public SettingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract DateAndTimePageBase clickChangeDateAndTime();


}
