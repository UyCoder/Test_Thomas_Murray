
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.nio.file.FileSystems;
import java.util.concurrent.TimeUnit;

public class Tests {

    WebDriver driver;

    @BeforeSuite
    public void openChromeAndNavigetHomePage() {
        // setup system variable for chromedriver
        System.setProperty("webdriver.chrome.driver", FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "\\chromedriver\\chromedriver.exe");
        // open chrome browser
        driver = new ChromeDriver();

        // open home page
        driver.manage().window().maximize();
        // wait untill page is loaded
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        // get home page
        driver.get(" https://unsplash.com/");
    }


    @Test
    public void visitCategoryWallpapersAndDownloadFirstWallPaper() {
        // define a variable for the category wallpapers
        String categoryWallpapers = "//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div/div[2]/div[2]/ul/li[3]/a/span";
        // click on the category wallpapers
        driver.findElement(By.xpath(categoryWallpapers)).click();

        // define a variable for the first wallpaper
        String firstWallpaper = "//*[@id=\"app\"]/div/div[3]/div[2]/div/div/div/div[2]/figure[1]/div";


        // assert if element present
        if (driver.findElements(By.xpath(firstWallpaper)).size() > 0) {
            // if element present, click on it
            driver.findElement(By.xpath(firstWallpaper)).click();
        } else {
            // if element not present, scroll down to the bottom of the page
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,1080)");
            // click on the first wallpaper
            driver.findElement(By.xpath(firstWallpaper)).click();
        }

        // define the width and height of the image
        int width=driver.findElement(By.xpath(firstWallpaper)).getSize().getWidth();
        int hight=driver.findElement(By.xpath(firstWallpaper)).getSize().getHeight();
        // assert if the resolution of the image is greater than 500x500
        Assert.assertTrue(width>500 && hight>500);


        // define a variable for the download button
        String downloadButton = "//header/div[2]/div[3]/div[1]/a[1]";
        // click on the download button
        driver.findElement(By.xpath(downloadButton)).click();

    }


    @Test
    public void visitCategoryArchitectureAndDownloadFirstWallPaper(){
        // define a variable for the category architecture
        String categoryArchitecture = "//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div/div[2]/div[2]/ul/li[7]/a/span";

        // click on the category architecture
        driver.findElement(By.xpath(categoryArchitecture)).click();
        // define a variable for the first wallpaper
        String firstWallpaper = "//*[@id=\"app\"]/div/div[3]/div[2]/div/div/div/div[1]/figure[2]/div/div/a/div/div[2]/div/img";


        // assert if element present
        if (driver.findElements(By.xpath(firstWallpaper)).size() > 0) {
            // if element present, click on it
            driver.findElement(By.xpath(firstWallpaper)).click();
        } else {
            // if element not present, scroll down to the bottom of the page
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,1080)");
            // click on the first wallpaper
            driver.findElement(By.xpath(firstWallpaper)).click();
        }


        // define the width and height of the image
        int width=driver.findElement(By.xpath(firstWallpaper)).getSize().getWidth();
        int hight=driver.findElement(By.xpath(firstWallpaper)).getSize().getHeight();
        // assert if the resolution of the image is greater than 500x500
        Assert.assertTrue(width>500 && hight>500);


        // define a variable for the download button
        String downloadButton = "/html/body/div[4]/div/div/div[4]/div/div/div[1]/div[1]/header/div[2]/div[3]/div/a/span";
        // click on the download button
        driver.findElement(By.xpath(downloadButton)).click();

    }

    @AfterSuite
    public void closeChrome() {
        // close chrome browser
        driver.quit();
    }

}
