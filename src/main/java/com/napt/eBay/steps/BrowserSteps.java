package com.napt.eBay.steps;


import com.napt.framework.ui.interactions.Element;
import com.napt.framework.ui.interactions.Navigate;
import com.napt.framework.ui.runner.WebDriverManager;
import com.napt.framework.ui.utils.StepUtils;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

public class BrowserSteps{
    private static final Logger log = Logger.getLogger(BrowserSteps.class);
    WebDriver driver = WebDriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    @Given("^that I navigate to eBay home$")
    public void iNavigateToeBayHome() throws IOException, ParseException {
        //driver.get(System.getenv("WebURL"));
        driver.get("https://www.ebay.com");
        Assert.assertTrue(Element.findElement("ebayhome.eBayLogo")!=null);
    }

    @Given("^I search for \"([^\"]*)\"$")
    public void iSearchForItem(String searchCriteria) throws IOException, ParseException {
        Element.findElement("ebayhome.inputSearch").sendKeys(searchCriteria);
        Element.findElement("ebayhome.buttonSearch").click();
    }


    @Given("^I get the search results$")
    public void iGetSearchResults() throws IOException, ParseException, InterruptedException {
        if(!StepUtils.MEW()) Assert.assertTrue(Element.findElement("ebayhome.listSearchResults") != null);
    }

    @Given("^I select an item$")
    public void iSelectRandomItem() throws IOException, ParseException, InterruptedException {
        if(StepUtils.MEW()){
            Navigate.scrollPage(0,500);

            Element.getRandomElement("ebayhome.listSearchResults").click();
        }else{
            Thread.sleep(2000);
            Element.getRandomElement("ebayhome.listSearchResults").click();

        }
    }

    String itemDescription ="";
    @Given("^I see the item details page and add item to cart$")
    public void iSeeItemDetailsPage() throws IOException, ParseException, InterruptedException {
        if (StepUtils.MEW()) {
            wait.until(ExpectedConditions.presenceOfElementLocated(Element.element("ebayItemDetails.itemName")));
            itemDescription = Element.findElement("ebayItemDetails.itemName").getText();
        } else {
            Set<String> windowHandles = driver.getWindowHandles();
            String mainWindowHandle = driver.getWindowHandle();
            String mainWindowtitle = driver.getTitle();
            for (String s : windowHandles) {
                if (!driver.getWindowHandle().equalsIgnoreCase(s)) {
                    driver.switchTo().window(s);
                    itemDescription = driver.getTitle();
                    Assert.assertTrue(!driver.getTitle().equalsIgnoreCase(mainWindowtitle));
                    Element.findElement("ebayItemDetails.buttonAddToCart").click();
                    driver.switchTo().window(mainWindowHandle);
                    driver.navigate().refresh();
                    break;
                }
            }
        }
    }


        @Given("^I view the cart$")
        public void iViewCart() throws IOException, ParseException, InterruptedException {
            Element.findElement("ebayhome.buttonCart").click();
            wait.until(ExpectedConditions.presenceOfElementLocated(Element.element("ebaycart.itemInCart")));
            Assert.assertTrue(Element.findElement("ebaycart.itemInCart").getText().toLowerCase().substring(1,30).equalsIgnoreCase(itemDescription.toLowerCase().substring(1,30)));
        }
    }
