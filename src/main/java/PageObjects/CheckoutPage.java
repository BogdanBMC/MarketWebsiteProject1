package PageObjects;

import CommonUseFunctionalities.Funtionalities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends Funtionalities {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "input[placeholder='Select Country']")
    WebElement countryField;

    @FindBy(xpath = "//span[@class='ng-star-inserted']")
    List<WebElement> listaTari;

    @FindBy(xpath = "//div[@class='actions'] //a")
    WebElement orderButton;

    public void selectCountry(String country) throws InterruptedException {
        countryField.click();
        countryField.sendKeys("rom");
        scrollWindowBy();
        for (int i = 0; i < listaTari.size(); i++) {
            waitForElementToAppear(listaTari.get(i));
            if (listaTari.get(i).getText().equalsIgnoreCase(country)) {
                listaTari.get(i).click();
            }
        }
    }

    public PlaceOrder order(){
        orderButton.click();
        PlaceOrder placeOrder = new PlaceOrder(driver);
        return placeOrder;
}


}
