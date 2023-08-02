package com.solvd.qa.carina.demo.mobile.gui.pages.common.clock;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DateAndTimePageBase extends AbstractPage {

    public DateAndTimePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void switch24HourFormat();

    public abstract boolean isTime24HFormat();
}
