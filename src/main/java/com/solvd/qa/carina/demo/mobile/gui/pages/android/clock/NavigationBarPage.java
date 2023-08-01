package com.solvd.qa.carina.demo.mobile.gui.pages.android.clock;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.clock.AlarmPageBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.clock.NavigationBarPageBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.clock.TimerPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NavigationBarPageBase.class)
public class NavigationBarPage extends NavigationBarPageBase {

    @ExtendedFindBy(text = "Timer")
    private ExtendedWebElement timerIcon;

    @ExtendedFindBy(text = "Alarm")
    private ExtendedWebElement alarmIcon;


    @FindBy(className = "android.view.ViewGroup")
    private ExtendedWebElement nagivationBar;


    public NavigationBarPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(nagivationBar);
    }

    @Override
    public TimerPageBase switchToTimer() {
        timerIcon.click();
        return initPage(getDriver(), TimerPageBase.class);
    }

    @Override
    public AlarmPageBase switchToAlarm() {
        alarmIcon.click();
        return initPage(getDriver(), AlarmPageBase.class);
    }
}
