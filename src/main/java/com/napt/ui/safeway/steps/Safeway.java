package com.napt.ui.safeway.steps;

import com.napt.framework.ui.interactions.Clicks;
import com.napt.framework.ui.interactions.Element;
import com.napt.framework.ui.interactions.Wait;
import com.napt.framework.ui.runner.WebDriverManager;
import com.napt.ui.safeway.pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class Safeway {

    Login login = new Login();
    @Given("that I open the home page of safeway website")
    public void openHomePage(){
        WebDriverManager.getDriver().get("https://www.safeway.com");
        Element.findElement("home.popupCookieClose").click();
        Element.findElement("home.btnDugOrDeliveryClose").click();

    }

    @Given("I signin to the website")
    public void signIn(){
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

}
