package com.qa.parabank.tests.transferfunds;

import com.qa.parabank.base.BaseTest;
import com.qa.parabank.pages.home.HomePage;
import com.qa.parabank.pages.login.LoginPage;
import com.qa.parabank.pages.transferfunds.TransferFundsPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TransferFundsTest extends BaseTest {

    private HomePage homePage;
    private TransferFundsPage transferFundsPage;
    private static final String VALID_AMOUNT = "5000";
    private static final String MAX_AMOUNT = String.valueOf(Integer.MAX_VALUE);

    @Test(description = "Verify a blocking message will be displayed when Transfer From - To Same Account")
    public void verifyTransferFromToSameAccount() {

        performSuccessfulLogin();

        // Go to Transfer Funds Page
        homePage = new HomePage(getPage());
        homePage.clickOnTransferFunds();

        transferFundsPage = new TransferFundsPage(getPage());
        pauseFor(200);
        transferFundsPage.enterAmount(VALID_AMOUNT);
        transferFundsPage.clickOnTransfer();

        assertEquals(transferFundsPage.getTransferMessage(), "You can not transfer the amount to same account.");
    }

    @Test(description = "Verify a blocking message will be displayed when transfer amount more than the balance in account")
    public void verifyTransferAmountMoreThanTheBalanceInAccount() {

        performSuccessfulLogin();

        // Go to Transfer Funds Page
        homePage = new HomePage(getPage());
        homePage.clickOnTransferFunds();

        transferFundsPage = new TransferFundsPage(getPage());
        pauseFor(200);
        transferFundsPage.enterAmount(MAX_AMOUNT);
        transferFundsPage.selectToAccount("13566");
        transferFundsPage.clickOnTransfer();

        assertEquals(transferFundsPage.getTransferMessage(), "You can not transfer more than the balance in your account.");
    }

    private void performSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(getPage());
        loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("password"));
        loginPage.clickOnLogin();
    }
}
