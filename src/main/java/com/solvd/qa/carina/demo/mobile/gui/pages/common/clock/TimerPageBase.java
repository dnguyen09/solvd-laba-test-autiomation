package com.solvd.qa.carina.demo.mobile.gui.pages.common.clock;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class TimerPageBase extends AbstractPage {

    public TimerPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void setSecond(int second);

    public abstract void clickPlayBtn();

    public abstract void waitSecond(int second);

    public abstract boolean isPauseBtnPresent();


}
