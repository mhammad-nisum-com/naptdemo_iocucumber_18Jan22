package com.napt.ui.gap.pages;

import com.napt.framework.ui.interactions.Clicks;
import com.napt.framework.ui.interactions.DropDowns;
import com.napt.framework.ui.interactions.Element;
import com.napt.framework.ui.interactions.Wait;
import com.napt.framework.ui.runner.WebDriverManager;
import com.napt.framework.ui.utils.StepUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class PDP {

    public void closeOfferDialog(){
        Clicks.clickIfPresent("search.openOfferDialogBtn");
        Clicks.clickIfPresent("search.closeOfferDialogBtn");
    }
    public void checkout() throws Exception{
        Thread.sleep(3000);
        Wait.secondsUntilElementPresentAndClick("product_page.checkoutBtn",5);
        StepUtils.shouldBeOnPage("shopping_bag_page");
    }

    public boolean swipeScreen(Direction direction,WebDriver driver) {
        System.out.println("swipeScreen(): dir: '" + direction + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();


        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (direction) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, ((dims.height/2) + (dims.height/8)) );
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, ((dims.height/2) - (dims.height/8)));
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + direction + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction((PerformsTouchActions) driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return false;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
        return true;
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

    public void addToBag()throws Exception{
            closeOfferDialog();
            if(StepUtils.MEW()){
                Wait.secondsUntilElementToBeClickable("product_page.color",2);
                Clicks.randomJavascriptClick("product_page.color");
                Clicks.randomJavascriptClick("product_page.size");
                DropDowns.selectByText("product_page.qty","3");
            }else{
                Clicks.randomJavascriptClick("product_page.color");
                Clicks.randomJavascriptClick("product_page.size");
                Element.moveToElement("product_page.drawertext");
                Wait.secondsUntilElementToBeClickable("product_page.qtybtn",3);
                Clicks.click("product_page.qtybtn");
                List<WebElement> listQty = Element.findElements("product_page.qty");
                for(WebElement we:listQty){
                    try{
                        if (we.getText().equals("2")) {
                            Element.moveToElement(we);
                            Thread.sleep(1000);
                            we.click();
                            break;
                        }
                    }catch(StaleElementReferenceException e){
                        System.out.println(e.getMessage());
                    }

                }

            }


            Clicks.javascriptClick("product_page.addtoBagBtn");


    }
}
