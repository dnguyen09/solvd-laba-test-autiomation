package com.solvd.qa.carina.demo.mobile.gui.pages.android.clock;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.clock.DateAndTimePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DateAndTimePageBase.class)
public class DateAndTimePage extends DateAndTimePageBase {

    @ExtendedFindBy(accessibilityId = "Date & time")
    private ExtendedWebElement title;

    @FindBy(className = "android.widget.Switch")
    private List<ExtendedWebElement> switchList;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/summary']")
    private List<ExtendedWebElement> summaryList;


    public DateAndTimePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }

    @Override
    public void switch24HourFormat() {
        if (switchList.get(4).getAttribute("checked").equals("false")) {
            switchList.get(4).click();
        }
    }

    @Override
    public boolean isTime24HFormat() {
        return summaryList.get(4).getText().equals("13:00");
    }
}
