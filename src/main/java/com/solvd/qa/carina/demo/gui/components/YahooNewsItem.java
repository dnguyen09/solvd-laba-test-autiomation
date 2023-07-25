package com.solvd.qa.carina.demo.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YahooNewsItem extends AbstractUIObject {
    @FindBy(xpath = ".//strong[@data-test-locator = 'stream-item-category-label']")
    public ExtendedWebElement tag;

    public YahooNewsItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String readTag() {
        return tag.getText();
    }
}
