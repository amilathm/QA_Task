package pageObject;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    public WebDriver driver;
    public Properties prop;
    //FIXME please consider adding locators to all java class attributes
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime now = LocalDateTime.now();
    //FIXME does it need to be here? if so what about if you create a method like or move it for a Utils class? Many possibilities here
    /*
    public String getTodayYearMonthDayFormat() {
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDateTime now = LocalDateTime.now();
      return dtf.format(now);
    }
     */
    public String today = dtf.format(now);
    public WebDriver initializeDriver() throws IOException {

        //FIXME please ident ur code -
        prop =new Properties();
        //FIXME please avoid hard coded values. I don't have amilathmuhammed folder in my machine :)
        //FIXME try this:
        InputStream fis = getClass().getClassLoader().getResourceAsStream("data.properties");
        prop.load(fis);
        // You need also to Mark Directory as Test Resources Root
        //FIXME Same here:
        //Take a look if there is a way to have the path hardcoded:
        // like here : https://stackoverflow.com/questions/32723558/how-can-i-have-the-chromedriver-path-not-be-hardcoded
        System.setProperty("webdriver.chrome.driver", "//Users//amilathmuhammed//Documents//selenium//chromedriver");
        driver = new ChromeDriver();

        //FIXME why using implicity wait? Please have a check on it. Personally I don't like it. It adds slowness to the test execution
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("./Screenshots/"+testCaseName+".png");
        FileUtils.copyFile(source,new File(destinationFile));

        return destinationFile;


    }
}

