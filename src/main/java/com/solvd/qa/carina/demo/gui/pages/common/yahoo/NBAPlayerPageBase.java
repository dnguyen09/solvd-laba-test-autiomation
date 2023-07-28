package com.solvd.qa.carina.demo.gui.pages.common.yahoo;

import com.solvd.qa.carina.demo.gui.pages.desktop.yahoo.PlayerPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class NBAPlayerPageBase extends AbstractPage {

    //constructor
    public NBAPlayerPageBase(WebDriver driver) {
        super(driver);
    }

    //methods
    public abstract PlayerPage selectPlayer(String playerName);
}
