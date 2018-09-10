package TestPackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchGoogle {

    protected WebDriver driver;
//    public WebDriverWait wait;

    @BeforeTest
    public final void setupTest() {
//        wait = new WebDriverWait(driver, 15);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/ncr");
    }

    @AfterTest
    public final void teardown() {
        if (driver != null) {
            driver.close();
        }
    }

    @Test
    public final void doFindSelenium() {
        driver.findElement(By.name("q")).sendKeys("selenium" + "\n");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='ires' and contains(.,'Selenium - Web Browser Automation')]")).
                getText().contains("Selenium - Web Browser Automation"));
        driver.findElement(By.cssSelector("#hdtb-msb-vis div:nth-child(3) a")).click();
        driver.findElement(By.xpath("//img[@id='1kNJvnyWka1zxM:']")).click();
        driver.findElement(By.xpath("//img[@id='1kNJvnyWka1zxM:']")).isDisplayed(); //Sometimes failed.
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'SeleniumHQ')]")).
                getText().contains("SeleniumHQ"),("Object is not matching, "));
        driver.findElement(By.cssSelector("#hdtb-msb-vis div:nth-child(1) a")).isEnabled();
        driver.findElement(By.cssSelector("#hdtb-msb-vis div:nth-child(1) a")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='ires' and contains(.,'Selenium - Web Browser Automation')]")).
                getText().contains("Selenium - Web Browser Automation"));

    }

}
