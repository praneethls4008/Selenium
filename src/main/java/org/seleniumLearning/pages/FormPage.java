package org.seleniumLearning.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;

public class FormPage {

    final String formPageUrl = "https://seleniumplayground.practiceprobs.com/contact/";
    final String inputName = "//input[@name='name']";
    final String inputEmail = "//input[@name='email']";
    final String selectFavDogBreed =  "//select";
    final String inputPicOfDog  = "//input[@name='file']";
    final String inputMessage = "//textarea[@name='message']";
    final String btnSubmit = "//button[@type='submit']";
    final String h1SubmitThanyouText = "//h1[text()='Thank you!']";
    final String h1SubmitSucessText ="//h1[text()='Thank you!']//following-sibling::p";

    WebDriver driver;

   public FormPage(WebDriver driver){
       this.driver = driver;
   }

     public void getPage(){
            this.driver.get(formPageUrl);

     }

    public void fillName(String name){
        this.driver.findElement(By.xpath(inputName)).sendKeys(name);
    }

    public void fillEmail(String email){
        this.driver.findElement(By.xpath(inputEmail)).sendKeys(email);
    }

    public void selectFavDog(String dogBreed){
        Select favDogSelect = new Select(this.driver.findElement(By.xpath(selectFavDogBreed)));
        favDogSelect.selectByVisibleText(dogBreed);
    }

    public void UploadDogPicture(String filePath){
        this.driver.findElement(By.xpath(inputPicOfDog)).sendKeys(filePath);
    }

    public void fillMessage(String message){
        this.driver.findElement(By.xpath(inputMessage)).sendKeys(message);
    }


    public void submitForm() {
       this.driver.findElement(By.xpath(btnSubmit)).submit();
    }

    public String successMessageThanks(){
       this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return new WebDriverWait(this.driver, Duration.ofSeconds(2)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(h1SubmitThanyouText))).getText();
    }

    public String successMessage(){


        TakesScreenshot tk = (TakesScreenshot) this.driver;

        try{
            Files.copy(tk.getScreenshotAs(OutputType.FILE).toPath(), new File("results/screenshots/successMessage.png").toPath());
        }catch (Exception e){
            e.printStackTrace();
        }
       return new FluentWait<>(this.driver).pollingEvery(Duration.ofMillis(100)).withTimeout(Duration.ofSeconds(2)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(h1SubmitSucessText))).getText();
    }

}
