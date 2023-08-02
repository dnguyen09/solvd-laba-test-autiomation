package com.solvd.qa.carina.demo.mobile.gui.pages.android.clock;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.clock.DateAndTimePageBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.clock.SettingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SettingPageBase.class)
public class SettingPage extends SettingPageBase {

    @ExtendedFindBy(text = "Change date & time")
    private ExtendedWebElement changeDateAndTime;

    @ExtendedFindBy(accessibilityId = "Settings")
    private ExtendedWebElement settingTitle;

    public SettingPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(settingTitle);
    }

    @Override
    public DateAndTimePageBase clickChangeDateAndTime() {
        changeDateAndTime.click();
        return initPage(getDriver(), DateAndTimePageBase.class);
    }


}
