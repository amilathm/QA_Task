package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class editPage {

    public WebDriver driver;


   By computer = By.xpath("//table[@class='computers zebra-striped']//tr//td[1]//a");

   By Name = By.xpath("//input[@id='name']");
   By DiscontinuedDate = By.xpath("//input[@id='discontinued']");
   By Save = By.xpath("//input[@value='Save this computer']");
    By alert = By.xpath("//div[@class='alert-message warning']");
    By Next = By.xpath("//div[@id='pagination']//ul//li[2]//a");
    By NextSubmit=By.xpath("//div[@id='pagination']//ul//li[@class='next']//a");

    public editPage(WebDriver driver){
        this.driver =driver;
    }



    public WebElement getcomputer(){

        return driver.findElement(computer);
}
    public WebElement getName(){

        return driver.findElement(Name);
    }
    public WebElement getDiscontinuedDate(){

        return driver.findElement(DiscontinuedDate);
    }
    public WebElement getSave(){

        return driver.findElement(Save);
    }
    public WebElement getAlert(){

        return driver.findElement(alert);
    }
    public WebElement getNext(){
        return driver.findElement(Next);
    }
    public WebElement getNextSubmit(){
        return driver.findElement(NextSubmit);
    }
}