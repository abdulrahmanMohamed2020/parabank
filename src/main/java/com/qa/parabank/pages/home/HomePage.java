package com.qa.parabank.pages.home;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class HomePage {

    private Page page;

    // String Locators
    private final String openNewAccountLink = "//a[@href='/parabank/openaccount.htm']";
    private final String overviewLink = "//a[@href='/parabank/overview.htm']";
    private final String transferLink = "//a[@href='/parabank/transfer.htm']";
    private final String requestLoanLink = "//a[@href='/parabank/requestloan.htm']";
    private final String logOutLink = "//a[@href='/parabank/logout.htm']";
    private final String billPayLink = "//a[@href='/parabank/billpay.htm']";

    public HomePage(Page page) {
        this.page = page;
    }

    @Step("Click on the Log Out link")
    public void clickOnLogOut() {
        page.click(logOutLink);
    }

    @Step("Go to the Open New Account Page")
    public void clickOnOpenNewAccount() {
        page.click(openNewAccountLink);
    }

    @Step("Go to the Account Overview Page")
    public void clickOnAccountOverview() {
        page.click(overviewLink);
    }

    @Step("Go to the Transfer Funds Page")
    public void clickOnTransferFunds() {
        page.click(transferLink);
    }

    @Step("Go to the Request Loan Page")
    public void clickOnRequestLoan() {
        page.click(requestLoanLink);
    }

    @Step("Go to the Bill Pay Page")
    public void clickOnBillPay() {
        page.click(billPayLink);
    }
}
