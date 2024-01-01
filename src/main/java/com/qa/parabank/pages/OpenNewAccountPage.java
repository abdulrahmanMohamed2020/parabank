package com.qa.parabank.pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class OpenNewAccountPage {

    private Page page;

    // String Locators
    private final String openNewAccountButton = "//input[@type='submit']";
    private final String successfulMessage = "//h1[@class='title']/following-sibling::p[1]";

    public OpenNewAccountPage(Page page) {
        this.page = page;
    }

    @Step("Click on the Open New Account  button")
    public void clickOnOpenNewAccountButton() {
        page.waitForSelector(openNewAccountButton).click();
    }

    public String getSuccessfulMessage() {
        return page.textContent(successfulMessage);
    }
}
