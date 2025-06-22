package org.seleniumLearning.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.seleniumLearning.browser.ChromeBrowser;
import org.seleniumLearning.pages.FormPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class ContactPageTests {
    private  WebDriver driver;

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
    public void testSubmitContactFormSuccessfully() throws InterruptedException {

        System.out.println("inTest");
        FormPage formPage = new FormPage(driver);
        formPage.getPage();
        formPage.fillName("pran");
        formPage.fillEmail("pran@email.com");
        formPage.selectFavDog("Rottweiler");
        formPage.UploadDogPicture(System.getProperty("user.dir") + "\\src\\main\\resources\\testData\\images\\teacup-shih-tzu-2.jpg");
        formPage.fillMessage("picOf fdog");
        formPage.submitForm();


        Assert.assertEquals(formPage.successMessageThanks(), "Thank you!", "Failed for Thanks message after submitting");

        Assert.assertEquals(formPage.successMessage(), "Your form submission has been received.", "Failed for success message after submitting");


    }

}
