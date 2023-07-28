package com.solvd.qa.carina.demo.gui.pages.desktop.yahoo;

import com.solvd.qa.carina.demo.gui.pages.common.yahoo.PlayerPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PlayerPage extends PlayerPageBase {

    //field
    @FindBy(xpath = "//div[contains(@class, 'Ta(start)')]/div[1]/span[2]")
    private ExtendedWebElement displayHeightWeight;

    @FindBy(xpath = "//div[contains(@class, 'Ta(start)')]/div[2]/span[2]")
    private ExtendedWebElement displayBorn;

    //constructor
    public PlayerPage(WebDriver driver) {
        super(driver);
    }

    //methods
    @Override
    public String readHeightWeight() {
        return displayHeightWeight.getText();
    }

    @Override
    public String readBorn() {
        return displayBorn.getText();
    }
}
