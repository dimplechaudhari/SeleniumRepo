import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {
   public static ChromeOptions options;
   public static WebDriver driver;
    @BeforeTest
    void Setup()
    {
        options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver=new ChromeDriver(options);
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
    }

    @Test
    void teststeps() throws InterruptedException {
        WebElement menu=driver.findElement(By.xpath("//input[@type='checkbox']"));
        menu.click();
        Thread.sleep(2000);
        WebElement sn=driver.findElement(By.xpath("//li[normalize-space()='Sign In Portal']"));
        sn.click();
        WebElement Un= driver.findElement(By.xpath("//input[@id='usr']"));
        Un.sendKeys("sa");
        WebElement pwd= driver.findElement(By.xpath("//input[@id='pwd']"));
        pwd.sendKeys("sa");
        WebElement login= driver.findElement(By.xpath("//input[@value='Login']"));
        login.click();

        WebElement formalshoes= driver.findElement(By.xpath("//div[@id='SmokeTests']//h3[@id='ShoeType']"));

        Thread.sleep(2000);

        String actualFirstCategory = formalshoes.getText();

        String expectedFirstCategory="Formal Shoes";

        Assert.assertEquals(expectedFirstCategory,actualFirstCategory);

        System.out.println("Test Pass");

        driver.close();
    }
}
