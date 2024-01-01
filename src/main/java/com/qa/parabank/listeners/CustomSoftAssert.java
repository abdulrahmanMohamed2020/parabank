package com.qa.parabank.listeners;

import com.microsoft.playwright.Page;
import io.qameta.allure.Attachment;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import static com.qa.parabank.factory.PlaywrightFactory.getPage;

public class CustomSoftAssert extends SoftAssert {

    @Attachment(value = "Screenshot", type = "image/png")
    private static byte[] takeScreenShotForAllure(Page page) {
        return page.screenshot();
    }

    @Attachment(value = "{0}", type = "text/plain")
    private static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
        takeScreenShotForAllure(getPage());
        saveTextLog(ex.getMessage());
    }
}
