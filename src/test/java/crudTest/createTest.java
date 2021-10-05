package crudTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObject.addNewComputer;
import pageObject.base;
import pageObject.mainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

//FIXME Please follow the Java name conventions for class, constants packages and so (eg, CreateTest)
//ToDo Add names that means more eg, instead of base "BaseTest"
public class createTest extends base {

    public static Logger log =LogManager.getLogger(createTest.class.getName());
    public WebDriver driver;

    @BeforeTest
    public void openBrowser() throws IOException {
        driver = initializeDriver();
        log.info("Driver intialized");


        driver.get(prop.getProperty("url"));
        log.info("Page loaded");
    }

    @Test(dataProvider="getData")
    public void CreateComputer(String Name, String Date) throws IOException {

        mainPage mp =new mainPage(driver);
        mp.addComputer().click();

        addNewComputer ad= new addNewComputer(driver);
        ad.getName().sendKeys(Name);
        ad.getintroducedDate().sendKeys(Date);
        ad.getchooseCompany().click();;
        ad.getcompanyName().click();
        ad.getcreate().click();
        String text= ad.getalert().getText();
        Assert.assertTrue(text.contains("created"));
        log.info("Computer Created");


    }


    @DataProvider
    public Object[][] getData(){

        Object data[][]=new Object[1][2];
        //create first computer
        data[0][0] = "MacBook Pro";
        data[0][1] = "1995-03-23";




    return data;


    }

    //FIXME what about if it is in the parent class?
    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
