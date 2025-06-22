package org.seleniumLearning.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {
    public WebDriver driver;

    public ChromeBrowser(){
        driver = new ChromeDriver();
    }

}
