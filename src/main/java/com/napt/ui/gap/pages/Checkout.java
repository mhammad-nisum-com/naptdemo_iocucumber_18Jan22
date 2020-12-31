package com.napt.ui.gap.pages;

import com.napt.framework.ui.interactions.*;
import com.napt.ui.gap.entities.Address;

public class Checkout {


    PDP pdp = new PDP();

    public void guestCheckout(Address add)throws Exception{
        pdp.checkout();
        Thread.sleep(10000);
        Wait.secondsUntilElementToBeClickable("checkout_page.checkoutBtn",5);
        Clicks.click("checkout_page.checkoutBtn");
        Wait.secondsUntilElementPresentAndClick("checkout_page.signInGuest",5);
        Clicks.javascriptClick("checkout_page.signInGuest");
        TextBoxes.typeTextbox("checkout_page.guestcheckoutEmail",add.getEmail());
        Wait.secondsUntilElementToBeClickable("checkout_page.guestcheckoutContinueAsGuest",5);
        Element.moveToElement("checkout_page.guestcheckoutContinueAsGuest");
        Clicks.click("checkout_page.guestcheckoutContinueAsGuest");
        TextBoxes.typeTextbox("checkout_page.guestcheckoutfullName",add.getFullName());
        TextBoxes.typeTextbox("checkout_page.guestcheckoutstreetAddress",add.getStreetAddress());
        TextBoxes.typeTextbox("checkout_page.guestcheckoutAptUnit",add.getAptUnit());
        TextBoxes.typeTextbox("checkout_page.guestcheckoutTown",add.getCity());
        DropDowns.selectByValue("checkout_page.guestcheckoutState",add.getState());
        TextBoxes.typeTextbox("checkout_page.guestcheckoutZipCode",add.getZip());
        TextBoxes.typeTextbox("checkout_page.guestcheckoutPhone",add.getPhone());
        Element.findElement("checkout_page.guestcheckoutContinueToPay");
    }


}
