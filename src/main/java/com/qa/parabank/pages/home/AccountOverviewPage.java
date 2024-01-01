package com.qa.parabank.pages.home;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class AccountOverviewPage {

    private Page page;

    // String Locators
    private static final String totalBalance = "//b[@class='ng-binding']";

    public AccountOverviewPage(Page page) {
        this.page = page;
    }

    @Step("Check Total Balance")
    public String getTotalBalance() {
        return page.waitForSelector(totalBalance).textContent();
    }
}
