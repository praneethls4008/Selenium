package org.seleniumLearning.pages.oyo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OyoPage {
    protected WebDriver driver;
    private static final String url = "https://www.oyorooms.com/";
    private static final String inputSearchBar = "//input[contains(@placeholder,'Search by city')]";
    private static final String btnSearch = "//button[text()='Search']";
    private static final String dropDownOption1 = "//div[contains(@class,'geoSuggestionsList')][3]";

    public OyoPage(WebDriver driver){
        this.driver =  driver;
    }

    public void getUrl(){
        this.driver.get(url);
    }

    public void search(String value){
        this.driver.findElement(By.xpath(inputSearchBar)).sendKeys(value);
        new WebDriverWait(this.driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(dropDownOption1))).click();
        this.driver.findElement(By.xpath(btnSearch)).click();
    }





}
