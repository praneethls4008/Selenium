package org.seleniumLearning.tests.oyo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.seleniumLearning.browser.ChromeBrowser;
import org.seleniumLearning.pages.oyo.HotelsPage;
import org.seleniumLearning.pages.oyo.OyoPage;

public class OyoPageTests {

    private WebDriver driver;

    @BeforeEach
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
    public void searchHotels(){
        OyoPage oyoPage = new OyoPage(this.driver);
        HotelsPage hotelsPage = new HotelsPage(this.driver);

        oyoPage.getUrl();
        oyoPage.search("hyderabad");
        hotelsPage.getHotelsData().stream().forEach(hotelObject -> System.out.println(hotelObject));

    }

}
