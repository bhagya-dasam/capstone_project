package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;
import base.BaseTest;

public class Hooks {

    @Before
    public void setUp() {
        BaseTest.setup();
    }
    
    @AfterStep
    public void slowDown() throws InterruptedException {
        Thread.sleep(2000);   // ← the single line that slows execution (2 seconds)
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(BaseTest.driver, scenario.getName());
            scenario.attach(screenshotPath, "image/png", scenario.getName());
        }
        BaseTest.tearDown();
    }
}