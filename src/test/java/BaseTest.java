import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {
    static WebDriver driver;
    public String url = null;
    public static void loginKoel() {

        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.sendKeys("dashazhyrkova@gmail.com");
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.sendKeys("te$t$tudent28");
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }

    public static void navigateToAllSongs() {
        WebElement navigateToAllSongsPage = driver.findElement(By.xpath("//a[@href='#!/songs']"));
        navigateToAllSongsPage.click();
    }

    public static void songDoubleClick() {
        Actions act = new Actions(driver);
        WebElement songDoubleClick = driver.findElement(By.cssSelector("[class='song-item']"));
        act.doubleClick(songDoubleClick).perform();
    }


    public static void songIsPlaying() {
        WebElement songIsPlaying = driver.findElement(By.cssSelector("[alt='Sound bars']"));
        Assert.assertTrue(songIsPlaying.isDisplayed());
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void setUpBrowser(String baseURL) {
       url = baseURL;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void loginSubmit() {
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }

    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        loginSubmit();
    }
}
