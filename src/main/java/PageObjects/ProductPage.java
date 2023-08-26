package PageObjects;

import CommonUseFunctionalities.Funtionalities;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;
import java.util.List;

public class ProductPage extends Funtionalities  {

    WebDriver driver;
    public ProductPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = ".mb-3")
    List<WebElement> listaProduse;

    @FindBy (css ="button[routerlink*=cart]")
    WebElement cartButton;

    @FindBy (css = "#toast-container")
    WebElement toaster;

    @FindBy (css = ".ng-animating")
    WebElement animation;

    //find product
    //add to cart

    public  void addProductToCart(String name) throws Exception {

        for (WebElement produs : listaProduse){
            if(produs.findElement(By.tagName("b")).getText().equalsIgnoreCase(name)){
                produs.findElement(By.cssSelector(".w-10")).click();
                break;
            }
        }
    }





    /* wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating")))) ;
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));*/

    public Cart openCart() throws InterruptedException {
        waitForElementToAppear(toaster);
        waitForElementToDissappear(animation);
    cartButton.click();
    Cart cart = new Cart(driver);
    return cart;
    }




}
