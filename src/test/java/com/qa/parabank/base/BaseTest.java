package com.qa.parabank.base;

import java.util.Properties;

import com.qa.parabank.factory.PlaywrightFactory;
import com.qa.parabank.listeners.TestListener;
import org.testng.annotations.*;

import com.microsoft.playwright.Page;

@Listeners({TestListener.class})
public class BaseTest {

    protected PlaywrightFactory playwrightFactory;
    protected Page page;
    protected Properties prop;

    @Parameters({ "browser" })
    @BeforeMethod
    public void setup(@Optional() String browserName) {
        playwrightFactory = new PlaywrightFactory();

        prop = playwrightFactory.initProp();

        if (browserName != null) {
            prop.setProperty("browser", browserName);
        }

        page = playwrightFactory.initBrowser(prop);
    }

    public Page getPage(){
        return page;
    }

    protected void pauseFor(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void tearDown() {
        getPage().context().browser().close();
    }

}