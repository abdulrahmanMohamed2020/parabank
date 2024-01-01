package com.qa.parabank.pages.transferfunds;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class TransferFundsPage {

    private Page page;

    // String Locators
    private final String amountLocator = "id=amount";
    private final String transferButton = "//input[@class='button']";
    private final String transferMessage = "//h1[@class='title']/following-sibling::p[1]";
    private final String toAccountId = "#toAccountId";
    public TransferFundsPage(Page page) {
        this.page = page;
    }

    @Step("Enter Amount: {0}")
    public void enterAmount(String amount) {
        page.waitForSelector(amountLocator).fill(amount);
    }

    @Step("Click on the Transfer  button")
    public void clickOnTransfer() {
        page.waitForSelector(transferButton).click();
    }

    @Step("Select To Account: {0}")
    public void selectToAccount(String accountNumber) {
        page.selectOption(toAccountId,accountNumber);
    }



    public String getTransferMessage() {
        return page.textContent(transferMessage);
    }
}
