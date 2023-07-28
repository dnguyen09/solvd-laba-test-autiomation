package com.solvd.qa.carina.demo.gui.pages.common.yahoo;

import com.solvd.qa.carina.demo.gui.components.YahooNewsItem;
import com.solvd.qa.carina.demo.gui.components.navigation.NavigationMenu;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class NewsPageBase extends AbstractPage {

    public NewsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract NavigationMenu getNavigationMenu();

    public abstract void scrollDown();

    public abstract List<YahooNewsItem> getNews();

}
