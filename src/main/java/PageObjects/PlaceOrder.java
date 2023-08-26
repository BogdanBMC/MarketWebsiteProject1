package PageObjects;

import CommonUseFunctionalities.Funtionalities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PlaceOrder extends Funtionalities {

    WebDriver driver;
    public PlaceOrder(WebDriver driver){
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

@FindBy (css = ".hero-primary")
    WebElement confirmationMessage;


    public boolean getConfirmationMessage() throws Exception {
        if(confirmationMessage.getText().equalsIgnoreCase("THANKYOU FOR THE ORDER.")){
            return true;
        }
        return false;
    }



}
