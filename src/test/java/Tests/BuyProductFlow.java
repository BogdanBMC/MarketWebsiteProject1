package Tests;

import PageObjects.*;
import TestComponents.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyProductFlow extends BaseTests {





    @Test
    public void buyproductFlow() throws Exception {

        ProductPage productPage = loginPage.login();
        productPage.addProductToCart("iphone 13 pro");
        Cart cart= productPage.openCart();
        Assert.assertTrue(cart.checkIfProductIsInCart("iphone 13 pro"));
        CheckoutPage checkoutPage = cart.gotoCheckout();
        checkoutPage.selectCountry("romania");
        PlaceOrder placeOrder = checkoutPage.order();
        Assert.assertTrue(placeOrder.getConfirmationMessage());

    }




}
