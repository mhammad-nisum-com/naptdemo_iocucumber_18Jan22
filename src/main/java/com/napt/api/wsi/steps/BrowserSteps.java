package com.napt.api.wsi.steps;

import com.napt.framework.ui.interactions.Clicks;
import com.napt.framework.ui.interactions.Element;
import com.napt.framework.ui.interactions.Navigate;
import com.napt.framework.ui.interactions.Wait;
import com.napt.framework.ui.runner.EnvVariables;

import com.napt.framework.ui.runner.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserSteps{
    private static final Logger log = Logger.getLogger(BrowserSteps.class);
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

    @Then("^I should be on the \"([^\"]*)\" page$")
    public void iShouldBeOnTheProductPage(String PageName){
        if(PageName.equalsIgnoreCase("VP")){
            String VP_url=WebDriverManager.getCurrentUrl();
            Assert.assertTrue(VP_url.contains("credit"),"Navigated to VP page properly");
            log.info("VP url is navigated properly");
            if (Element.elementPresent("home_page.VP_validate")){
            Assert.assertTrue(Element.elementPresent("home_page.VP_validate"), "VP page is not loaded properly");
            log.info("Navigated to the Value Proposition page");}
            else if (Element.elementPresent("home_page.VP_WE_validate")){
                Assert.assertTrue(Element.elementPresent("home_page.VP_WE_validate"), "VP page is not loaded properly");
                log.info("Navigated to the Value Proposition page");
            }
        }
        else if(PageName.equalsIgnoreCase("SignIn_Create")){
            boolean signin_Button_Visible=Element.findElement("Signin_create_account_page.signin_button").isDisplayed();
            Assert.assertTrue(signin_Button_Visible,"Sign in button is not displayed");
            log.info("Navigated properly to Sign in page");
        }
        else if(PageName.equalsIgnoreCase("COF")){
            String COF_url=WebDriverManager.getCurrentUrl();
            Assert.assertTrue(COF_url.contains("https://applynow-qa.capitalone.com/"),"Not navigated to COF page properly");
            log.info("Navigated properly to COF page");
        }

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
        caps.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
        //caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
        //caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
        WebDriver driver = new RemoteWebDriver(new URL(url), caps);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }

    @ Given("I am on the \"([^\"]*)\" home page$")
    public void openHomePage(String HomePage) throws URISyntaxException {
        String baseURL=EnvVariables.getEnvVariables().get("webURL");
        String creds="pkqaenv:Ca8tWh33l";
        URI tempUri=new URI(baseURL);
       URI url=new URI(tempUri.getScheme(), creds.toString(), tempUri.getHost(), tempUri.getPort(), tempUri.getPath(), tempUri.getQuery(),
                tempUri.getFragment());
       WebDriverManager.getDriver().get(url.toString());

       WebDriverManager.getDriver().findElement(By.id("details-button")).click();
        WebDriverManager.getDriver().findElement(By.id("proceed-link")).click();
    }


    @When("User clicks on apply now link in \"([^\"]*)\"$")
    public void clickLink(String PageLink) throws InterruptedException {
   if(PageLink.equalsIgnoreCase("Footer"))
   {

       Clicks.scrollToLazyLoadElement("home_page.FooterApplyNow");
       JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getDriver();
       js.executeScript("window.scrollBy(0,5000)");
       Thread.sleep(5000);
       js.executeScript("window.scrollBy(0,5000)");
//        WebDriverManager.getDriver().findElement(By.xpath("//div[@id='footer-content']/div[3]/ul//a[@title='Apply Now']")).click();
       Clicks.click("home_page.FooterApplyNow");
   }
   else if(PageLink.equalsIgnoreCase("VP_ApplyNow"))
   {
       if (Element.elementPresent("home_page.VP_ApplyNow_Button")) {
//           Wait.untilElementPresent("home_page.VP_ApplyNow_Button");
           Clicks.click("home_page.VP_ApplyNow_Button");
       }else if (Element.elementPresent("home_page.VP_WE_ApplyNow_Button")){
           Clicks.click("home_page.VP_WE_ApplyNow_Button");
       }
   }
   else if(PageLink.equalsIgnoreCase("PIP_page")){
       WebElement search=Element.findElement("search.Search_textbox");
       search.sendKeys("8039131");

       Clicks.click("search.Search_image");

       String PIP_url=WebDriverManager.getCurrentUrl();
       Assert.assertTrue(PIP_url.contains("products"),"Navigated to PIP page properly");
       log.info("Navigated to PIP page properly");
       Clicks.click("product_page.PIP_page_applynow");
       //Wait.untilElementPresent("product_page.PIP_page_applynow");
       String parent=WebDriverManager.getDriver().getWindowHandle();

       Set<String> s=WebDriverManager.getDriver().getWindowHandles();
       // Now iterate using Iterator
       Iterator<String> I1= s.iterator();

       while(I1.hasNext())
       {
           String child_window=I1.next();
           if(!parent.equals(child_window)) {
               WebDriverManager.getDriver().switchTo().window(child_window);

           }}

   }
   else if(PageLink.equalsIgnoreCase("ShoppingCart_page")){
       navigateToPIPPage();
       if (Element.elementPresent("product_page.select_attribute")){
           Clicks.click("product_page.select_attribute");
       }
       Clicks.click("product_page.add_quantity");
       Clicks.click("product_page.addtocart");
       Clicks.click("product_page.checkoutbutton");
       Wait.untilElementPresent("shoppingCart_page.shopping_cart_page_applynow");
       String shoppingCart_url=WebDriverManager.getCurrentUrl();
       Assert.assertTrue(shoppingCart_url.contains("shoppingcart"),"Navigated to shopping cart page properly");
       Clicks.click("shoppingCart_page.shopping_cart_page_applynow");
       String baseURL=EnvVariables.getEnvVariables().get("webURL");
       if (baseURL.contains("westelm"))
       {
           String parent=WebDriverManager.getDriver().getWindowHandle();

           Set<String> s=WebDriverManager.getDriver().getWindowHandles();
           // Now iterate using Iterator
           Iterator<String> I1= s.iterator();

           while(I1.hasNext())
           {
               String child_window=I1.next();
               if(!parent.equals(child_window)) {
                   WebDriverManager.getDriver().switchTo().window(child_window);
               }}

       }
   }else if(PageLink.equalsIgnoreCase("myAccount"))
   {
       Actions actions = new Actions(WebDriverManager.getDriver());
       WebElement target = Element.findElement("my_account_page.myAccount_menu");
       actions.moveToElement(target).perform();
       Clicks.click("my_account_page.myAccount_applynow");
    log.info("apply now under my account is clicked properly");
   }

    }


    @And("I signin with credentials")
    public void iSigninWithCredentials() {
        Element.findElement("Signin_create_account_page.signin_email").sendKeys("ljavvaji@wsgc.com");
        log.info("Email is entered properly");
        Element.findElement("Signin_create_account_page.signin_password").sendKeys("test1234");
        log.info("password is entered properly");
        Clicks.click("Signin_create_account_page.signin_button");

    }

    @Then("I click on {string} button under Myaccount")
    public void iClickOnButtonUnderMyaccount(String pagelink) {
        if(pagelink.equalsIgnoreCase("Signin")){
            Actions actions = new Actions(WebDriverManager.getDriver());
            WebElement target = Element.findElement("my_account_page.myAccount_menu");
            actions.moveToElement(target).perform();
            Clicks.click("my_account_page.myAccount_signin");
            log.info("sign in button is clicked properly");
        }
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() throws URISyntaxException {
        String baseURL=EnvVariables.getEnvVariables().get("webURL");
        String creds="pkqaenv:Ca8tWh33l";
        URI tempUri=new URI(baseURL);
        URI url=new URI(tempUri.getScheme(), creds.toString(), tempUri.getHost(), tempUri.getPort(), tempUri.getPath(), tempUri.getQuery(),
                tempUri.getFragment());
        WebDriverManager.getDriver().get(url.toString());

        WebDriverManager.getDriver().findElement(By.id("details-button")).click();
        WebDriverManager.getDriver().findElement(By.id("proceed-link")).click();
    }

    public void navigateToPIPPage()
    {
        WebElement search=Element.findElement("search.Search_textbox");
        search.sendKeys("8039131");
        Clicks.click("search.Search_image");
        Wait.untilElementPresent("product_page.addtocart");
        String PIP_url=WebDriverManager.getCurrentUrl();
        Assert.assertTrue(PIP_url.contains("products"),"Navigated to PIP page properly");
    }
    public void navigateToShoppingCartPage()
    {

    }
}
