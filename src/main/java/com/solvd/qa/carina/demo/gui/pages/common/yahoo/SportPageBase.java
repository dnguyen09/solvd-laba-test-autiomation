package com.solvd.qa.carina.demo.gui.pages.common.yahoo;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SportPageBase extends AbstractPage {

    //constructor
    public SportPageBase(WebDriver driver) {
        super(driver);
    }

    //methods
    public abstract NBAPlayerPageBase openNBAPlayersPage();

}
