package PageObjects;

import CommonUseFunctionalities.Funtionalities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Funtionalities {
    WebDriver driver;



    public LoginPage(WebDriver driver){
super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


   @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(id = "userPassword")
    WebElement pass;

    @FindBy(id = "login")
    WebElement loginButton;

  //  public void goTo(){
   //     driver.get("https://rahulshettyacademy.com/client/");
  //  }
    public ProductPage login(){
        email.sendKeys("testaugust@gmail.com");
        pass.sendKeys("Testtest123?" );
        loginButton.click();
        ProductPage productPage =new ProductPage(driver);
        return productPage;
    }







}
