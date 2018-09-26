package testPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchGoogle {

    protected WebDriver driver;

    @BeforeTest
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/ncr");
    }

    @Test
    public void doFindSelenium() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(By.name("q")).sendKeys("selenium" + "\n");
        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(.,'Selenium - Web Browser Automation')]")).
                getText(), "Selenium - Web Browser Automation");

        driver.findElement(By.cssSelector("#hdtb-msb-vis div:nth-child(3) a")).click();
        driver.findElement(By.xpath("//img[@id='1kNJvnyWka1zxM:']")).isDisplayed();
        driver.findElement(By.xpath("//img[@id='1kNJvnyWka1zxM:']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//span[@class='irc_su' and contains(.,'GitHub - SeleniumHQ/selenium: A browser automation framework and ecosystem.')]")));
        Assert.assertEquals(driver.findElement(By.xpath
                ("//span[@class='irc_su' and contains(.,'GitHub - SeleniumHQ/selenium: A browser automation framework and ecosystem.')]")).
                getText(), "GitHub - SeleniumHQ/selenium: A browser automation framework and ecosystem.");

        driver.findElement(By.cssSelector("#hdtb-msb-vis div:nth-child(1) a")).isEnabled();
        driver.findElement(By.cssSelector("#hdtb-msb-vis div:nth-child(1) a")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(.,'Selenium - Web Browser Automation')]")).
                getText(), "Selenium - Web Browser Automation");
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.close();
        }
    }
}