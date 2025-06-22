package org.seleniumLearning.pages.oyo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumLearning.pages.helpers.HotelsDataAccessObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HotelsPage {

    protected WebDriver driver;

    private static final String containerHotelsCard = "(//div[contains(@class,'hotelCardListing__descriptionWrapper')]//child::div[contains(@class,'listingHotelDescription') and @name])";

    private static final String txtHotelName = ".//child::h3";
    private static final String txtHotelAddress = ".//child::span[@itemprop='streetAddress']";
    private static final String txtHotelRating = ".//child::div[@itemprop='aggregateRating']";
    private static final String txtHotelPrice = ".//child::span[contains(@class,'listingPrice__finalPrice')]";




    public HotelsPage(WebDriver driver){
        this.driver =  driver;
    }

    public List<HotelsDataAccessObject> getHotelsData(){
        List<HotelsDataAccessObject> searchResultsHotelData = new ArrayList<>();

        for(WebElement hotelParentContainer: new WebDriverWait(this.driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(containerHotelsCard)))){
            HotelsDataAccessObject currentHotel = new HotelsDataAccessObject();
            currentHotel.setHotelName(hotelParentContainer.findElement(By.xpath(txtHotelName)).getText());
            currentHotel.setHotelAddress(hotelParentContainer.findElement(By.xpath(txtHotelAddress)).getText());
            currentHotel.setHotelRating(hotelParentContainer.findElement(By.xpath(txtHotelRating)).getText());
            currentHotel.setHotelPrice(hotelParentContainer.findElement(By.xpath(txtHotelPrice)).getText());
            searchResultsHotelData.add(currentHotel);
        }

        return searchResultsHotelData;
    }

}
