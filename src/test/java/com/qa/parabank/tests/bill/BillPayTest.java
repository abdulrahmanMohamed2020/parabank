package com.qa.parabank.tests.bill;

import com.qa.parabank.base.BaseTest;
import com.qa.parabank.pages.bill.BillPayPage;
import com.qa.parabank.pages.home.AccountOverviewPage;
import com.qa.parabank.pages.home.HomePage;
import com.qa.parabank.pages.home.OpenNewAccountPage;
import com.qa.parabank.pages.login.LoginPage;
import com.qa.parabank.pages.login.RegisterPage;
import com.qa.parabank.util.constants.Constants;
import com.qa.parabank.util.testdata.UserTestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BillPayTest extends BaseTest {

    private HomePage homePage;
    private BillPayPage billPayPage;
    private static final String[] AMOUNT = {"3500000","5000000"};

    @DataProvider(name = "payeeData")
    public Object[][] payeeData() {
        return new Object[][]{ { UserTestData.getPayeeData() } };
    }

    @Test(description = "Verify Bill payment will be successful and user wil have zero balance", dataProvider = "payeeData")
    public void verifySuccessfulBillPay(Map<String, String> payeeData) {
        createThreeTestUsers();
        checkBalanceBeforeBilling();
        performBillPayment(payeeData, AMOUNT[0]);
        checkSuccessfulBillPayment();
        checkBalanceAfterBilling();
    }

    @Test(description = "Verify Bill Payment will be unsuccessful with a blocking message", dataProvider = "payeeData")
    public void verifyUnSuccessfulBillPay(Map<String, String> payeeData) {
        createThreeTestUsers();
        checkBalanceBeforeBilling();
        performBillPayment(payeeData, AMOUNT[1]);
        checkUnsuccessfulBillPayment();
    }

    private void createThreeTestUsers() {
        registerTestUsers();
        openNewAccounts();
        goToAccountOverviewPage();
    }

    private void registerTestUsers() {
        LoginPage loginPage = new LoginPage(getPage());
        loginPage.clickOnRegister();

        homePage = new HomePage(getPage());
        RegisterPage registerPage = new RegisterPage(getPage());

        Map<String, String> userData = UserTestData.getUserData();
        enterRegistrationDetails(userData);
        registerPage.clickOnRegister();

        System.out.println("Username: " + userData.get("username"));
        System.out.println("Password: " + userData.get("password"));
    }

    private void openNewAccounts() {
        homePage.clickOnOpenNewAccount();
        OpenNewAccountPage openNewAccountPage = new OpenNewAccountPage(getPage());

        for (int counter = 1; counter <= 2; counter++) {
            pauseFor(200);
            openNewAccountPage.clickOnOpenNewAccountButton();
            if (counter != 2) {
                homePage.clickOnOpenNewAccount();
            }
        }
    }

    private void fillPayeeData(Map<String, String> payeeData) {
        billPayPage.enterPayeeName(payeeData.get("payeeName"));
        billPayPage.enterPayeeAddress(payeeData.get("payeeAddress"));
        billPayPage.enterPayeeCity(payeeData.get("payeeCity"));
        billPayPage.enterPayeeState(payeeData.get("payeeState"));
        billPayPage.enterPayeeZipCode(payeeData.get("payeeZipCode"));
        billPayPage.enterPayeePhoneNumber(payeeData.get("payeePhoneNumber"));
        billPayPage.enterAccountNumber(payeeData.get("accountNumber"));
        billPayPage.enterVerifyAccount(payeeData.get("verifyAccount"));
    }

    private void checkUnsuccessfulBillPayment() {
        assertEquals(billPayPage.getBillPaymentStatus(), "You can not pay more than balance in your account");
    }

    private void checkBalanceAfterBilling() {
        homePage.clickOnAccountOverview();
        AccountOverviewPage accountOverviewPage = new AccountOverviewPage(getPage());
        assertEquals(accountOverviewPage.getTotalBalance(), Constants.BALANCE_AFTER_BILLING);
    }

    private void checkSuccessfulBillPayment() {
        assertTrue(billPayPage.getBillPaymentStatus().contains("was successful"), "The payment should be successful");
    }

    private void performBillPayment(Map<String, String> payeeData, String amount) {
        homePage.clickOnBillPay();
        billPayPage = new BillPayPage(getPage());
        fillPayeeData(payeeData);
        billPayPage.enterAmount(amount);
        billPayPage.clickOnSendPayment();
    }

    private void checkBalanceBeforeBilling() {
        AccountOverviewPage accountOverviewPage = new AccountOverviewPage(getPage());
        assertEquals(accountOverviewPage.getTotalBalance(), Constants.EXPECTED_TOTAL_BALANCE);
    }

    private void goToAccountOverviewPage() {
        homePage.clickOnAccountOverview();
    }

    private void enterRegistrationDetails(Map<String, String> userData) {
        RegisterPage registerPage = new RegisterPage(getPage());

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
    }

}
