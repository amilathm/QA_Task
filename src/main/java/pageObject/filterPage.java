package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class filterPage {


    public WebDriver driver;

    By table =By.xpath("//table[@class='computers zebra-striped']//tr//td[2]");

    public filterPage(WebDriver driver){
        this.driver =driver;
    }

    public List<WebElement> getsize(){

        return driver.findElements(table);
    }
}
