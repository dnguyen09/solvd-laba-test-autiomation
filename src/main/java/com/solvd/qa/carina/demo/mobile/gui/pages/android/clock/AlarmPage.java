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

    @ExtendedFindBy(accessibilityId = "%d o'clock")
    private ExtendedWebElement hourTime;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='%d minutes']")
    private ExtendedWebElement minutes;

    @FindBy(id = "material_clock_period_pm_button")
    private ExtendedWebElement pmBtn;

    @FindBy(id = "material_timepicker_ok_button")
    private ExtendedWebElement okBtn;

    @ExtendedFindBy(accessibilityId = "%s PM")
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
    public void setHour(int hour) {
        hourTime.format(hour).click();
    }

    @Override
    public void setMin(int min) {
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
    public boolean isTimeAlarmPresent(String timeSet) {
        return timeAlarm.format(timeSet).isElementPresent();
    }

}
