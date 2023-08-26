package PageObjects;

import CommonUseFunctionalities.Funtionalities;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class Cart extends Funtionalities {

    WebDriver driver;

    public Cart(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy (css = ".cartSection")
    List<WebElement> produseInCart;

    @FindBy (xpath = "//button[text()='Checkout']")
    WebElement checoutButton;

public boolean checkIfProductIsInCart(String prodName) throws Exception {

    for(int i = 0; i<produseInCart.size();i++){
        if(produseInCart.get(i).findElement(By.tagName("h3")).getText().equalsIgnoreCase(prodName)){
            return true;
        }
        }
    throw new Exception("Element not found in cart");
    }

    public CheckoutPage gotoCheckout(){
    checoutButton.click();
    CheckoutPage checkoutPAge = new CheckoutPage(driver);
    return checkoutPAge;
}



}
