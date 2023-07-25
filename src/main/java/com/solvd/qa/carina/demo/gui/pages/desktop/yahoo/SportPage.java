package com.solvd.qa.carina.demo.gui.pages.desktop.yahoo;

import com.solvd.qa.carina.demo.gui.pages.common.yahoo.NBAPlayerPageBase;
import com.solvd.qa.carina.demo.gui.pages.common.yahoo.SportPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SportPage extends SportPageBase {
    //field
    @FindBy(xpath = "//a[@id = 'root_2' ]")
    private ExtendedWebElement nbaNavigation;

    @FindBy(linkText = "Players")
    private ExtendedWebElement playerLink;

    @FindBy(xpath = "//button[@title = 'Close modal']")
    private ExtendedWebElement closeAdButton;

    //constructor
    public SportPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://sports.yahoo.com");
    }

    //methods
    @Override
    public NBAPlayerPageBase openNBAPlayersPage() {
        closeAdButton.clickIfPresent();
        nbaNavigation.hover();
        playerLink.click();
        return new NBAPlayerPage(driver);
    }
}
