package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addNewComputer {


    public WebDriver driver;
    By name= By.xpath("//input[@id='name']");
    By introducedDate = By.xpath("//input[@id='introduced']");
    By chooseCompany = By.xpath("//select[@id='company']");
    By companyName = By.xpath("//option[@value='1']");
    By create = By.xpath("//input[@value='Create this computer'] ");
    By alert =By.xpath("//div[@class='alert-message warning'] ");

    public addNewComputer(WebDriver driver){
        this.driver =driver;
    }



    public WebElement getName(){

        return driver.findElement(name);
    }
    public WebElement getintroducedDate(){

        return driver.findElement(introducedDate);
    }
    public WebElement getchooseCompany(){

        return driver.findElement(chooseCompany);
    }
    public WebElement getcompanyName(){

        return driver.findElement(companyName);
    }public WebElement getcreate(){

        return driver.findElement(create);
    }
    public WebElement getalert(){

        return driver.findElement(alert);
    }

}
