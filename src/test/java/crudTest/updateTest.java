package crudTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.editPage;
import pageObject.filterPage;
import pageObject.mainPage;
import resources.base;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class updateTest extends base {
    public static Logger log = LogManager.getLogger(base.class.getName());
    public WebDriver driver;

    @BeforeTest
    public void openBrowser() throws IOException {
        driver = initializeDriver();
        log.info("Driver intialized");
        driver.get(prop.getProperty("url"));
        log.info("Page loaded");
    }
    @Test(dataProvider = "getData")
    public void UpdateComputer(String Name, String Date, String UpdatedName, String DiscountinuedDate) throws IOException {

        mainPage mp = new mainPage(driver);
        filterPage fp = new filterPage(driver);
        editPage ep = new editPage(driver);
        mp.filterByName().sendKeys(Name);
        mp.filtersubmit().click();

        String iteration=ep.getNext().getText();

        String[] bits = iteration.split(" ");
        String lastOne = bits[bits.length-1];
        double count=  (double)Integer.parseInt(lastOne)/10;
        int b= (int)Math.ceil(count);

for(int j=0;j<b;j++) {
    int search = fp.getsize().size();

    for (int i = 0; i < search; i++) {
        //System.out.println(driver.findElements(By.xpath("//table[@class='computers zebra-striped'] //tbody //tr //td")).get(i).getText().contains(introducedDate));

        if (fp.getsize().get(i).getText().contains(Date)) {
            ep.getcomputer().click();
            ep.getName().clear();
            ep.getName().sendKeys(UpdatedName);
            ep.getDiscontinuedDate().clear();
            ep.getDiscontinuedDate().sendKeys(DiscountinuedDate);
            ep.getSave().click();
            String text = ep.getAlert().getText();
            log.info(text);
            Assert.assertTrue(text.contains("updated"));
            log.info("Computer details updated");
            break;

        }

    }

    ep.getNextSubmit().click();
   }


    }


        @DataProvider
        public Object[][] getData(){

            Object data[][]=new Object[1][4];

            data[0][0] = "MacBook";
            data[0][1] = "10 Jan 2006";
            data[0][2] = "MacBook Air older";
            data[0][3] = today;


        return data;
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}