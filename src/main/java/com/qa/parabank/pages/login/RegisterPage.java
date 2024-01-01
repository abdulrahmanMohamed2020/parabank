package com.qa.parabank.pages.login;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class RegisterPage {

    private Page page;

    // String Locators
    private final String firstNameLocator = "id=customer.firstName";
    private final String lastNameLocator = "id=customer.lastName";
    private final String addressLocator = "id=customer.address.street";
    private final String cityLocator = "id=customer.address.city";
    private final String stateLocator = "id=customer.address.state";
    private final String zibCodeLocator = "id=customer.address.zipCode";
    private final String phoneLocator = "id=customer.phoneNumber";
    private final String ssnLocator = "id=customer.ssn";
    private final String usernameLocator = "id=customer.username";
    private final String passwordLocator = "id=customer.password";
    private final String confirmPasswordLocator = "id=repeatedPassword";
    private final String registerButton = "//input[@value='Register']";
    private final String successfulMessage = "div#rightPanel>p";

    public RegisterPage(Page page) {
        this.page = page;
    }

    @Step("Enter First Name: {0}")
    public void enterFirstName(String firstName) {
        page.fill(firstNameLocator,firstName);
    }

    @Step("Enter Last Name: {0}")
    public void enterLastName(String lastName) {
        page.fill(lastNameLocator,lastName);
    }

    @Step("Enter Address: {0}")
    public void enterAddress(String address) {
        page.fill(addressLocator,address);
    }

    @Step("Enter City: {0}")
    public void enterCity(String city) {
        page.fill(cityLocator,city);
    }

    @Step("Enter State: {0}")
    public void enterState(String state) {
        page.fill(stateLocator,state);
    }

    @Step("Enter Zib Code: {0}")
    public void enterZibCode(String zibCode) {
        page.fill(zibCodeLocator,zibCode);
    }

    @Step("Enter Phone: {0}")
    public void enterPhone(String phone) {
        page.fill(phoneLocator,phone);
    }

    @Step("Enter SSN: {0}")
    public void enterSsn(String ssn) {
        page.fill(ssnLocator,ssn);
    }

    @Step("Enter username: {0}")
    public void enterUsername(String username) {
        page.fill(usernameLocator,username);
    }

    @Step("Enter password: {0}")
    public void enterPassword(String password) {
        page.fill(passwordLocator,password);
    }

    @Step("Enter Confirm Password: {0}")
    public void enterConfirmPassword(String confirmPassword) {
        page.fill(confirmPasswordLocator,confirmPassword);
    }

    @Step("Click on the REGISTER  button")
    public void clickOnRegister() {
        page.click(registerButton);
    }

    @Step("Check Successful Message")
    public String getSuccessfulMessage() {
        return page.textContent(successfulMessage);
    }

}
