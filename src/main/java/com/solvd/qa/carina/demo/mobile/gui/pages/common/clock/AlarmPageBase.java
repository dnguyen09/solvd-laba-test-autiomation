package com.solvd.qa.carina.demo.mobile.gui.pages.common.clock;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AlarmPageBase extends AbstractPage {

    public AlarmPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickAddBtn();

    public abstract void setHour(int hour);

    public abstract void setMin(int min);

    public abstract void clickPmBtn();

    public abstract void clickOkBtn();

    public abstract boolean isTimeAlarmPresent(String timeSet);
}
