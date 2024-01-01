package com.qa.parabank.listeners;

import com.microsoft.playwright.Page;
import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.ITestResult;


import static com.qa.parabank.factory.PlaywrightFactory.getPage;

public class TestListener implements ITestListener {

    @Attachment(value = "Screenshot", type = "image/png")
    private static byte[] takeScreenShotForAllure(Page page) {
        return page.screenshot();
    }

    @Attachment(value = "{0}", type = "text/plain")
    private static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenShotForAllure(getPage());
        saveTextLog(result.getMethod().getMethodName() + " failed and screenshot taken.");
    }
}
