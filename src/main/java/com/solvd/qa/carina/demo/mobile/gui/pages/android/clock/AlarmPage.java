package com.solvd.qa.carina.demo.mobile.gui.pages.android.clock;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.clock.AlarmPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AlarmPageBase.class)
public class AlarmPage extends AlarmPageBase {

    @FindBy(id = "action_bar_title")
    private ExtendedWebElement title;

    @FindBy(id = "fab")
    private ExtendedWebElement addBtn;

    @ExtendedFindBy(accessibilityId = "6 o'clock")
    private ExtendedWebElement sixOclock;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='%s']")
    private ExtendedWebElement minutes;

    @FindBy(id = "material_clock_period_pm_button")
    private ExtendedWebElement pmBtn;

    @FindBy(id = "material_timepicker_ok_button")
    private ExtendedWebElement okBtn;

    @ExtendedFindBy(accessibilityId = "6:55 PM")
    private ExtendedWebElement timeAlarm;

    public AlarmPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }

    @Override
    public void clickAddBtn() {
        addBtn.click();
    }

    @Override
    public void set6Oclock() {
        sixOclock.click();
    }

    @Override
    public void setMin(String min) {
        minutes.format(min).click();
    }

    @Override
    public void clickPmBtn() {
        pmBtn.click();
    }

    @Override
    public void clickOkBtn() {
        okBtn.click();
    }

    @Override
    public boolean isTimeAlarmPresent() {
        return timeAlarm.isElementPresent();
    }

}
