package com.solvd.qa.carina.demo.mobile.gui.pages.android.clock;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.clock.TimerPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TimerPageBase.class)
public class TimerPage extends TimerPageBase implements IMobileUtils {

    @FindBy(id = "play_pause")
    private ExtendedWebElement playPauseBtn;

    @FindBy(id = "action_bar_title")
    private ExtendedWebElement title;

    @FindBy(id = "timer_setup_digit_%d")
    private ExtendedWebElement number;

    @FindBy(id = "fab")
    private ExtendedWebElement playBtn;

    public TimerPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }

    @Override
    public void setSecond(int second) {
        number.format(second).click();
    }

    @Override
    public void clickPlayBtn() {
        playBtn.click();
    }

    @Override
    public void waitSecond(int second) {
        pause(second);
    }

    @Override
    public boolean isPauseBtnPresent() {
        return playPauseBtn.isElementPresent();
    }
}
