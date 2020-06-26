package ESO;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tasks {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        //open browser
        driver = WebDriverFactory.getDriver("chrome");
        // maximize the window
        driver.manage().window().maximize();
        //use implicitlywait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        //close the browser
        driver.quit();
    }

    @Test
    public void task1() throws InterruptedException {
        //navigate to website
        driver.get("https://www.propertypal.com/");
        WebElement Search = driver.findElement(By.xpath("/html/body/div[1]/div/article/article/div/div[2]/div/div/div[1]/div/form/div/div[1]/section/input"));
        Search.click();
        Thread.sleep(2000);

      // user Current location
       WebElement CurrentLocation = driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div[1]/div/div/div/a/strong"));
      // verify my location is
       String ActualResult = CurrentLocation.getText();
       String ExpectResult = " My Location";
       Assert.assertEquals(ActualResult,ExpectResult);

        System.out.println(CurrentLocation.getText());

    }

    @Test
    public void task2(){
        //navigate to website
        driver.get("https://www.propertypal.com/");
        WebElement Search = driver.findElement(By.xpath("/html/body/div[1]/div/article/article/div/div[2]/div/div/div[1]/div/form/div/div[1]/section/input"));
        // search with BT6
         Search.sendKeys("BT6" +Keys.ENTER);
        WebElement BT6 = driver.findElement(By.xpath("//*[@id=\"body\"]/div[1]/div[2]/div/div/h1"));
        // verify expect and actual results
        String ExpectResult = "PROPERTY FOR SALE IN BT6";
        String ActualResult = BT6.getText();
        Assert.assertEquals(ActualResult,ExpectResult);

        System.out.println(BT6.getText());

    }
    @Test
    public void task3(){
        //navigate to website
        driver.get("https://www.propertypal.com/");
        WebElement Search = driver.findElement(By.xpath("/html/body/div[1]/div/article/article/div/div[2]/div/div/div[1]/div/form/div/div[1]/section/input"));
        // search with NW2
        Search.sendKeys("NW2" +Keys.ENTER);
        WebElement NW2 = driver.findElement(By.xpath("//*[@id=\"body\"]/div[1]/div[2]/div/div/h1"));
        // verify expect and actual results
        String ExpectResult = "SORRY, NO PROPERTIES FOUND";
        String ActualResult = NW2.getText();
        Assert.assertEquals(ActualResult,ExpectResult);

        System.out.println(NW2.getText());


    }

}
