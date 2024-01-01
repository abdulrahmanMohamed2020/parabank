package com.qa.parabank.pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class LoginPage {

    private Page page;

    // String Locators
    private final String usernameLocator = "//input[@name='username']";
    private final String passwordLocator = "//input[@name='password']";
    private final String loginButton = "//input[@type='submit']";
    private final String registerLink = "//a[@href='register.htm']";
    private final String successfulMessage = "//p[@class='smallText']";
    private final String errorMessage = "//p[@class='error']";

    public LoginPage(Page page) {
        this.page = page;
    }

    @Step("Enter username: {0}")
    public void enterUsername(String username) {
        page.fill(usernameLocator,username);
    }

    @Step("Enter password: {0}")
    public void enterPassword(String password) {
        page.fill(passwordLocator,password);
    }

    @Step("Click on the LOG IN  button")
    public void clickOnLogin() {
        page.click(loginButton);
    }

    @Step("Click on the REGISTER  link")
    public void clickOnRegister() {
        page.click(registerLink);
    }

    @Step("Check Successful Message")
    public String getSuccessfulMessage() {
        return page.textContent(successfulMessage);
    }

    @Step("Check Error Message")
    public String getErrorMessage() {
        return page.textContent(errorMessage);
    }

}
