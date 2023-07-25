package com.solvd.qa.carina.demo.gui.components.navigation;

import com.solvd.qa.carina.demo.gui.pages.desktop.yahoo.PoliticPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavigationMenu extends  NavigationMenuBase{

    @FindBy(xpath = "//a [@id = 'root_2']")
    private ExtendedWebElement politicLink;

    public NavigationMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public PoliticPage openPoliticPage() {
        politicLink.click();
        return new PoliticPage(driver);
    }


}
