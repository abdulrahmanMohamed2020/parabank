package com.qa.parabank.tests.login;

import com.qa.parabank.base.BaseTest;
import com.qa.parabank.pages.*;

import static org.testng.Assert.*;

import com.qa.parabank.util.constants.Constants;
import com.qa.parabank.util.testdata.UserTestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private RegisterPage registerPage;
    private HomePage homePage;
    private OpenNewAccountPage openNewAccountPage;
    private AccountOverviewPage accountOverviewPage;

    @DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object[][]{ { UserTestData.getUserData() } };
    }

    @Test(description = "Verify The system will open the main page after successful login.", dataProvider = "userData")
    public void verifySuccessfulLogin(Map<String, String> userData) {

        loginPage = new LoginPage(getPage());
        loginPage.clickOnRegister();

        registerPage = new RegisterPage(getPage());
        doRegister(userData);
        assertRegisterSuccess();

        homePage = new HomePage(getPage());
        homePage.clickOnLogOut();

        doLogin(userData);
        assertLoginSuccess(userData);
    }

    @Test(description = "Verify the total balance after creating multiple accounts", dataProvider = "userData")
    public void verifyTotalBalance(Map<String, String> userData) {

        performSuccessfulLogin(userData);

        homePage.clickOnOpenNewAccount();
        openNewAccountPage = new OpenNewAccountPage(getPage());

        // Create 3 accounts having their total amount = 3,500,000
        for (int counter = 1 ; counter<=2 ; counter++) {
            openNewAccountPage.clickOnOpenNewAccountButton();
            assertOpenAccountSuccess();
            if (counter !=2) {
                homePage.clickOnOpenNewAccount();
            }
        }

        homePage.clickOnAccountOverview();
        assertTotalBalance(Constants.EXPECTED_TOTAL_BALANCE);
    }

    @Test(description = "Verify a blocking message will be displayed when providing wrong credentials.")
    public void verifyErrorMessageForUnsuccessfulLogin() {

        loginPage = new LoginPage(getPage());

        loginPage.enterUsername(Constants.INVALID_USERNAME);
        loginPage.enterPassword(Constants.INVALID_PASSWORD);
        loginPage.clickOnLogin();

        assertLoginFailure();
    }

    private void performSuccessfulLogin(Map<String, String> userData) {
        loginPage = new LoginPage(getPage());
        loginPage.clickOnRegister();
        registerPage = new RegisterPage(getPage());
        doRegister(userData);
        homePage = new HomePage(getPage());
        homePage.clickOnLogOut();
        doLogin(userData);
    }

    private void doRegister(Map<String, String> userData) {
        registerPage.enterFirstName(userData.get("firstName"));
        registerPage.enterLastName(userData.get("lastName"));
        registerPage.enterAddress(userData.get("address"));
        registerPage.enterCity(userData.get("city"));
        registerPage.enterState(userData.get("state"));
        registerPage.enterZibCode(userData.get("zipCode"));
        registerPage.enterPhone(userData.get("phone"));
        registerPage.enterSsn(userData.get("ssn"));
        registerPage.enterUsername(userData.get("username"));
        registerPage.enterPassword(userData.get("password"));
        registerPage.enterConfirmPassword(userData.get("confirmPassword"));
        registerPage.clickOnRegister();
    }

    private void assertRegisterSuccess() {
        assertEquals(registerPage.getSuccessfulMessage(), "Your account was created successfully. You are now logged in.");
    }

    private void doLogin(Map<String, String> userData) {
        loginPage.enterUsername(userData.get("username"));
        loginPage.enterPassword(userData.get("password"));
        loginPage.clickOnLogin();
    }

    private void assertLoginSuccess(Map<String, String> userData) {
        assertEquals(loginPage.getSuccessfulMessage(), "Welcome " + userData.get("firstName") + " " + userData.get("lastName"));
    }

    private void assertOpenAccountSuccess() {
        assertEquals(openNewAccountPage.getSuccessfulMessage(), "Congratulations, your account is now open.");
    }

    private void assertTotalBalance(String expectedTotalBalance) {
        accountOverviewPage = new AccountOverviewPage(getPage());
        assertEquals(accountOverviewPage.getTotalBalance(), expectedTotalBalance);
    }

    private void assertLoginFailure() {
        assertEquals(loginPage.getErrorMessage(), "The username and password could not be verified.");
    }
}