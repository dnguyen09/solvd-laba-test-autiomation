package com.solvd.qa.carina.demo.mobile_test;

import com.solvd.qa.carina.demo.gui.components.clock_menu.ClockMenuBase;
import com.solvd.qa.carina.demo.mobile.gui.pages.common.clock.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.XlsDataSourceParameters;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileTestClock implements IAbstractTest, IMobileUtils, IAbstractDataProvider {

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "data_source/testData.xlsx", sheet = "City", dsUid = "TUID", dsArgs = "cityName")
    public void testAddCity(String cityName) {
        //open clock app and verify that clock page is opened
        ClockPageBase clockPage = initPage(getDriver(), ClockPageBase.class);
        Assert.assertTrue(clockPage.isPageOpened(), "Clock page isn't opened");
        Assert.assertTrue(clockPage.isAddCityButtonActive(), "Add city button isn't active");

        clockPage.clickAddCityButton();
        clockPage.typeCity(cityName);
        clockPage.selectCity();
        Assert.assertTrue(clockPage.getCityName().contains(cityName.toLowerCase()), "City isn't added");
    }

    @Test()
    public void testTimeAndDateDisplay() {
        //open clock app and verify that clock page is opened
        ClockPageBase clockPage = initPage(getDriver(), ClockPageBase.class);
        Assert.assertTrue(clockPage.isPageOpened(), "Clock page isn't opened");

        Assert.assertEquals(clockPage.getTimeFromClock(), clockPage.getCurrentTime(), "the display time does not" +
                " match the current time ");

        Assert.assertEquals(clockPage.getDateFromClock(), clockPage.getCurrentDate(), "the display time does not" +
                " match the current time ");
    }

    @Test()
    public void testTimerFunctionality() {
        //open clock app and verify that navigation bar is present
        NavigationBarPageBase navigationBarPage = initPage(getDriver(), NavigationBarPageBase.class);
        Assert.assertTrue(navigationBarPage.isPageOpened(), "Navigation page isn't opened");

        //open timer page and verify that timer page is opened
        TimerPageBase timerPage = navigationBarPage.switchToTimer();
        Assert.assertTrue(timerPage.isPageOpened(), "Timer page isn't opened");

        timerPage.set3sec();
        timerPage.clickPlayBtn();
        timerPage.wait3sec();
        Assert.assertTrue(timerPage.isPauseBtnPresent(), "Pause button isn't present");
    }

    @Test()
    public void testAlarm() {
        //open clock app and verify that navigation bar is present
        NavigationBarPageBase navigationBarPage = initPage(getDriver(), NavigationBarPageBase.class);
        Assert.assertTrue(navigationBarPage.isPageOpened(), "Navigation page isn't opened");

        //open alarm page and verify that alarm page is opened
        AlarmPageBase alarmPage = navigationBarPage.switchToAlarm();
        Assert.assertTrue(alarmPage.isPageOpened(), "Alarm page isn't opened");

        alarmPage.clickAddBtn();
        alarmPage.set6Oclock();
        alarmPage.setMin("55 minutes");
        alarmPage.clickPmBtn();
        alarmPage.clickOkBtn();

        Assert.assertTrue(alarmPage.isTimeAlarmPresent(), "Time alarm isn't present");
    }

    @Test()
    public void testChange24HourSetting() {
        //open clock app and verify that navigation bar is present
        NavigationBarPageBase navigationBarPage = initPage(getDriver(), NavigationBarPageBase.class);
        Assert.assertTrue(navigationBarPage.isPageOpened(), "Navigation page isn't opened");

        //open menu and choose setting
        ClockMenuBase menuBase = initPage(getDriver(), ClockMenuBase.class);
        SettingPageBase settingPage = menuBase.openSettingPage();
        Assert.assertTrue(settingPage.isPageOpened(), "Setting page isn't opened");

        //open date and time page
        DateAndTimePageBase dateAndTimePage = settingPage.clickChangeDateAndTime();
        Assert.assertTrue(dateAndTimePage.isPageOpened(), "Date and time page isn't opened");

        dateAndTimePage.switch24HourFormat();

        Assert.assertTrue(dateAndTimePage.isTime24HFormat(), "Time does not convert to 24H format");
    }

}
