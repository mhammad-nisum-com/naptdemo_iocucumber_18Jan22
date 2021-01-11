package com.napt.ui.safeway.pages;

import com.napt.framework.ui.interactions.Clicks;
import com.napt.framework.ui.interactions.Element;
import com.napt.framework.ui.interactions.TextBoxes;
import com.napt.framework.ui.interactions.Wait;

public class Login {

    public void signIn(){

        Clicks.click("home.linkSignIn");
        Clicks.click("home.miSignIn");
        Wait.secondsUntilElementToBeClickable("signin.inputUsername",3);
        Element.findElement("signin.inputUsername").sendKeys("malavparekh@gmail.com");
        Element.findElement("signin.inputPassword").sendKeys("Blabla@1234");
        Clicks.click("signin.btnSignIn");

    }
}
