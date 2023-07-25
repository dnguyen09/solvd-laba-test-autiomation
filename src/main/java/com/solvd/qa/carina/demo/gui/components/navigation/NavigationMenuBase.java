package com.solvd.qa.carina.demo.gui.components.navigation;

import com.solvd.qa.carina.demo.gui.pages.common.yahoo.PoliticPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class NavigationMenuBase extends AbstractUIObject {

    public NavigationMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract PoliticPageBase openPoliticPage();
}
