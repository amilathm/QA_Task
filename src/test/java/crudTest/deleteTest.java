package crudTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.base;

import java.io.IOException;

public class deleteTest extends base {
    public WebDriver driver;
    @BeforeTest
    public void openBrowser() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }






    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
