package com.solvd.qa.carina.demo.mobile_test;

import com.solvd.qa.carina.demo.mobile.gui.pages.common.clock.ClockPageBase;
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
        ClockPageBase clockPage = initPage(getDriver(), ClockPageBase.class);
        Assert.assertTrue(clockPage.isPageOpened(), "Clock page isn't opened");
        Assert.assertTrue(clockPage.isAddCityButtonActive(), "Add city button isn't active");

        clockPage.clickAddCityButton();
        clockPage.typeCity(cityName);
        clockPage.selectCity();
        Assert.assertTrue(clockPage.getCityName().contains(cityName.toLowerCase()), "City isn't added");
    }

}
