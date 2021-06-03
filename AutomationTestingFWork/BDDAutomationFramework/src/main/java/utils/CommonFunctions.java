package utils;

import io.cucumber.plugin.event.HookTestStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {

    public static WebDriver driver;
    public static String propertiesFilePath =  new File("src/main/resources/testData/config.properties").getAbsolutePath();
    public static String errorShotsPath = new File("src/main/resources/errorShots").getAbsolutePath();


    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        //System.out.println(driver);
    }

    public void closeBrowser()
    {
        driver.quit();
    }

    public void waitForTime(int waitTime)
    {

        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    public void waitForElement(WebDriver driver, int i, WebElement element) {
        WebDriverWait wait=new WebDriverWait(driver,i);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void inputField(WebElement element,String text)
    {
        element.sendKeys(text);
    }

    public void mouseOver(WebElement element)
    {

        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void JSClick(WebElement element)
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);

    }

    public void ScrollPage(int x,int y)
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+")");

    }

    public String readProperty(String key) throws Exception
    {
        FileInputStream inputStream = new FileInputStream(propertiesFilePath);
        Properties properties = new Properties();
        properties.load(inputStream);
        String value =  properties.getProperty(key);
        return value;
    }

    public void takeScreenshot(String fileName) throws Exception
    {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(errorShotsPath+"/"+fileName);
        FileUtils.copyFile(srcFile, destFile);
    }

}
