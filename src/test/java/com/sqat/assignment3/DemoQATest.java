package com.sqat.assignment3;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DemoQATest {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setup() {

        ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        test = extent.createTest("Assignment 3 – DemoQA Test");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        test.pass("Browser launched with implicit wait");
    }

    @Test
    public void fullAutomationTest() {

        driver.get("https://demoqa.com/buttons");

        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement doubleClickBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("doubleClickBtn"))
        );

        // Fluent Wait
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement rightClickBtn = fluentWait.until(
                driver -> driver.findElement(By.id("rightClickBtn"))
        );

        // Actions Class
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();
        actions.contextClick(rightClickBtn).perform();

        test.pass("Actions class executed successfully");

        // Select Class
        driver.get("https://demoqa.com/select-menu");
        WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(dropdown);

        select.selectByVisibleText("Blue");
        select.selectByValue("3");

        String selected = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selected, "Yellow");

        test.pass("Select class verified");
    }

    @AfterTest
    public void tearDown() {
        extent.flush();
        driver.quit();
    }
}
