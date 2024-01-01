package com.qa.parabank.pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class RequestLoanPage {

    private Page page;

    // String Locators
    private final String loanAmountLocator = "id=amount";
    private final String downPaymentLocator = "id=downPayment";
    private final String loanStatus = "id=loanStatus";
    private final String applyNowButton = "//input[@class='button']";

    public RequestLoanPage(Page page) {
        this.page = page;
    }

    @Step("Enter Loan Amount: {0}")
    public void enterLoanAmount(String amount) {
        page.fill(loanAmountLocator,amount);
    }

    @Step("Enter Down Payment: {0}")
    public void enterDownPayment(String downPayment) {
        page.fill(downPaymentLocator,downPayment);
    }

    @Step("Click on the Apply Now  button")
    public void clickOnApplyNow() {
        page.waitForSelector(applyNowButton).click();
    }

    @Step("Check Loan Status")
    public String getLoanStatus() {
        return page.textContent(loanStatus);
    }
}
