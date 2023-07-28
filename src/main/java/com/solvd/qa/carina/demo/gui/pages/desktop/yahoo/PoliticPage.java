package com.solvd.qa.carina.demo.gui.pages.desktop.yahoo;

import com.solvd.qa.carina.demo.gui.components.YahooNewsItem;
import com.solvd.qa.carina.demo.gui.pages.common.yahoo.PoliticPageBase;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PoliticPage extends PoliticPageBase {

    //field
    @FindBy(xpath = "//li[@data-test-locator = 'stream-item']")
    private List<YahooNewsItem> news;

    //constructor
    public PoliticPage(WebDriver driver) {
        super(driver);
        setPageURL("/politics");
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }


    //methods

    //get list of news from the web page
    @Override
    public List<YahooNewsItem> getNews() {
        return news;
    }
}
