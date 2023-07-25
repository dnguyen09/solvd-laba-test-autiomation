package com.solvd.qa.carina.demo.webYahooTest;

import com.solvd.qa.carina.demo.gui.components.WeatherItem;
import com.solvd.qa.carina.demo.gui.components.YahooNewsItem;
import com.solvd.qa.carina.demo.gui.pages.common.yahoo.*;
import com.solvd.qa.carina.demo.gui.pages.desktop.yahoo.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.utils.R;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class WebYahooTest implements IAbstractTest {

    @Test
    @TestPriority(Priority.P3)
    public void testNewsPoliticCategories() {

        //open yahoo home page and verify the page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();

        //open news page
        NewsPageBase newsPage = homePage.openNewsPage();

        //open politic page
        PoliticPageBase politicPage = newsPage.getNavigationMenu().openPoliticPage();

        //get list of news from the web page
        List<YahooNewsItem> politicNews = politicPage.getNews();

        //check if there is at least one news
        Assert.assertFalse(politicNews.isEmpty(), "No news articles found");

        boolean hasPoliticsArticle = false;

        //check if there is a politics article
        for (YahooNewsItem item : politicNews) {
            if (StringUtils.equalsIgnoreCase(item.readTag(), "Politics")) {
                hasPoliticsArticle = true;
                break;
            }
        }

        Assert.assertTrue(hasPoliticsArticle, "No politics article found");
    }

    @Test(dataProvider = "DP1")
    @TestPriority(Priority.P3)
    public void testWeatherCitySearch(String city) {
        //open yahoo home page and verify the page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();

        //locate to weather field and serch for the city
        WeatherItem weatherField = homePage.searchCityWeather(city);

        //assertions to verify the weather temp is empty
        List<WeatherItem> weatherTemps = weatherField.getWeatherTemps();

        SoftAssert softAssert = new SoftAssert();

        //verify if temperatures are empty
        softAssert.assertFalse(CollectionUtils.isEmpty(weatherTemps), "No weather temperatures found");

        //verify if temperatures are in range
        for (WeatherItem weatherItem : weatherTemps) {
            int highTemp = Integer.parseInt(weatherItem.getHighTemp().replace("°", ""));
            int lowTemp = Integer.parseInt(weatherItem.getLowTemp().replace("°", ""));
            softAssert.assertTrue(lowTemp >= -58 && highTemp <= 122, "Temperature is not in range");
        }

        softAssert.assertAll();
    }

    //data provider using test annotation
    @DataProvider(name = "DP1")
    public Object[][] dataProvider() {

        return new Object[][]{
                {"New York"},
                {"London"},
                {"Paris"},
        };
    }

    @Test()
    @TestPriority(Priority.P3)
    public void testSportPlayerInfo() {
        //open yahoo home page and verify the page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();

        //open sport page
        SportPageBase sportPage = homePage.openSportPage();

        //open players page
        NBAPlayerPageBase nbaPlayerPage = sportPage.openNBAPlayersPage();

        //select player
        PlayerPageBase playerPage = nbaPlayerPage.selectPlayer("Kobe Bryant");

        //Verify player bio
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(playerPage.readHeightWeight(), "6' 6\"/212 lbs", "Player height is not correct");
        softAssert.assertEquals(playerPage.readBorn(), "August 23, 1978 Philadelphia, Pennsylvania", "Player born is not correct");
        softAssert.assertAll();
    }

    @Test()
    @TestPriority(Priority.P3)
    public void testInvalidLoginEmail() {
        //open yahoo home page and verify the page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();

        //open login page
        LoginPageBase loginPage = homePage.openLoginPage();
        loginPage.assertPageOpened();

        String username = R.TESTDATA.get("invalid_email");

        loginPage.login(username);

        //Verify error message
        Assert.assertEquals(loginPage.getErrorMessage(), "Sorry, we don't recognize this email.",
                "Error message does not match the expected message");
    }

    @Test()
    @TestPriority(Priority.P3)
    public void testDynamicalLoadedNews() {

        //open yahoo home page and verify the page is opened
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened();

        //open news page
        NewsPageBase newsPage = homePage.openNewsPage();
        newsPage.assertPageOpened();

        //initialize article count
        int initialArticles = newsPage.getNews().size();

        //scroll down
        newsPage.scrollDown();

        //initialize new article count
        int newArticles = newsPage.getNews().size();

        //Verify that new news articles are loaded
        Assert.assertTrue(newArticles > initialArticles, "New news articles are not loaded dynamically");
    }
}
