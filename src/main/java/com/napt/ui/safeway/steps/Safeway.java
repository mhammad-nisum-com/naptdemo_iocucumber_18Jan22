package com.napt.ui.safeway.steps;

import com.napt.framework.ui.interactions.Clicks;
import com.napt.framework.ui.interactions.Element;
import com.napt.framework.ui.interactions.Wait;
import com.napt.framework.ui.runner.EnvVariables;
import com.napt.framework.ui.runner.WebDriverManager;
import com.napt.framework.ui.utils.StepUtils;
import com.napt.ui.safeway.pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Safeway {

    Login login = new Login();
    @Given("that I open the home page of safeway website")
    public void openHomePage(){
        WebDriverManager.getDriver().get(EnvVariables.getEnvVariables().get("webURL"));
        if(StepUtils.MEW()){
            //code for MEW if any
        }else{
            Element.findElement("home.popupCookieClose").click();
            Element.findElement("home.btnDugOrDeliveryClose").click();
        }



    }

    @Given("I signin to the website")
    public void signIn() throws Exception{
        login.signIn();
    }

    @When("I search for {string} on the home page")
    public void searchProductOnHome(String  productName) throws Exception{
        Thread.sleep(5000);
        Element.findElement("home.inputSearchBox").sendKeys("milk" + Keys.ENTER);
    }


    @When("I select a random search result")
    public void selectRandomSearchResult() throws InterruptedException {
        Thread.sleep(5000);
        Element.getRandomElement("searchresults.btnAdd").click();
        Thread.sleep(5000);

    }

    @When("I clear the cart")
    public void clearCart() throws InterruptedException {
        if(StepUtils.MEW()){

            Clicks.click("searchresults.btnToTheTop");
            Clicks.click("cart.linkCartOnTopRight");
        }else{
            Clicks.click("cart.linkCart");

        }
        List<WebElement> removeLinks = Element.findElements("cart.buttonRemoveCartItem");
        for(WebElement we:removeLinks){
            we.click();
            Thread.sleep(1000);
        }

    }


}
