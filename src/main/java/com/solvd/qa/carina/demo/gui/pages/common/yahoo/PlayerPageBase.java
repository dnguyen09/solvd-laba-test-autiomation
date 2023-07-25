package com.solvd.qa.carina.demo.gui.pages.common.yahoo;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PlayerPageBase extends AbstractPage {

    public PlayerPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String readHeightWeight();

    public abstract String readBorn();
}
