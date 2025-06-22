package org.seleniumLearning.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.seleniumLearning.browser.ChromeBrowser;

import org.seleniumLearning.pages.FormPage;
import org.seleniumLearning.pages.PaintPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class PaintPageTests {
    private WebDriver driver;

    @BeforeClass
    public void setup(){
        ChromeBrowser chromeBrowser = new ChromeBrowser();
        driver = chromeBrowser.driver;
        System.out.println("beforeClass");
    }

    @AfterEach
    public void cleanUp(){
        driver.close();
        driver.quit();
    }

    @Test
    public void drawPainting() throws InterruptedException {

        PaintPage paintPage = new PaintPage(driver);
        paintPage.gotoPage();
        paintPage.drawPaint();

    }
}
