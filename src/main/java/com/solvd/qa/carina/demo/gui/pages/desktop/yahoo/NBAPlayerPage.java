package com.solvd.qa.carina.demo.gui.pages.desktop.yahoo;

import com.solvd.qa.carina.demo.gui.pages.common.yahoo.NBAPlayerPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NBAPlayerPage extends NBAPlayerPageBase {

    //field
    @FindBy(xpath = "//input[@name = 'players-name-search']")
    private ExtendedWebElement searchTextField;

    @FindBy(xpath = "//a[@title = 'Kobe Bryant']")
    private ExtendedWebElement kobeLink;

    //constructor
    public NBAPlayerPage(WebDriver driver) {
        super(driver);
        setPageURL("/nba/players/");
    }


    @Override
    public PlayerPage selectPlayer(String playerName) {
        searchTextField.type(playerName);
        kobeLink.click();
        return new PlayerPage(driver);
    }


}
