package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class mainPage {

    //FIXME Locators are missing
    public WebDriver driver;
    By add= By.xpath("//a[@id='add']");
    By filter =By.xpath("//input[@id='searchbox']");
    By filterButton =By.xpath("//input[@id='searchsubmit']");

    public mainPage(WebDriver driver){
        this.driver =driver;
    }

    //This issues apply to the other class pages as well
    //FIXME what about getAddComputerButton() - you are returning the webelement, the method gives the impression
    // you are already adding a computer
    public WebElement addComputer(){

        return driver.findElement(add);
    }

    //FIXME what about getFilterByNameButton()
    public WebElement filterByName(){

        return driver.findElement(filter);
    }

    //FIXME what about getFilterSubmitButton()
    public WebElement filtersubmit(){

        return driver.findElement(filterButton);
    }
}
