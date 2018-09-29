package test;

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

    private WebDriver driver;

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
        //ToDo Google opyat` izmenil context... Pogovorim ob etom zavtra.
        //ToDo Special`no ostavil dlya tebya eti predidushee locatori, chto bi ti videl, chto takaya kartinka deistvitel`no otsutstvuet na stranice.
        //driver.findElement(By.xpath("//img[@id='1kNJvnyWka1zxM:']")).isDisplayed();
        //driver.findElement(By.xpath("//img[@id='1kNJvnyWka1zxM:']")).click();
        driver.findElement(By.xpath("//img[@id='bi_EQbbxaRl0hM:']")).isDisplayed();
        driver.findElement(By.xpath("//img[@id='bi_EQbbxaRl0hM:']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                //        ("//span[@class='irc_su' and contains(.,'GitHub - SeleniumHQ/selenium: A browser automation framework and ecosystem.')]")));
                        ("//span[@class='irc_ho' and contains(.,'Selenium')]")));

        Assert.assertEquals(driver.findElement(By.xpath
//                ("//span[@class='irc_su' and contains(.,'GitHub - SeleniumHQ/selenium: A browser automation framework and ecosystem.')]")).
//                getText(), "GitHub - SeleniumHQ/selenium: A browser automation framework and ecosystem.");
        ("//span[@class='irc_ho' and contains(.,'Selenium')]")).getText(), "Selenium");

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