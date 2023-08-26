package TestComponents;

import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;



public class BaseTests {
   public WebDriver driver; // e deja inil=tializat aici ii atribui valori mai jos
  public  LoginPage loginPage;  // initializam aici sa putem sa folosim neinitializat jos plus returnat



    public WebDriver initialiseDriver(){
        //String browser = "firefox";
        String browser = System.getProperty("browser");


        if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.geko.driver", "C:\\JavaProjects\\gecko\\geckodriver.exe\\");
            driver = new FirefoxDriver();
        }
        else  if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\JavaProjects\\gecko\\geckodriver.exe\\");
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "C:\\JavaProjects\\gecko\\geckodriver.exe\\");
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        return driver;
    }



@BeforeMethod(alwaysRun = true)   // asta o sa ruleze inainte de toate @test din toate clasele pe care le da chestii
public LoginPage openLoginPage(){
        driver = initialiseDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://rahulshettyacademy.com/client/");
        return loginPage;

}

@AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.close();
}







}
