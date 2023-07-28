package com.solvd.qa.carina.demo.gui.pages.desktop.yahoo;

import com.solvd.qa.carina.demo.gui.pages.common.yahoo.LoginPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends LoginPageBase {

    @FindBy(id = "login-username")
    private ExtendedWebElement loginUsername;

    @FindBy(id = "login-signin")
    private ExtendedWebElement nextButton;

    @FindBy(className = "error-msg")
    private ExtendedWebElement errorMessage;

    //constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://login.yahoo.com/?.lang=en-US&src=homepage&.done=https%3A%2F%2Fwww.yahoo.com%2F&pspid=2023538075&activity=ybar-signin");
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    //methods
    @Override
    public void login(String username) {
        loginUsername.type(username);
        loginUsername.scrollTo();
        nextButton.click();
    }

    @Override
    public String getErrorMessage() {
        return errorMessage.getText();
    }


}
