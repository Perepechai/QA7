package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class test1 {
    WebDriver driver;

    private final String searchInput = "//input";
    private final String searchProduct = "//span[@class=\"goods-tile__title\"]";
    private String ProductText;

    @BeforeClass
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }
    @BeforeMethod
    public void openBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://rozetka.com.ua/");
    }
    @Test
    public void newtest()
    {
        WebElement searchElement = driver.findElement(By.xpath(searchInput));
        searchElement.clear();
        searchElement.sendKeys("Монитор\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement searchElement1 = driver.findElement(By.xpath(searchProduct));
        ProductText = searchElement1.getText();
        Assert.assertTrue(ProductText.contains("Mонитор"), "Not contain");
    }
    @AfterMethod
    public void quitBrowser()
    {
        driver.quit();
    }
}
