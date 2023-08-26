package CommonUseFunctionalities;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class Funtionalities {

    WebDriver driver;
    public Funtionalities(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }




   public void waitForElementToAppear(WebElement element){
       WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
       w.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToDissappear(WebElement element){
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(3));
        w.until(ExpectedConditions.invisibilityOf(element));
    }

   public void waitForElementsToLoad(WebElement elements){
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfAllElements(elements));
   }

   public void scrollWindowBy(){
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,6000)", "");
   }


}
