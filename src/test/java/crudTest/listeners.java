package crudTest;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pageObject.base;

import java.io.IOException;

public class listeners extends base implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        WebDriver driver =null;
        String failedMethodName = iTestResult.getMethod().getMethodName();
        try {
            driver= (WebDriver)iTestResult.getTestClass().getRealClass().getDeclaredField("driver").get(iTestResult.getInstance());
        } catch (Exception e) {
            //FIXME it is not a good practice to ignore an exception. Sometimes we do tho :( it is possible to do something in catch block?
        }
        try {
            getScreenShotPath(failedMethodName,driver);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
