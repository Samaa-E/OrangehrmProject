package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Hooks {
    public static WebDriver driver = null ;
    @Before
    public static void testSetup ()
    {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        Hooks.driver.manage().window().maximize();
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));

    }
    @After
    public static void closeBrowser()
    {

        Hooks.driver.quit();
    }
}