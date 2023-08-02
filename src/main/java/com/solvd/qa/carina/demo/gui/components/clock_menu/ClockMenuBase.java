package com.solvd.qa.carina.demo.gui.components.clock_menu;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.clock.SettingPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ClockMenuBase extends AbstractPage {


    public ClockMenuBase(WebDriver driver) {
        super(driver);
    }

    public abstract SettingPageBase openSettingPage();
}


