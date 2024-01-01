package com.qa.parabank.pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class BillPayPage {

    private Page page;

    // String Locators
    private final String payeeNameLocator = "//input[@name='payee.name']";
    private final String payeeAddressLocator = "//input[@name='payee.address.street']";
    private final String payeeCityLocator = "//input[@name='payee.address.city']";
    private final String payeeStateLocator = "//input[@name='payee.address.state']";
    private final String payeeZipCodeLocator = "//input[@name='payee.address.zipCode']";
    private final String payeePhoneNumberLocator = "//input[@name='payee.phoneNumber']";
    private final String accountNumberLocator = "//input[@name='payee.accountNumber']";
    private final String verifyAccountLocator = "//input[@name='verifyAccount']";
    private final String amountLocator = "//input[@name='amount']";
    private final String sendPaymentButton = "//input[@type='submit']";
    private final String billPaymentStatus = "//h1[text()='Bill Payment Complete']/following-sibling::p[1]";

    public BillPayPage(Page page) {
        this.page = page;
    }

    @Step("Enter Payee Name: {0}")
    public void enterPayeeName(String payeeName) {
        page.fill(payeeNameLocator,payeeName);
    }

    @Step("Enter Payee Address: {0}")
    public void enterPayeeAddress(String payeeAddress) {
        page.fill(payeeAddressLocator,payeeAddress);
    }

    @Step("Enter Payee City: {0}")
    public void enterPayeeCity(String payeeCity) {
        page.fill(payeeCityLocator,payeeCity);
    }

    @Step("Enter Payee State: {0}")
    public void enterPayeeState(String payeeState) {
        page.fill(payeeStateLocator,payeeState);
    }

    @Step("Enter Payee Zip Code: {0}")
    public void enterPayeeZipCode(String payeeZipCode) {
        page.fill(payeeZipCodeLocator,payeeZipCode);
    }

    @Step("Enter Payee Phone Number: {0}")
    public void enterPayeePhoneNumber(String payeePhoneNumber) {
        page.fill(payeePhoneNumberLocator,payeePhoneNumber);
    }

    @Step("Enter Account Number: {0}")
    public void enterAccountNumber(String accountNumber) {
        page.fill(accountNumberLocator,accountNumber);
    }

    @Step("Enter Verify Account: {0}")
    public void enterVerifyAccount(String verifyAccount) {
        page.fill(verifyAccountLocator,verifyAccount);
    }

    @Step("Enter Amount: {0}")
    public void enterAmount(String amount) {
        page.fill(amountLocator,amount);
    }

    @Step("Click on the Send Payment  button")
    public void clickOnSendPayment() {
        page.waitForSelector(sendPaymentButton).click();
    }

    @Step("Check Bill Payment Status Message")
    public String getBillPaymentStatus() {
        return page.textContent(billPaymentStatus);
    }

}
