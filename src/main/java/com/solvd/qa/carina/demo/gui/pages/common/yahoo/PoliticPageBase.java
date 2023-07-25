package com.solvd.qa.carina.demo.gui.pages.common.yahoo;

import com.solvd.qa.carina.demo.gui.components.YahooNewsItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class PoliticPageBase extends AbstractPage {

    //constructor
    public PoliticPageBase(WebDriver driver) {
        super(driver);
    }

    //method
    public abstract List<YahooNewsItem> getNews();


}
