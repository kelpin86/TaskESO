package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType){
        WebDriver driver=null;

        if ("chrome".equals(browserType.toLowerCase())) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("firefox".equals(browserType.toLowerCase())) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }


        return driver;
    }
}
