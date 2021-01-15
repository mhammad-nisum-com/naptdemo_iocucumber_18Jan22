package com.napt.ui.gap.steps;

import com.napt.framework.ui.interactions.Clicks;
import com.napt.framework.ui.interactions.Element;
import com.napt.framework.ui.interactions.Navigate;
import com.napt.framework.ui.interactions.Wait;
import com.napt.framework.ui.runner.EnvVariables;
import com.napt.framework.ui.runner.WebDriverManager;
import com.napt.ui.gap.entities.*;
import com.napt.ui.gap.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrowseSteps {
    private static final Logger log = Logger.getLogger(BrowseSteps.class);
    PDP pdp = new PDP();
    Search search = new Search();
    Checkout chkout = new Checkout();

    public BrowseSteps() throws MalformedURLException {
    }

    @Given("^I am on the (home|category|product) page$")
    public void iAmOnTheGivenPage(String pageName) {
        String navigateURL;

        switch(pageName) {
            case "home":
                navigateURL = EnvVariables.getEnvVariables().get("webURL") + "/browse/home.do";
            case "category":
                navigateURL = EnvVariables.getEnvVariables().get("webURL") + "/browse/category.do?cid=17076";
            case "product":
                navigateURL = EnvVariables.getEnvVariables().get("webURL") + "browse/product.do?pid=905272012";
            case "shoppingbag":
                navigateURL = EnvVariables.getEnvVariables().get("webURL") + "/shopping-bag";
            case "checkout":
                navigateURL = EnvVariables.getEnvVariables().get("webURL") + "/checkout/place-order";
            default:
                navigateURL = EnvVariables.getEnvVariables().get("webURL");
        }
        Navigate.visit(navigateURL);
        try{
            Clicks.clickIfPresent("home_page.popup");
        }catch(Exception e){
            WebDriverManager.getDriver().findElement(By.xpath("//html")).sendKeys(Keys.ESCAPE);
        }

        Assert.assertTrue(Element.elementPresent("home_page.site_logo"), "Site is not loaded properly");
        log.info("Navigated to the website as a guest user");

    }

    @When("^I navigate to (Women|Men|Toddler) (Jeans|Shorts) category$")
    public void iNavigateToCategory(String division, String category) {
        Element.findElement("home_page.select_division_men").click();
        if(category.equals("Shorts")) {
            Element.findElement("home_page.select_category_shorts").click();
        } else {
            Element.findElement("home_page.select_category_shorts").click();
        }
        Wait.forPageReady("category_page");
    }

    @And("^I select the second product$")
    public void iSelectTheSecondProduct(){
        Element.findElement("category_page.second_product").click();
        Wait.forPageReady("product_page");
    }

    @Then("^I should be on the product page$")
    public void iShouldBeOnTheProductPage(){
        Assert.assertTrue(Element.elementPresent("product_page.add_to_bag"), "ProductPage is not loaded properly");
        log.info("Navigated to the website as a guest user");
    }

    @And("^I should be able to select the size$")
    public void iShouldBeAbleToSelectTheSize(){
        Assert.assertTrue(Element.elementPresent("product_page.select_size"), "ProductPage is not loaded properly");
        log.info("Able to select sizes");
    }

    @And("^I should be able to change the quantity of add to bag$")
    public void ishouldBeAbleToChangeTheQuantityOfAddToBag(){
        Element.findElement("product_page.add_to_bag_qty_menu").click();
        Element.findElement("product_page.add_to_bag_qty_4").click();
    }





    @When("I search for \"([^\"]*)\" on home page$")
    public void searchOnHomePage(String string){
        search.searchOnHome(string);
    }

    @When("I select a random search result$")
    public void searchStringOnHomePage() throws Exception{
        search.selectRandomSearchResult();
    }

    @When("I add item to bag$")
    public void addItemToBag()throws Exception{
        pdp.addToBag();
    }


    @When("^I checkout the bag items as guest with the following details$")
    public void checkout(List<String> data) throws Exception {
        System.out.println(data.get(0));
        Address add = new Address(data.get(0),data.get(1),data.get(2),data.get(3),data.get(4),data.get(5),data.get(6),data.get(7));
        chkout.guestCheckout(add);
    }


    public static void main(String[] args) throws Exception{
        //https://pradeepkhanna1:gx252qa5gfwkgC4ajSn5@@hub-cloud.browserstack.com/wd/hub

        final String AUTOMATE_USERNAME = "pradeepkhanna1";
        final String AUTOMATE_ACCESS_KEY = "gx252qa5gfwkgC4ajSn5";
        final String url = "https://pradeepkhanna1:gx252qa5gfwkgC4ajSn5@hub-cloud.browserstack.com/wd/hub";

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "iPhone");
            caps.setCapability("device", "iPhone 11");
            caps.setCapability("realMobile", "true");
            caps.setCapability("os_version", "14.0");
            //caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
            //caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
            WebDriver driver = new RemoteWebDriver(new URL(url), caps);
            driver.get("https://www.google.com");
            System.out.println(driver.getTitle());
    }

}

