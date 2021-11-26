package bookbot;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BookBotApplication {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
//        WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME, true);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        WebDriverWait driver = new WebDriverWait(chromeDriver, Duration.ofMillis(100));

        try {
            log.info("Hola hola!");
            // declaration and instantiation of objects/variables


            String baseUrl = "https://app.myturn.es/login";

            // launch and direct it to the Base URL
            driver.get(baseUrl);

            WebElement inputEmail = driver.findElement(By.id("inputEmail"));
            inputEmail.sendKeys("jmarcosbarrio@gmail.com");

            WebElement inputPassword = driver.findElement(By.id("inputPassword"));
            inputPassword.sendKeys("clavijo1985");

            driver.findElement(By.className("btn-lg")).click();

            Actions action = new Actions(driver);

            WebElement element = driver.findElement(By.cssSelector(".myturn-service"));
            action.moveToElement(element).perform();
            By locator = By.className("view-more-button");
            driver.findElement(locator).click();

            Thread.sleep(10000);
        } catch (Throwable e) {
            System.out.println(e);
        } finally {
            log.info("Saliendo...");

            //close Chrome
            driver.close();
        }


    }
}
