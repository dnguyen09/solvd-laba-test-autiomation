package com.solvd.qa.carina.demo.gui.pages.desktop.yahoo;

import com.solvd.qa.carina.demo.gui.components.YahooNewsItem;
import com.solvd.qa.carina.demo.gui.components.navigation.NavigationMenu;
import com.solvd.qa.carina.demo.gui.pages.common.yahoo.NewsPageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends NewsPageBase {

    //fields
    @FindBy(id = "ybar-navigation")
    private NavigationMenu navigationMenu;

    @FindBy(xpath = "//li[@data-test-locator = 'stream-item']")
    private List<YahooNewsItem> news;


    //constructor
    public NewsPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://news.yahoo.com");
    }

    //methods
    @Override
    public NavigationMenu getNavigationMenu() {
        return navigationMenu;
    }

    @Override
    public void scrollDown() {
        WebDriver driver = getDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,4000)", "");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<YahooNewsItem> getNews() {
        return news;
    }
}
