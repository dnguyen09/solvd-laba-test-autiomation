package com.solvd.qa.carina.demo.gui.components.clock_menu;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.clock.SettingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ClockMenuBase.class)
public class ClockMenu extends ClockMenuBase {
    @ExtendedFindBy(accessibilityId = "More options")
    private ExtendedWebElement moreOptions;

    @ExtendedFindBy(text = "Settings")
    private ExtendedWebElement settingTitle;

    public ClockMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public SettingPageBase openSettingPage() {
        moreOptions.click();
        settingTitle.click();
        return initPage(getDriver(), SettingPageBase.class);
    }

}
