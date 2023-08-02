package com.solvd.qa.carina.demo.mobile.gui.pages.common.clock;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class NavigationBarPageBase extends AbstractPage {

    public NavigationBarPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract TimerPageBase switchToTimer();

    public abstract AlarmPageBase switchToAlarm();
}
