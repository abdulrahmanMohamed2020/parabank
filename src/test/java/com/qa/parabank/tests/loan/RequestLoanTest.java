package com.qa.parabank.tests.loan;

import com.qa.parabank.base.BaseTest;
import com.qa.parabank.pages.home.HomePage;
import com.qa.parabank.pages.login.LoginPage;
import com.qa.parabank.pages.loan.RequestLoanPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RequestLoanTest extends BaseTest {

    private HomePage homePage;
    private RequestLoanPage requestLoanPage;
    private static final String[] LOAN_AMOUNT = {"5000","1000"};
    private static final String[] DOWN_PAYMENT = {"1000","7000"};

    @Test(description = "Verify the Loan status will be Approved when the amount more than the down payment")
    public void verifyLoanStatusWillBeApproved() {

        performSuccessfulLogin();

        // Go to Transfer Funds Page
        homePage = new HomePage(getPage());
        homePage.clickOnRequestLoan();

        requestLoanPage = new RequestLoanPage(getPage());
        requestLoanPage.enterLoanAmount(LOAN_AMOUNT[0]);
        requestLoanPage.enterDownPayment(DOWN_PAYMENT[0]);
        requestLoanPage.clickOnApplyNow();

        assertEquals(requestLoanPage.getLoanStatus(), "Approved");
    }

    @Test(description = "Verify the Loan status will be Denied when the amount less than the down payment")
    public void verifyLoanStatusWillBeDenied() {

        performSuccessfulLogin();

        // Go to Transfer Funds Page
        homePage = new HomePage(getPage());
        homePage.clickOnRequestLoan();

        requestLoanPage = new RequestLoanPage(getPage());
        requestLoanPage.enterLoanAmount(LOAN_AMOUNT[1]);
        requestLoanPage.enterDownPayment(DOWN_PAYMENT[1]);
        requestLoanPage.clickOnApplyNow();

        assertEquals(requestLoanPage.getLoanStatus(), "Denied");
    }

    private void performSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(getPage());
        loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("password"));
        loginPage.clickOnLogin();
    }
}
