package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class mainPage {


    public WebDriver driver;
    By add= By.xpath("//a[@id='add']");
    By filter =By.xpath("//input[@id='searchbox']");
    By filterButton =By.xpath("//input[@id='searchsubmit']");

    public mainPage(WebDriver driver){
        this.driver =driver;
    }

    public WebElement addComputer(){

        return driver.findElement(add);
    }
    public WebElement filterByName(){

        return driver.findElement(filter);
    }

    public WebElement filtersubmit(){

        return driver.findElement(filterButton);
    }
}
