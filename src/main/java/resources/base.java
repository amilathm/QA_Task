package resources;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    public WebDriver driver;
    public Properties prop;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime now = LocalDateTime.now();
    public String today = dtf.format(now);
    public WebDriver initializeDriver() throws IOException {

        prop =new Properties();
        FileInputStream fis =new FileInputStream("/Users/amilathmuhammed/Documents/selenium/TA_Task/src/main/java/resources/data.properties");
        prop.load(fis);
        System.setProperty("webdriver.chrome.driver", "//Users//amilathmuhammed//Documents//selenium//chromedriver");
        driver = new ChromeDriver();

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

