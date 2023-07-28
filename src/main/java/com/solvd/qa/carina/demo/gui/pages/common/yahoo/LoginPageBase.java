package com.solvd.qa.carina.demo.gui.pages.common.yahoo;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {


    //constructor
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    //methods
    public abstract void login(String username);

    public abstract String getErrorMessage();

}
