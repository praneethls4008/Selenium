package org.seleniumLearning.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PaintPage {
    private final String url = "https://jspaint.app/#local:fa60a53f3acb6";
    private final String mainCanvas = "//canvas[@class='main-canvas']";

    public WebDriver driver;
    Actions actions;

    public PaintPage(WebDriver driver){
        this.driver = driver;
        actions = new Actions(this.driver);
    }

    public void gotoPage(){
        this.driver.get(this.url);
    }
    public void drawPaint(){

        WebElement canvas = this.driver.findElement(By.xpath(mainCanvas));

        this.actions.moveToElement(canvas, 34, 43)
                .clickAndHold()
                .moveByOffset(100, 0)
                .moveByOffset(-100, 100)
                .moveByOffset(100, 0)
                .release()
                .perform();

    }

}
