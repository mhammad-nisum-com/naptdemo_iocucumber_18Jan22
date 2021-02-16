package com.napt.ui.safeway.pages;

import com.napt.framework.ui.interactions.Clicks;
import com.napt.framework.ui.interactions.Element;
import com.napt.framework.ui.interactions.TextBoxes;
import com.napt.framework.ui.interactions.Wait;
import com.napt.framework.ui.runner.WebDriverManager;
import com.napt.framework.ui.utils.StepUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

public class Login {

    public void signIn() throws InterruptedException {
        Clicks.click("home.linkSignIn");
        Clicks.click("home.miSignIn");
        Wait.secondsUntilElementToBeClickable("signin.inputUsername",3);
        Element.findElement("signin.inputUsername").sendKeys("malavparekh@gmail.com");
        Element.findElement("signin.inputPassword").sendKeys("Blabla@1234");
        if(StepUtils.MEW()){
            Clicks.click("signin.btnCookieConsentClose");
            Clicks.click("signin.btnSignIn");
        }else {
            Clicks.click("signin.btnSignIn");
        }
    }
}
